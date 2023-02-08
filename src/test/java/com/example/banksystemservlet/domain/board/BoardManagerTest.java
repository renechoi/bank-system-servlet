package com.example.banksystemservlet.domain.board;

import org.junit.jupiter.api.Test;

import java.util.List;

class BoardManagerTest {
    @Test
    void readAllFunction() {
        BoardManager boardManager = new BoardManager();
        BoardResult boardResult = boardManager.readAll();
        List<Article> articles = (List<Article>) boardResult.getBoardData();

        articles.forEach(article -> System.out.println("article = " + article));
    }

    @Test
    void deleteFunction() {
        BoardManager boardManager = new BoardManager();
//        boardManager.delete();
    }
}