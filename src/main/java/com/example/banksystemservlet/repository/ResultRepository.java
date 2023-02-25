package com.example.banksystemservlet.repository;

import com.example.banksystemservlet.result.BankResult;
import com.example.banksystemservlet.result.BoardResult;
import com.example.banksystemservlet.result.MemberResult;

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
