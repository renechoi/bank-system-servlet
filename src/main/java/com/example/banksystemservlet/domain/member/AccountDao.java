package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    public static final int initialAmount = 1000;
    private JdbcTemplate jdbcTemplate;
    private List<Account> accounts = new ArrayList<>();

    public AccountManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Member member, int memberCount) {
        Account account = new Account(generateAccountNumber(memberCount), initialAmount, member.getMemberId());
        accounts.add(account);
    }

    public void delete(String currentlyLogin) {
        accounts.remove(accounts
                .stream()
                .filter(account -> account.getMemberId().equals(currentlyLogin))
                .findFirst()
                .get());
    }

    public void deposit(Member member, int amount) {
        getAccount(member).addAmount(amount);
    }

    public void withdraw(Member member, int amount) {
        getAccount(member).subtractAmount(amount);
    }

    private static int generateAccountNumber(int memberCount) {
        return 1111 + ((memberCount - 1) * 1111);
    }

    private Account getAccount(Member member) {
        return accounts.stream()
                .filter(account -> account.matchId(member.getMemberId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾는 아이디가 없습니다"));
    }

    public int getAccountNumber(Member member) {
        return getAccount(member).getAccountNumber();
    }

    public int getBalance(Member member) {
        return getAccount(member).getBalance();
    }
}
