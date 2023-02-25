package com.example.banksystemservlet.result;

import com.example.banksystemservlet.domain.member.Member;

public record MemberResult(String message, boolean result, Member member) {

    public MemberResult(String message, boolean result) {
        this(message,result ,null);
    }

    public boolean isSuccess() {
        return result;
    }
}
