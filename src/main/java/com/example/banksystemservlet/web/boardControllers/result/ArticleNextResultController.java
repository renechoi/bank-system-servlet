package com.example.banksystemservlet.web.boardControllers.result;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.result.BoardResult;
import com.example.banksystemservlet.web.boardControllers.BoardController;
import com.example.banksystemservlet.web.boardControllers.BoardModelView;

import java.util.Map;

public class ArticleNextResultController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {

        String articleId = parameterMap.get("id");

        BoardResult boardResult = boardManager.getPrevOrNextArticleAndComments(articleId, "next");

        BoardModelView boardModelView = new BoardModelView("article-content");
        boardModelView.getModel().put("boardResult", boardResult);
        return boardModelView;
    }
}
