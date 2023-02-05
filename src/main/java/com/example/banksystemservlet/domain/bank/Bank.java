package com.example.banksystemservlet.domain.bank;

import com.example.banksystemservlet.domain.member.AccountDao;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.domain.member.MemberDao;
import com.example.banksystemservlet.domain.member.MemberData;

import java.sql.SQLException;

public class Bank {

    private final MemberDao MEMBER_DAO = new MemberDao();
    private final AccountDao ACCOUNT_DAO = new AccountDao();
    private String currentlyLogin = "-1";

    private static final Bank instance = new Bank();

    private Bank() {
    }

    public static Bank getInstance() {
        return instance;
    }

    public Result register(Member member) {
        try {
            validateRegisterId(member);
            MEMBER_DAO.add(member);
            ACCOUNT_DAO.create2(member, MEMBER_DAO.getMemberCount());
        } catch (RuntimeException | SQLException e) {
            return new Result("회원 가입에 실패하였습니다", false);
        }
        return new Result("회원 가입에 성공하였습니다", true);
    }

    public Result unRegister() {
        validateLoginOff();
        try {
            MEMBER_DAO.delete(validateLoginId(currentlyLogin));
            ACCOUNT_DAO.delete2(currentlyLogin);
        } catch (RuntimeException | SQLException e) {
            return new Result("회원 탈퇴에 실패하였습니다", false);
        }
        setLoginStatusNone();
        return new Result("회원 탈퇴에 성공하였습니다", true);
    }

    public Result login(String requestedId, String requestedPassword) {
        try {
            validateLoginOn();
            this.currentlyLogin = validateLoginIdAndPassword(requestedId, requestedPassword);
            return new Result("로그인에 성공하였습니다", true, createMemberData());
        } catch (RuntimeException | SQLException e) {
            return new Result("로그인에 실패하였습니다 \n" + e.getMessage(), false);
        }
    }

    public Result logout() {
        try {
            validateLoginId(currentlyLogin);
        } catch (RuntimeException e) {
            return new Result("로그아웃에 실패하였습니다", false);
        }
        setLoginStatusNone();
        return new Result("로그아웃에 성공하였습니다", true);
    }

    public Result deposit(int amount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.deposit2(currentlyLogin, amount);
        } catch (RuntimeException | SQLException e) {
            return new Result("입금에 실패하였습니다", false);
        }
        return new Result("입금에 성공하였습니다", true);
    }

    public Result withdraw(int amount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.withdraw2(currentlyLogin, amount);
        } catch (RuntimeException | SQLException e) {
            return new Result("출금에 실패하였습니다", false);
        }
        return new Result("출금에 성공하였습니다", true);
    }

    public Result transfer(String requestMemberId, int requestTransferAmount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.withdraw2(currentlyLogin, requestTransferAmount);
            ACCOUNT_DAO.deposit2(requestMemberId, requestTransferAmount);
        } catch (RuntimeException | SQLException e) {
            return new Result("송금에 실패하였습니다", false);
        }
        return new Result("송금에 성공하였습니다", true);
    }

    public Result checkBalance() {
        try {
            return new Result("조회에 성공하였습니다", true, createMemberData());
        } catch (SQLException e) {
            return new Result("조회에 실패하였습니다", false);
        }
    }

    public Result quit() {
        return new Result("종료합니다", true);
    }

    public void showCurrentlyLogin() {
        Runnable show = currentlyLogin.equals("-1") ?
                () -> System.out.print("") :
                () -> System.out.printf("[시스템] 현재 로그인한 계정: %s\n", currentlyLogin);
        show.run();
    }

    private MemberData createMemberData() throws SQLException {
        Member member = MEMBER_DAO.getMemberCurrentlyLogin(currentlyLogin);

        return MemberData.of(
                currentlyLogin,
                member.getMemberNumber(),
                member.getName(),
                member.getMemberId(),
                member.getPassword(),
                ACCOUNT_DAO.getAccountNumber2(member),
                ACCOUNT_DAO.getBalance2(member)
        );
    }

    private void setLoginStatusNone() {
        this.currentlyLogin = "-1";
    }

    private void validateRegisterId(Member member) throws SQLException {
        if (MEMBER_DAO.exist(member)) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
    }

    private void validateLoginOff() {
        if (currentlyLogin.equals("-1")) {
            throw new IllegalArgumentException("로그인이 되어 있지 않습니다.");
        }
    }

    private void validateLoginOn() {
        if (!currentlyLogin.equals("-1")) {
            throw new IllegalArgumentException("현재 로그인이 되어 있습니다.");
        }
    }

    private String validateLoginId(String requestedId) {
        if (!currentlyLogin.equals(requestedId)) {
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");
        }
        return requestedId;
    }

    public String validateLoginIdAndPassword(String requestedId, String requestedPassword) throws SQLException {
        if (!MEMBER_DAO.match(requestedId, requestedPassword)) {
            throw new IllegalArgumentException("로그인 가능한 아이디가 없거나 비밀번호가 일치하지 않습니다");
        }
        return requestedId;
    }
}
