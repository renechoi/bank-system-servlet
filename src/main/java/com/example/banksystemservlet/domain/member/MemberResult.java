package com.example.banksystemservlet.domain.member;

public record MemberResult(String message, boolean result, Member member) {

    public MemberResult(String message, boolean result) {
        this(message,result ,null);
    }

    public boolean isSuccess() {
        return result;
    }
}
