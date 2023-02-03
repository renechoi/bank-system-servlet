package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.jdbc.RowMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("멤버 테스트")
class MemberDaoTest {

    // TODO : 실제 db 연동을 하는 테스트 코드를 짤 때 데이터 베이스에 반영이 되기 때문에 rollback 기능이 필요하다.

    @DisplayName("멤버 객체 생성 후 db 저장을 확인한다")
    @Test
    void insertTest() throws SQLException {

        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        MemberDao memberDao = new MemberDao(jdbcTemplate);

        Member member = new Member("홍길동","1234", "1234");
        memberDao.add2(member);

        ResultSet resultSet = jdbcTemplate.executeQuery("SELECT memberid FROM member");
        String memberId="";
        while (resultSet.next()) {
            memberId = resultSet.getString("memberid");
        }

        assertThat(member.matchId(memberId)).isTrue();
    }

    @DisplayName("멤버 저장 개수를 검증한다")
    @Test
    void countTest() throws SQLException {
        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        MemberDao memberDao = new MemberDao(jdbcTemplate);

        Member member = new Member("홍길동","1234", "1234");

        int previous = memberDao.getMemberCount2();

        memberDao.add2(member);

        int afterwards = memberDao.getMemberCount2();

        assertThat(afterwards).isEqualTo(previous + 1);
    }

    @Test
    void deleteTest() throws SQLException {
        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        MemberDao memberDao = new MemberDao(jdbcTemplate);

        Member member = new Member("홍길동","1234", "1234");
        memberDao.add2(member);

        memberDao.delete2(member.getMemberId());

        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT membernumber, name, memberid, password
                        FROM member
                        WHERE memberId = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, member.getMemberId()));

        Member memberFound = matchMember(resultSet, resultSet2 -> new Member(
              resultSet2.getInt("membernumber"),
              resultSet2.getString("name"),
              resultSet2.getString("memberid"),
              resultSet2.getString("password")
        ));

        assertThat(memberFound).isNull();
    }

    @Test
    void existTest() throws SQLException {
        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        MemberDao memberDao = new MemberDao(jdbcTemplate);

        Member member = new Member("홍길동","123333333", "1234");

        memberDao.exist(member);
    }

    private Member matchMember(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        if (resultSet.next()) {
            return (Member) rowMapper.mapRow(resultSet);
        }
        return null;
    }




}