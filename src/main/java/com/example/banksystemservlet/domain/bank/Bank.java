package com.example.banksystemservlet.domain.bank;

import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.domain.member.MemberDao;
import com.example.banksystemservlet.domain.member.MemberData;
import com.example.banksystemservlet.domain.member.MemberResult;

import java.sql.SQLException;

public class Bank {

    private final MemberDao MEMBER_DAO = new MemberDao();
    private final AccountDao ACCOUNT_DAO = new AccountDao();
    private String currentlyLogin = "-1";

    private static final Bank instance = new Bank();

    public Bank() {
    }

    public static Bank getInstance() {
        return instance;
    }

    public BankResult createAccount(String memberId, String password) {
        try {
            // TODO : password 검증 로직 구현
            Account account = ACCOUNT_DAO.create(memberId);
            return new BankResult("계좌 생성 성공하였습니다", true, null, account);
        } catch (RuntimeException | SQLException e) {
            return new BankResult("계좌 생성 실패하였습니다", false);
        }
    }

    public BankResult register(Member member) {
        try {
            validateRegisterId(member);
            MEMBER_DAO.add(member);
//            ACCOUNT_DAO.create(member, MEMBER_DAO.getMemberCount());
            this.currentlyLogin = member.getMemberId();
            return new BankResult("회원 가입에 성공하였습니다", true, createMemberData());
        } catch (RuntimeException | SQLException e) {
            return new BankResult("회원 가입에 실패하였습니다", false);
        }
    }


    public MemberResult unRegister() {
        validateLoginOff();
        try {
            MEMBER_DAO.delete(validateLoginId(currentlyLogin));
            setLoginStatusNone();
            return new MemberResult("회원 탈퇴에 성공하였습니다", true);
        } catch (RuntimeException | SQLException e) {
            return new MemberResult("회원 탈퇴에 실패하였습니다", false);
        }
    }

    public MemberResult login(String requestedId, String requestedPassword) {
        try {
            validateLoginOn();
//            Member member = getMember(requestedId, requestedPassword);
//            member.setLoginStatus(true);
            this.currentlyLogin = validateLoginIdAndPassword(requestedId, requestedPassword);
            return new MemberResult("로그인에 성공하였습니다", true, null);
        } catch (RuntimeException | SQLException e) {
            return new MemberResult("로그인에 실패하였습니다 \n" + e.getMessage(), false);
        }
    }

    public MemberResult logout() {
        try {
            setLoginStatusNone();
            return new MemberResult("로그아웃에 성공하였습니다", true, null);
        } catch (RuntimeException e) {
            return new MemberResult("로그아웃에 실패하였습니다", false);
        }
    }

    public BankResult deposit(int amount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.deposit2(currentlyLogin, amount);
            return new BankResult("입금에 성공하였습니다", true, createMemberData());
        } catch (RuntimeException | SQLException e) {
            return new BankResult("입금에 실패하였습니다", false);
        }
    }

    public BankResult withdraw(int amount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.withdraw2(currentlyLogin, amount);
            return new BankResult("출금에 성공하였습니다", true, createMemberData());
        } catch (RuntimeException | SQLException e) {
            return new BankResult("출금에 실패하였습니다", false);
        }
    }

    public BankResult transfer(String requestMemberId, int requestTransferAmount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.withdraw2(currentlyLogin, requestTransferAmount);
            ACCOUNT_DAO.deposit2(requestMemberId, requestTransferAmount);
            return new BankResult("송금에 성공하였습니다", true, createMemberData());
        } catch (RuntimeException | SQLException e) {
            return new BankResult("송금에 실패하였습니다", false);
        }
    }

    public BankResult checkBalance() {
        try {
            return new BankResult("조회에 성공하였습니다", true, createMemberData());
        } catch (SQLException e) {
            return new BankResult("조회에 실패하였습니다", false);
        }
    }

    public BankResult quit() {
        return new BankResult("종료합니다", true);
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
