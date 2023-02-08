package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.jdbc.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticleDao {

    private JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();

    public void writeArticle(String title, String content, MemberData bankMemberData) throws SQLException {
        jdbcTemplate.executeInsert("INSERT INTO article VALUES (article_id_sequence.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)", preparedStatement -> {
//            preparedStatement.setLong(1, assignArticleNumber());
            preparedStatement.setString(1, bankMemberData.currentlyLogin());
            preparedStatement.setString(2, bankMemberData.name());
            preparedStatement.setString(3, title);
            preparedStatement.setString(4, content);
            preparedStatement.setString(5, "hashtag1");
            preparedStatement.setDate(6, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(7, bankMemberData.name());
            preparedStatement.setDate(8, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(9, bankMemberData.name());
        });
    }

    public List<Article> readAllArticles() throws SQLException {
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

    public List<Article> readArticlesByPagination(Pagination pagination) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery(
                """
                        SELECT article_inline.*
                        from (SELECT ROWNUM rnum, id, memberid, membername, title, content, hashtag, createdat, createdby, modifiedat, modifiedby
                        from article
                        order by ID) article_inline
                        where article_inline.rnum >= ? and article_inline.rnum <= ?
                        """, preparedStatement -> {
                    preparedStatement.setLong(1, pagination.getArticleStart());
                    preparedStatement.setLong(2, pagination.getArticleEnd());
                });


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

    public List<Article> readArticlesBySearchCondition(Pagination pagination, String searchType, String searchValue) throws SQLException {

        ResultSet resultSet = jdbcTemplate.executeQuery(
                String.format("""
                        SELECT article_inline.*
                        from (SELECT ROWNUM rnum, id, memberid, membername, title, content, hashtag, createdat, createdby, modifiedat, modifiedby
                              from article
                        WHERE %s = ?
                        order by ID
                              ) article_inline
                        where article_inline.rnum >= ? and article_inline.rnum <= ?
                        """,searchType), preparedStatement -> {
//                    preparedStatement.setString(1, "memberId");
                    preparedStatement.setString(1, searchValue);
                    preparedStatement.setLong(2, pagination.getArticleStart());
                    preparedStatement.setLong(3, pagination.getArticleEnd());
                });


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

        System.out.println(Arrays.toString(articles.toArray()));
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

    public void delete(String articleId) throws SQLException {
        jdbcTemplate.executeDelete("DELETE FROM article WHERE id = ?",
                preparedStatement -> preparedStatement.setString(1, articleId));
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

    public Article getArticleById(String articleId) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT id, memberId, memberName, title, content, hashtag, createdAt, createdBy, modifiedAt, modifiedBy
                        FROM ARTICLE
                        WHERE id = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, articleId));

        return matchArticle(resultSet, resultSet2 -> Article.of(
                resultSet2.getLong("id"),
                resultSet2.getString("memberId"),
                resultSet2.getString("memberName"),
                resultSet2.getString("title"),
                resultSet2.getString("content"),
                resultSet2.getString("hashtag"),
                resultSet2.getDate("createdAt"),
                resultSet2.getString("createdBy"),
                resultSet2.getDate("modifiedAt"),
                resultSet2.getString("modifiedBy")
        ));
    }

    public Article writeComment(String articleId, String content, MemberData bankMemberData) throws SQLException {
        jdbcTemplate.executeInsert("INSERT INTO article_comment VALUES (article_comment_id_sequence.nextval, ?, ?, ?, ?, ?, ?, ?, ?)", preparedStatement -> {
//            preparedStatement.setLong(1, 1);
            preparedStatement.setString(1, articleId);
            preparedStatement.setString(2, bankMemberData.memberId());
            preparedStatement.setString(3, bankMemberData.name());
            preparedStatement.setString(4, content);
            preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(6, bankMemberData.name());
            preparedStatement.setDate(7, Date.valueOf(LocalDate.now()));
            preparedStatement.setString(8, bankMemberData.name());
        });

        return getArticleById(articleId);
    }

    public List<ArticleComment> getAllCommentsByArticleId(String articleId) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT id, articleId, memberId, memberName, content, createdAt, createdBy, modifiedAt, modifiedBy
                        FROM ARTICLE_COMMENT
                        WHERE articleId = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, articleId));

        List<ArticleComment> comments = new ArrayList<>();

        while (resultSet.next()) {
            comments.add(ArticleComment.of(
                    resultSet.getLong("id"),
                    resultSet.getString("articleId"),
                    resultSet.getString("memberId"),
                    resultSet.getString("memberName"),
                    resultSet.getString("content"),
                    resultSet.getDate("createdAt"),
                    resultSet.getString("createdBy"),
                    resultSet.getDate("modifiedAt"),
                    resultSet.getString("modifiedBy")
            ));
        }
        return comments;
    }

    public ArticleComment getCommentByArticleId(String articleId) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery("""
                        SELECT id, articleId, memberId, memberName, content, createdAt, createdBy, modifiedAt, modifiedBy
                        FROM ARTICLE_COMMENT
                        WHERE articleId = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, articleId));

        return matchArticleComment(resultSet, resultSet2 -> ArticleComment.of(
                resultSet2.getLong("id"),
                resultSet2.getString("articleId"),
                resultSet2.getString("memberId"),
                resultSet2.getString("memberName"),
                resultSet2.getString("content"),
                resultSet2.getDate("createdAt"),
                resultSet2.getString("createdBy"),
                resultSet2.getDate("modifiedAt"),
                resultSet2.getString("modifiedBy")
        ));
    }

    private long assignArticleNumber() throws SQLException {
        return getArticleCount();
    }

    private Article matchArticle(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        if (resultSet.next()) {
            return (Article) rowMapper.mapRow(resultSet);
        }
        return null;
    }

    private ArticleComment matchArticleComment(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        if (resultSet.next()) {
            return (ArticleComment) rowMapper.mapRow(resultSet);
        }
        return null;
    }


    public String getPrevOrNextArticleId(String articleId, String value) throws SQLException {
        ResultSet resultSet = jdbcTemplate.executeQuery(
                """
                        select id, prev, next from (SELECT id
                             , LAG(id) OVER (ORDER BY id)  AS prev
                             , LEAD(id) OVER (ORDER BY id) AS next
                        FROM ARTICLE)
                        where id = ?
                        """,
                preparedStatement -> preparedStatement.setString(1, articleId));

        resultSet.next();
        int prevOrNext = resultSet.getInt(value);
        return String.valueOf(prevOrNext);
    }


}

// article
//    Long id,
//    String memberId,
//    String memberName,
//    String title,
//    String content,
//    String hashtag,
//    Date createdAt,
//    String createdBy,
//    Date modifiedAt,
//    String modifiedBy


// article comment
//    Long id,
//    Long articleId,
//    String memberId,
//    String memberName,
//    String content,
//    LocalDateTime createdAt,
//    String createdBy,
//    LocalDateTime modifiedAt,
//    String modifiedBy