package com.example.banksystemservlet.domain.bank;

import com.example.banksystemservlet.result.Result;
import com.example.banksystemservlet.domain.member.MemberData;

import java.util.Objects;

public class BankResult implements Result {
    private final String message;
    private final boolean result;
    private final MemberData memberData;
    private final Account account;

    public BankResult(String message, boolean result) {
        this(message, result, MemberData.of(
                "not login",
                0,
                "not login",
                "not login",
                "not login",
                0,
                0));
    }

    public BankResult(String message, boolean result, MemberData memberData) {
        this(message, result, memberData, null);
    }

    public BankResult(String message, boolean result, MemberData memberData, Account account) {
        this.message = message;
        this.result = result;
        this.memberData = memberData;
        this.account = account;
    }

    public boolean isSuccess() {
        return result;
    }

    public MemberData getData() {
        return memberData;
    }

    public String getMessage() {
        return message;
    }

    public void show() {
        System.out.println(message + "\n");
    }

    public boolean isQuit() {
        return message.equals("종료합니다");
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankResult bankResult1 = (BankResult) o;
        return result == bankResult1.result && Objects.equals(message, bankResult1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, message);
    }
}
