package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.jdbc.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {

    private JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();

    public void post(String title, String content, MemberData bankMemberData) throws SQLException {
        jdbcTemplate.executeInsert("INSERT INTO article VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", preparedStatement -> {
            preparedStatement.setLong(1, assignArticleNumber());
            preparedStatement.setString(2, bankMemberData.currentlyLogin());
            preparedStatement.setString(3, bankMemberData.name());
            preparedStatement.setString(4, title);
            preparedStatement.setString(5, content);
            preparedStatement.setString(6, "hashtag1");
            preparedStatement.setDate(7, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(8, bankMemberData.name());
            preparedStatement.setDate(9, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(10, bankMemberData.name());
        });
    }

    public List<Article> readAll() throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery(
                """
                        SELECT
                        article.id,
                        article.memberId,
                        article.memberName,
                        article.title,
                        article.content,
                        article.hashtag,
                        article.createdAt,
                        article.createdBy,
                        article.modifiedAt,
                        article.modifiedBy
                        FROM Article article
                        """);

        List<Article> articles = new ArrayList<>();

        while (resultSet.next()) {
            articles.add(new Article(
                    resultSet.getLong("id"),
                    resultSet.getString("memberId"),
                    resultSet.getString("memberName"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getString("hashtag"),
                    resultSet.getDate("createdAt"),
                    resultSet.getString("createdBy"),
                    resultSet.getDate("modifiedAt"),
                    resultSet.getString("modifiedBy")
            ));
        }
        return articles;
    }

    public void update() throws SQLException {
        jdbcTemplate.executeUpdate("""
                                update ARTICLE article
                                set article.TITLE = ?,
                                article.CONTENT = ?,
                                article.HASHTAG = ?
                                where article.MEMBERID = ?
                """, preparedStatement -> {
            preparedStatement.setString(1, "title-updated");
            preparedStatement.setString(2, "content-updated");
            preparedStatement.setString(3, "hashtag-updated");
            preparedStatement.setString(4, "memberId");

        });
    }

    public void delete() throws SQLException {
            jdbcTemplate.executeDelete("DELETE FROM article WHERE memberid = ?",
                    preparedStatement -> preparedStatement.setString(1, "memberId1"));
    }

    private long assignArticleNumber() throws SQLException {
        return  getArticleCount();
    }

    public int getArticleCount() throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                select count(*)
                from Article
                """);
        int count = 0;
        while (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return count;
    }

    public void getArticleById(String articleId) throws SQLException {
//        ResultSet resultSet = jdbcTemplate.executeQuery("""
//                        SELECT memberName, title, content, hashtag, createdAt, createdBy, modifiedAt, modifiedBy
//                        FROM ARTICLE
//                        WHERE id = ?
//                        """,
//                preparedStatement -> preparedStatement.setString(1, articleId));
//
//        return matchArticle(resultSet, resultSet2 -> new Article(
//                resultSet2.getInt("accountnumber"),
//                resultSet2.getInt("balance"),
//                resultSet2.getString("memberId")
//        ));

    }

    private Article matchArticle(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        if (resultSet.next()) {
            return (Article) rowMapper.mapRow(resultSet);
        }
        return null;

    }

}


//        Long id,
//        String memberId,
//        String memberName,
//        String title,
//        String content,
//        String hashtag,
//        LocalDateTime createdAt,
//        String createdBy,
//        LocalDateTime modifiedAt,
//        String modifiedBy