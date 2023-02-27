package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.bank.BankManager;
import com.example.banksystemservlet.jdbc.JdbcTemplate;
import com.example.banksystemservlet.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    private static final MemberDao instance = new MemberDao();
    private JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();

    public MemberDao() {
    }

    public static MemberDao getInstance() {
        return instance;
    }

    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Member member) throws SQLException {
        jdbcTemplate.executeInsert("INSERT INTO member VALUES (?, ?, ?, ?, ?, ?)", preparedStatement -> {
            preparedStatement.setString(1, assignMemberNumber());
            preparedStatement.setString(2, member.getName());
            preparedStatement.setString(3, member.getMemberId());
            preparedStatement.setString(4, member.getPassword());
            preparedStatement.setString(5, member.getEmail());
            preparedStatement.setString(6, member.getAddress());
        });
    }

    private List<Member> readAll() throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery(
                """
                        SELECT
                        member.membernumber,
                        member.name,
                        member.memberid,
                        member.password
                        FROM Member member
                        """);

        List<Member> members = new ArrayList<>();

        while (resultSet.next()) {
            members.add(new Member(
                    resultSet.getInt("membernumber"),
                    resultSet.getString("name"),
                    resultSet.getString("memberid"),
                    resultSet.getString("password")));
        }
        return members;
    }

    public void delete(String requestedId) throws SQLException {
        jdbcTemplate.executeDelete("DELETE FROM member WHERE memberid = ?", preparedStatement ->
                preparedStatement.setString(1, requestedId));
    }

    public boolean exist(Member requestedMember) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT memberId
                        FROM member
                        WHERE memberId = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, requestedMember.getMemberId()));
        return resultSet.next();
    }

    public boolean exist(String memberId) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT memberId
                        FROM member
                        WHERE memberId = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, memberId));
        return resultSet.next();
    }

    public Member getMemberCurrentlyLogin(String currentlyLogin) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT membernumber, name, memberid, password
                        FROM member
                        WHERE memberId = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, currentlyLogin));

        return matchMember(resultSet, resultSet2 -> new Member(
                resultSet2.getInt("membernumber"),
                resultSet2.getString("name"),
                resultSet2.getString("memberid"),
                resultSet2.getString("password")
        ));
    }

    public Member getMember(String memberId, String password) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT membernumber, name, memberid, password, email, address
                        FROM member
                        WHERE memberId = ? and password = ?
                        """,
                preparedStatement -> {
                    preparedStatement.setString(1, memberId);
                    preparedStatement.setInt(2, Integer.parseInt(password));
                });

        return matchMember(resultSet, resultSet2 -> new Member(
                resultSet2.getInt("membernumber"),
                resultSet2.getString("name"),
                resultSet2.getString("memberid"),
                resultSet2.getString("password"),
                resultSet2.getString("email"),
                resultSet2.getString("address")

        ));
    }

    public int getMemberCount() throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                select count(*)
                from MEMBER
                """);
        int count = 0;
        while (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return count;
    }

    private String assignMemberNumber() throws SQLException {
        return String.valueOf(1000 + getMemberCount() - 1);
    }

    public boolean match(String requestedId, String requestedPassword) throws SQLException {
        return readAll().stream()
                .anyMatch(member -> member.matchIdAndPassword(requestedId, requestedPassword));
    }

    private Member matchMember(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        if (resultSet.next()) {
            return (Member) rowMapper.mapRow(resultSet);
        }
        return null;
    }

}
