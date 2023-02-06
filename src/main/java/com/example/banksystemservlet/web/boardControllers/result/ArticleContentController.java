package com.example.banksystemservlet.web.boardControllers.result;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.domain.board.BoardResult;
import com.example.banksystemservlet.web.boardControllers.BoardController;
import com.example.banksystemservlet.web.boardControllers.BoardModelView;

import java.util.Map;

public class ArticleContentController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {

        String articleId = parameterMap.get("id");

        BoardResult boardResult = boardManager.getArticleById(articleId);

        BoardModelView boardModelView = new BoardModelView("article-content");
        boardModelView.getModel().put("boardResult", boardResult);
        return boardModelView;
    }
}
