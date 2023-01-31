package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class MemberManagerTest {
    @Test
    void createTest() throws SQLException {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        MemberManager memberManager = new MemberManager(jdbcTemplate);

        Member member = new Member("홍길동","1234", "1234");
        memberManager.add2(member);

        ResultSet resultSet = jdbcTemplate.executeQuery("SELECT memberid FROM member");
        String memberId="";
        while (resultSet.next()) {
            memberId = resultSet.getString("memberid");
        }

        assertThat(member.matchId(memberId)).isTrue();

    }
}