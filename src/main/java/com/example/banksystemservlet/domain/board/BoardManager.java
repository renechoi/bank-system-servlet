package com.example.banksystemservlet.domain.board;

import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.member.Article;
import com.example.banksystemservlet.domain.member.ArticleDao;
import com.example.banksystemservlet.domain.member.MemberData;

import java.sql.SQLException;
import java.util.List;

public class BoardManager {

    private final ArticleDao ARTICLE_DAO = new ArticleDao();

    private static final BoardManager instance = new BoardManager();

    public BoardResult post(String title, String content, MemberData bankMemberData) {
        try {
            validate(bankMemberData);
            ARTICLE_DAO.post(title, content, bankMemberData);
            return new BoardResult("글쓰기 성공하였습니다", true);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("글쓰기 실패하였습니다", false);
        }
    }

    public BoardResult read() {
        try {
            List<Article> articles = ARTICLE_DAO.readAll();
            return new BoardResult("게시글 불러오기 성공하였습니다", true, articles);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("게시글 불러오기 실패하였습니다", false);
        }
    }

    public BoardResult update(){
        try {
            ARTICLE_DAO.update();
            return new BoardResult("게시글 업데이트 성공하였습니다", true);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("게시글 업데이트 실패하였습니다", false);
        }
    }

    public BoardResult delete(){
        try {
            ARTICLE_DAO.delete();
            return new BoardResult("게시글 삭제 성공하였습니다", true);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("게시글 삭제 실패하였습니다", false);
        }
    }

    public BoardResult getArticleById(String articleId){
        try {
            ARTICLE_DAO.getArticleById(articleId);
            return new BoardResult("게시글 불러오기 성공하였습니다", true);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("게시글 불러오기 실패하였습니다", false);
        }
    }

    private void validate(MemberData bankMemberdata){
        if ("not login".equals(bankMemberdata.currentlyLogin())){
            throw new IllegalArgumentException("not login");
        }
    }


}
