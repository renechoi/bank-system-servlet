package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    public static final int initialAmount = 1000;
    private JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
    private List<Account> accounts = new ArrayList<>();

    public AccountDao() {
    }

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

    public void delete2(String currentlyLogin) throws SQLException {
        jdbcTemplate.executeDelete("DELETE FROM account WHERE memberid = ?", preparedStatement ->
                preparedStatement.setString(1, currentlyLogin));
    }

    public void deposit2(String currentLoginId, int amount) throws SQLException {
        // TODO : update 하는 금액이 하드코딩되어 있다.'
        int i = jdbcTemplate.executeUpdate("""
                                UPDATE ACCOUNT account
                                SET account.balance = ?
                                WHERE account.memberid = ?
                """, preparedStatement -> {
            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, currentLoginId);
        });
    }

    public void withdraw2(String currentLoginId, int amount) throws SQLException {
        // TODO : update 하는 금액이 하드코딩되어 있다.
        jdbcTemplate.executeUpdate("""
                                UPDATE ACCOUNT account
                                SET account.balance = ?
                                WHERE account.memberid = ?
                """, preparedStatement -> {
            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, currentLoginId);
        });
    }

    private static int generateAccountNumber(int memberCount) {
        return 1111 + ((memberCount - 1) * 1111);
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
