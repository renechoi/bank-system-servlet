package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.jdbc.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberManager {
    private JdbcTemplate jdbcTemplate;
    private List<Member> members = new ArrayList<>();

    public MemberManager() {
    }

    public MemberManager(Member... members) {
        this.members = Arrays.asList(members);
    }

    public MemberManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add2(Member member) throws SQLException {
        String number = createMemberNumber(member);
        // membernumber , name, memberId, password
        jdbcTemplate.executeInsert("INSERT INTO member VALUES (?, ?, ?, ?)", preparedStatement -> {
            preparedStatement.setString(1, number);
            preparedStatement.setString(2, member.getName());
            preparedStatement.setString(3, member.getMemberId());
            preparedStatement.setString(4, member.getPassword());
        });
//        members.add(member);
    }

    private String createMemberNumber(Member member) {
        return "1";
    }

    public void add(Member member) {
        members.add(member);
        assignMemberNumber(member);
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

    public Member getMember(String currentlyLogin) {
        return members.stream()
                .filter(member -> member.matchId(currentlyLogin))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾는 아이디가 없습니다"));
    }

    public int getMemberCount() {
        return members.size();
    }

    private void assignMemberNumber(Member member) {
        member.setMemberNumber(1000 + getMemberCount() - 1);
    }
}
