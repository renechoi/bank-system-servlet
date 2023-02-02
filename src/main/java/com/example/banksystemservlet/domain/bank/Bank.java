package com.example.banksystemservlet.domain.bank;

import com.example.banksystemservlet.domain.member.AccountDao;
import com.example.banksystemservlet.domain.member.InfoMessage;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.domain.member.MemberDao;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
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

    public Bank(MemberDao MEMBER_DAO, AccountDao ACCOUNT_DAO) {
//        this.MEMBER_DAO = MEMBER_DAO;
//        this.ACCOUNT_DAO = ACCOUNT_DAO;
    }

    public Result register2(Member member) {
        validateRegisterId(member);
        try {
            MEMBER_DAO.add2(member);
            ACCOUNT_DAO.create2(member, MEMBER_DAO.getMemberCount());
        } catch (RuntimeException | SQLException e) {
            return new Result("회원 가입에 실패하였습니다", false);
        }
        return new Result("회원 가입에 성공하였습니다", true);
    }

    public Result unRegister2() {
        validateLoginOff();
        try {
            MEMBER_DAO.delete2(validateLoginId(currentlyLogin));
            ACCOUNT_DAO.delete2(currentlyLogin);
        } catch (RuntimeException | SQLException e) {
            return new Result("회원 탈퇴에 실패하였습니다", false);
        }
        setLoginStatusNone();
        return new Result("회원 탈퇴에 성공하였습니다", true);
    }

    public Result login2(String requestedId, String requestedPassword) {
        try {
            validateLoginOn();
            this.currentlyLogin = validateLoginIdAndPassword2(requestedId, requestedPassword);
        } catch (RuntimeException | SQLException e) {
            return new Result("로그인에 실패하였습니다 \n" + e.getMessage(), false);
        }
        return new Result("로그인에 성공하였습니다", true);
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

    public Result deposit2(int amount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.deposit2(currentlyLogin, amount);
        } catch (RuntimeException | SQLException e) {
            return new Result("입금에 실패하였습니다", false);
        }
        return new Result("입금에 성공하였습니다", true);
    }

    public Result deposit(int amount) {
        validateLoginOff();
        try {
            Member member = MEMBER_DAO.getMember(currentlyLogin);
            ACCOUNT_DAO.deposit(member, amount);
        } catch (RuntimeException e) {
            return new Result("입금에 실패하였습니다", false);
        }
        return new Result("입금에 성공하였습니다", true);
    }

    public Result withdraw2(int amount) {
        validateLoginOff();
        try {
            Member member = MEMBER_DAO.getMember2(currentlyLogin);
            ACCOUNT_DAO.withdraw2(currentlyLogin, amount);
        } catch (RuntimeException | SQLException e) {
            return new Result("출금에 실패하였습니다", false);
        }
        return new Result("출금에 성공하였습니다", true);
    }

    public Result withdraw(int amount) {
        validateLoginOff();
        try {
            Member member = MEMBER_DAO.getMember(currentlyLogin);
            ACCOUNT_DAO.withdraw(member, amount);
        } catch (RuntimeException e) {
            return new Result("출금에 실패하였습니다", false);
        }
        return new Result("출금에 성공하였습니다", true);
    }

    public Result transfer2(String requestMemberId, int requestTransferAmount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.withdraw2(currentlyLogin, requestTransferAmount);
            ACCOUNT_DAO.deposit2(requestMemberId, requestTransferAmount);
        } catch (RuntimeException | SQLException e) {
            return new Result("송금에 실패하였습니다", false);
        }
        return new Result("송금에 성공하였습니다", true);
    }

    public Result transfer(String requestMemberId, int requestTransferAmount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.withdraw(MEMBER_DAO.getMember(currentlyLogin), requestTransferAmount);
            ACCOUNT_DAO.deposit(MEMBER_DAO.getMember(requestMemberId), requestTransferAmount);
        } catch (RuntimeException e) {
            return new Result("송금에 실패하였습니다", false);
        }
        return new Result("송금에 성공하였습니다", true);
    }

    public Result checkBalance2(HttpServletRequest request, HttpServletResponse response) {
        try {
            showAccount2(request, response);
        } catch (SQLException | UnsupportedEncodingException | JsonProcessingException e) {
            return new Result("조회에 실패하였습니다", false);
        }
        return new Result("조회에 성공하였습니다", true);
    }

    public Result checkBalance() {
        showAccount();
        return new Result("조회에 성공하였습니다", true);
    }

    public Result quit() {
        return new Result("종료합니다", true);
    }

    private void setLoginStatusNone() {
        this.currentlyLogin = "-1";
    }

    private void validateRegisterId(Member member) {
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

    public String validateLoginIdAndPassword2(String requestedId, String requestedPassword) throws SQLException {
        if (!MEMBER_DAO.match2(requestedId, requestedPassword)) {
            throw new IllegalArgumentException("로그인 가능한 아이디가 없거나 비밀번호가 일치하지 않습니다");
        }
        return requestedId;
    }

    public String validateLoginIdAndPassword(String requestedId, String requestedPassword) {
        if (!MEMBER_DAO.match(requestedId, requestedPassword)) {
            throw new IllegalArgumentException("로그인 가능한 아이디가 없거나 비밀번호가 일치하지 않습니다");
        }
        return requestedId;
    }

    public void showCurrentlyLogin() {
        Runnable show = currentlyLogin.equals("-1") ?
                () -> System.out.print("") :
                () -> System.out.printf("[시스템] 현재 로그인한 계정: %s\n", currentlyLogin);
        show.run();
    }

    public void showAccount2(HttpServletRequest request, HttpServletResponse response) throws SQLException, UnsupportedEncodingException, JsonProcessingException {
        Member member = MEMBER_DAO.getMember2(currentlyLogin);
        int memberNumber = member.getMemberNumber();
        int accountNumber = ACCOUNT_DAO.getAccountNumber2(member);
        String name = member.getName();
        String memberId = member.getMemberId();
        int balance = ACCOUNT_DAO.getBalance2(member);

        String message = String.format("""
                        <잔액 조회>
                        고객번호: %s
                        계좌번호: %s
                        계좌명: %s
                        아이디: %s
                        잔액: %s
                        """,
                memberNumber,
                accountNumber,
                name,
                memberId,
                balance
        );

        InfoMessage infoMessage = InfoMessage.of(memberNumber, accountNumber, name, memberId, balance);
        request.setAttribute("infoMessage", infoMessage);
    }

    public void showAccount() {
        Member member = MEMBER_DAO.getMember(currentlyLogin);
        System.out.println(String.format("""
                        <잔액 조회>
                        고객번호: %s
                        계좌번호: %s
                        계좌명: %s
                        아이디: %s
                        잔액: %s  
                        """,
                member.getMemberNumber(),
                ACCOUNT_DAO.getAccountNumber(member),
                member.getName(),
                member.getMemberId(),
                ACCOUNT_DAO.getBalance(member)
        ));
    }
}
