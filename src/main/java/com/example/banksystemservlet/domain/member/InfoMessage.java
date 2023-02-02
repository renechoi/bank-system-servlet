package com.example.banksystemservlet.domain.member;

public record InfoMessage(int memberNumber, int accountNumber, String name, String memberId, int balance) {

    public static InfoMessage of(int memberNumber, int accountNumber, String name, String memberId, int balance) {
        return new InfoMessage(memberNumber, accountNumber, name, memberId, balance);
    }
}
