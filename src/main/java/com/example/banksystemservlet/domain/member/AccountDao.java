package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    public static final int initialAmount = 1000;
    private JdbcTemplate jdbcTemplate;
    private List<Account> accounts = new ArrayList<>();

    // accountnumber balance memberid

    public AccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void create2(Member member, int memberCount) throws SQLException {
        Account account = new Account(generateAccountNumber(memberCount), initialAmount, member.getMemberId());

        jdbcTemplate.executeInsert("INSERT INTO account VALUES (?, ?, ?)", preparedStatement -> {
            // TODO : 사실 위에서 정의한 value들을 사용하는 것이기 때문에 이것을 이렇게 꺼내오는 방식이 맞을지 고민
            preparedStatement.setInt(1, account.getAccountNumber());
            preparedStatement.setInt(2, account.getBalance());
            preparedStatement.setString(3, account.getMemberId());
        });


    }

    public void create(Member member, int memberCount) {
        Account account = new Account(generateAccountNumber(memberCount), initialAmount, member.getMemberId());
        accounts.add(account);
    }

    public void delete2(String currentlyLogin) throws SQLException {
        jdbcTemplate.executeDelete("DELETE FROM account WHERE memberid = ?", preparedStatement ->
                preparedStatement.setString(1, currentlyLogin));
    }

    public void delete(String currentlyLogin) {
        accounts.remove(accounts
                .stream()
                .filter(account -> account.getMemberId().equals(currentlyLogin))
                .findFirst()
                .get());
    }

    public void deposit2(Member member, int amount) throws SQLException {
        // TODO : update 하는 금액이 하드코딩되어 있다.
        jdbcTemplate.executeUpdate("""
                                UPDATE ACCOUNT account
                                SET author.accountbalance = ?,
                                WHERE account.memberid = ?
                """, preparedStatement -> {
            preparedStatement.setString(1, "1000");
            preparedStatement.setString(2, member.getMemberId());
        });
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

    private Account matchAccount(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        if (resultSet.next()) {
            return (Account) rowMapper.mapRow(resultSet);
        }
        return null;
    }
}
