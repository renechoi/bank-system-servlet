package com.example.banksystemservlet.domain.bank;

import com.example.banksystemservlet.domain.member.MemberData;

import java.util.Objects;

public class Result {
    private final String message;
    private final boolean result;
    private final MemberData memberData;

    public Result(String message, boolean result) {
        this(message, result, null);
//        this.message = message;
//        this.result = result;
    }

    public Result(String message, boolean result, MemberData memberData) {
        this.message = message;
        this.result = result;
        this.memberData = memberData;
    }

    public boolean isSuccess() {
        return result;
    }

    public MemberData getMemberData() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return result == result1.result && Objects.equals(message, result1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, message);
    }
}
