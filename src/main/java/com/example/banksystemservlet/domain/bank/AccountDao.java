package com.example.banksystemservlet.domain.bank;

import com.example.banksystemservlet.jdbc.JdbcTemplate;
import com.example.banksystemservlet.jdbc.RowMapper;
import com.example.banksystemservlet.domain.member.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class AccountDao {
    public static final int initialAmount = 1000;
    private JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();

    private static final AccountDao instance = new AccountDao();

    public AccountDao() {
    }

    public static AccountDao getInstance() {
        return instance;
    }

    public AccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account create(String memberId) throws SQLException {
        Account account = new Account(generateAccountNumber(), initialAmount, memberId);

        jdbcTemplate.executeInsert("INSERT INTO account VALUES (?, ?, ?)", preparedStatement -> {
            preparedStatement.setInt(1, account.getAccountNumber());
            preparedStatement.setInt(2, account.getBalance());
            preparedStatement.setString(3, account.getMemberId());
        });

        return account;
    }

    public void delete2(String currentlyLogin) throws SQLException {
        jdbcTemplate.executeDelete("DELETE FROM account WHERE memberid = ?", preparedStatement ->
                preparedStatement.setString(1, currentlyLogin));
    }

    public void deposit2(String currentLoginId, int amount) throws SQLException {
        int i = jdbcTemplate.executeUpdate("""
                                UPDATE ACCOUNT account
                                SET account.balance = balance + ?
                                WHERE account.memberid = ?
                """, preparedStatement -> {
            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, currentLoginId);
        });
    }

    public void withdraw2(String currentLoginId, int amount) throws SQLException {
        jdbcTemplate.executeUpdate("""
                                UPDATE ACCOUNT account
                                SET account.balance = balance - ?
                                WHERE account.memberid = ?
                """, preparedStatement -> {
            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, currentLoginId);
        });
    }

    private static int generateAccountNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return 1111 + ((randomNumber - 1) * 1000);
    }

    private Account getAccount2(Member member) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT accountnumber, balance, memberid
                        FROM account
                        WHERE memberId = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, member.getMemberId()));

        return matchAccount(resultSet, resultSet2 -> new Account(
                resultSet2.getInt("accountnumber"),
                resultSet2.getInt("balance"),
                resultSet2.getString("memberId")
        ));
    }

    public int getAccountNumber2(Member member) throws SQLException {
        return getAccount2(member).getAccountNumber();
    }

    public int getBalance2(Member member) throws SQLException {
        return getAccount2(member).getBalance();
    }

    private Account matchAccount(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        if (resultSet.next()) {
            return (Account) rowMapper.mapRow(resultSet);
        }
        return null;
    }
}
