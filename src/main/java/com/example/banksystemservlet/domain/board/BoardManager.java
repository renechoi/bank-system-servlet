package com.example.banksystemservlet.domain.board;

import com.example.banksystemservlet.domain.member.*;

import java.sql.SQLException;
import java.util.List;

public class BoardManager {

    private final ArticleDao ARTICLE_DAO = new ArticleDao();

    private static final BoardManager instance = new BoardManager();

    public BoardResult post(String title, String content, MemberData bankMemberData) {
        try {
            validate(bankMemberData);
            ARTICLE_DAO.writeArticle(title, content, bankMemberData);
            return new BoardResult("글쓰기 성공하였습니다", true);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("글쓰기 실패하였습니다", false);
        }
    }

    public BoardResult readAll() {
        try {
            List<Article> articles = ARTICLE_DAO.readAllArticles();
            return new BoardResult("게시글 불러오기 성공하였습니다", true, articles);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("게시글 불러오기 실패하였습니다", false);
        }
    }

    public BoardResult readWithPageLimit(int pageLimit, int pageStart) {
        try {
            Pagination pagination = new Pagination(pageLimit, pageStart, ARTICLE_DAO.getArticleCount());
            List<Article> articles = ARTICLE_DAO.readArticlesByPagination(pagination);
            return new BoardResult("게시글 불러오기 성공하였습니다", true, articles, null, pagination);
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

    public BoardResult delete(String articleId){
        try {
            ARTICLE_DAO.delete(articleId);
            return new BoardResult("게시글 삭제 성공하였습니다", true);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("게시글 삭제 실패하였습니다", false);
        }
    }

    public BoardResult getArticleAndComments(String articleId){
        try {
            Article article = ARTICLE_DAO.getArticleById(articleId);
            List<ArticleComment> comments = ARTICLE_DAO.getAllCommentsByArticleId(articleId);
            return new BoardResult("게시글 불러오기 성공하였습니다", true, article, comments);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("게시글 불러오기 실패하였습니다", false);
        }
    }

    public BoardResult getPrevOrNextArticleAndComments(String articleId, String value){
        try {
            String prevOrNextArticleId = ARTICLE_DAO.getPrevOrNextArticleId(articleId, value);
            Article article = ARTICLE_DAO.getArticleById(prevOrNextArticleId);
            List<ArticleComment> comments = ARTICLE_DAO.getAllCommentsByArticleId(prevOrNextArticleId);
            return new BoardResult(String.format("이전/이후 게시글 불러오기 성공하였습니다",value), true, article, comments);
        } catch (RuntimeException | SQLException e) {
            System.out.println("실패 e = " + e);
            return new BoardResult(String.format("이전/이후 게시글 불러오기 실패하였습니다",value), false);
        }
    }

    public BoardResult writeComment(MemberData memberData, String content, String articleId) {
        try {
            Article article = ARTICLE_DAO.writeComment(articleId, content, memberData);
            List<ArticleComment> comments = ARTICLE_DAO.getAllCommentsByArticleId(articleId);
            return new BoardResult("댓글 작성 성공하였습니다", true, article, comments);
        } catch (RuntimeException | SQLException e) {
            return new BoardResult("댓글 작성 실패하였습니다", false);
        }
    }

    private void validate(MemberData bankMemberdata){
        if ("not login".equals(bankMemberdata.currentlyLogin())){
            throw new IllegalArgumentException("not login");
        }
    }

}
