package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.bank.Account;
import com.example.banksystemservlet.domain.bank.AccountDao;
import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.jdbc.RowMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@DisplayName("계좌 테스트")
class AccountTest {

    @DisplayName("계좌 생성 후 db 저장을 확인한다")
    @Test
    void createTest() throws SQLException {

        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        MemberDao memberDao = new MemberDao(jdbcTemplate);

        Member member = new Member("홍길동","1234", "1234");
        memberDao.add(member);

        AccountDao accountDao = new AccountDao(jdbcTemplate);
        accountDao.create2(member, memberDao.getMemberCount());

        ResultSet resultSet = jdbcTemplate.executeQuery("SELECT memberid FROM account");
        String memberId="";
        while (resultSet.next()) {
            memberId = resultSet.getString("memberid");
        }
        assertThat(member.getMemberId()).isEqualTo(memberId);
    }

    @Test
    void deleteTest() throws SQLException {
        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        MemberDao memberDao = new MemberDao(jdbcTemplate);

        String memberId = "1234";
        Member member = new Member("홍길동",memberId, "1234");
        memberDao.add(member);

        AccountDao accountDao = new AccountDao(jdbcTemplate);
        accountDao.create2(member, memberDao.getMemberCount());

        accountDao.delete2(memberId);

        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT accountnumber, balance, memberid
                        FROM account
                        WHERE memberId = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, memberId));

        Account accountFound = matchAccount(resultSet, resultSet2 -> new Account(
                resultSet2.getInt("accountnumber"),
                resultSet2.getInt("balance"),
                resultSet2.getString("memberid")
        ));

        assertThat(accountFound).isNull();

    }

    private Account matchAccount(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        if (resultSet.next()) {
            return (Account) rowMapper.mapRow(resultSet);
        }
        return null;
    }
}