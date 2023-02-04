package com.example.banksystemservlet.domain.member;

public record MemberData(String currentlyLogin, int memberNumber, String name, String memberId, String password, int accountNumber, int balance) {

    public static MemberData of(String currentlyLogin, int memberNumber, String name, String memberId, String password, int accountNumber, int balance) {
        return new MemberData(currentlyLogin, memberNumber, name, memberId, password, accountNumber, balance);
    }
}


