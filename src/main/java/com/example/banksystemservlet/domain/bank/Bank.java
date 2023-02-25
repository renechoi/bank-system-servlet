package com.example.banksystemservlet.domain.bank;

import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.domain.member.MemberDao;
import com.example.banksystemservlet.domain.member.MemberData;
import com.example.banksystemservlet.result.MemberResult;
import com.example.banksystemservlet.result.BankResult;
import com.example.banksystemservlet.repository.ResultRepository;

import java.sql.SQLException;

public class Bank {

    private final MemberDao MEMBER_DAO = new MemberDao();
    private final AccountDao ACCOUNT_DAO = new AccountDao();

    private static final Bank instance = new Bank();

    public Bank() {
    }

    public static Bank getInstance() {
        return instance;
    }

    public BankResult createAccount(String memberId, String password) {
        try {
            Account account = ACCOUNT_DAO.create(memberId);
            return new BankResult("계좌 생성 성공하였습니다", true, null, account);
        } catch (RuntimeException | SQLException e) {
            return new BankResult("계좌 생성 실패하였습니다", false);
        }
    }


    public BankResult deposit(int amount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.deposit2(getCurrentMemberId(), amount);
            return new BankResult("입금에 성공하였습니다", true, memberData());
        } catch (RuntimeException | SQLException e) {
            return new BankResult("입금에 실패하였습니다", false);
        }
    }

    public BankResult withdraw(int amount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.withdraw2(getCurrentMemberId(), amount);
            return new BankResult("출금에 성공하였습니다", true, memberData());
        } catch (RuntimeException | SQLException e) {
            return new BankResult("출금에 실패하였습니다", false);
        }
    }

    public BankResult transfer(String requestMemberId, int requestTransferAmount) {
        validateLoginOff();
        try {
            ACCOUNT_DAO.withdraw2(getCurrentMemberId(), requestTransferAmount);
            ACCOUNT_DAO.deposit2(requestMemberId, requestTransferAmount);
            return new BankResult("송금에 성공하였습니다", true, memberData());
        } catch (RuntimeException | SQLException e) {
            return new BankResult("송금에 실패하였습니다", false);
        }
    }

    public BankResult checkBalance() {
        try {
            return new BankResult("조회에 성공하였습니다", true, memberData());
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            return new BankResult("조회에 실패하였습니다", false);
        }
    }

    private MemberData memberData() throws SQLException {

        String currentMemberId = getCurrentMemberId();
        Member member = MEMBER_DAO.getMemberCurrentlyLogin(getCurrentMemberId());

        return MemberData.of(
                currentMemberId,
                member.getMemberNumber(),
                member.getName(),
                member.getMemberId(),
                member.getPassword(),
                ACCOUNT_DAO.getAccountNumber2(member),
                ACCOUNT_DAO.getBalance2(member)
        );
    }

    private static String getCurrentMemberId() {
        return getCurrentMember().getMemberId();
    }

    private static Member getCurrentMember() {
        MemberResult memberResult = ResultRepository.getMemberResult();
        return memberResult.member();
    }

    private void validateLoginOff() {
        if (!getCurrentMember().isLoginStatus()) {
            throw new IllegalArgumentException("로그인이 되어 있지 않습니다.");
        }
    }



}
