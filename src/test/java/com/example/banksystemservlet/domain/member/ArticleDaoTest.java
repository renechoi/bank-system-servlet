package com.example.banksystemservlet.domain.member;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class ArticleDaoTest
{

    @Test
    void postFunction() throws SQLException {
        ArticleDao articleDao = new ArticleDao();
        String title = " ";
        String content = "";
//        articleDao.writeArticle(title, content);

    }

    @Test
    void updateFunction() throws SQLException {
        ArticleDao articleDao = new ArticleDao();
        articleDao.update();
    }
}