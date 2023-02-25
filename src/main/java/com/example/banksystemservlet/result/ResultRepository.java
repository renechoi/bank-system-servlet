package com.example.banksystemservlet.result;

import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.board.BoardResult;
import com.example.banksystemservlet.domain.member.MemberResult;

import java.util.Map;

public class ResultRepository {
    private static BankResult bankResult;
    private static BoardResult boardResult;
    private static MemberResult memberResult;

    public static void saveBankResult(Map<String, Object> model){
        bankResult = (BankResult) model.get("bankResult");
    }

    public static void saveMemberResult(Map<String, Object> model){
        memberResult = (MemberResult) model.get("memberResult");
    }

    public static BankResult getBankResult() {
        return bankResult;
    }

    public static BoardResult getBoardResult() {
        return boardResult;
    }

    public static MemberResult getMemberResult() {
        return memberResult;
    }
}
