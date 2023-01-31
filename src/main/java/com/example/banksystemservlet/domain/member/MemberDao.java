package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;
    private List<Member> members = new ArrayList<>();

    // membernumber , name, memberId, password

    public MemberDao() {
    }

    public MemberDao(Member... members) {
        this.members = Arrays.asList(members);
    }

    public MemberDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add2(Member member) throws SQLException {
        String number = createMemberNumber(member);
        jdbcTemplate.executeInsert("INSERT INTO member VALUES (?, ?, ?, ?)", preparedStatement -> {
            preparedStatement.setString(1, number);
            preparedStatement.setString(2, member.getName());
            preparedStatement.setString(3, member.getMemberId());
            preparedStatement.setString(4, member.getPassword());
        });
    }

    private String createMemberNumber(Member member) {
        return "1";
    }

    public void add(Member member) {
        members.add(member);
        assignMemberNumber(member);
    }

    public void delete2(String requestedId) throws SQLException {
        jdbcTemplate.executeDelete("DELETE FROM member WHERE memberid = ?", preparedStatement ->
                preparedStatement.setString(1, requestedId));

    }

    public void delete(String requestedId) {
        members.remove(getMember(requestedId));
    }

    public boolean exist(String requestedId) {
        return members.stream().anyMatch(member -> member.matchId(requestedId));
    }

    public boolean exist(Member requestedMember) {
        return members.stream().anyMatch(member -> member.equals(requestedMember));
    }

    public boolean match(String requestedId, String requestedPassword) {
        return members.stream()
                .anyMatch(member -> member.matchIdAndPassword(requestedId, requestedPassword));
    }

    public Member getMember2(String currentlyLogin) throws SQLException {
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

    public Member getMember(String currentlyLogin) {
        return members.stream()
                .filter(member -> member.matchId(currentlyLogin))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾는 아이디가 없습니다"));
    }

    public int getMemberCount() {
        return members.size();
    }

    public int getMemberCount2() throws SQLException {
        // TODO : while 안 쓰고 하는 법이 있는지....
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                select count(*)
                from MEMBER
                """);
        int count = 0;
        while (resultSet.next()){
            count = resultSet.getInt(1);
        }
        return count;
    }

    private void assignMemberNumber(Member member) {
        member.setMemberNumber(1000 + getMemberCount() - 1);
    }

    private Member matchMember(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        if (resultSet.next()) {
            return (Member) rowMapper.mapRow(resultSet);
        }
        return null;
    }
}
