package com.example.banksystemservlet.web.boardControllers.result;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.result.BoardResult;
import com.example.banksystemservlet.web.boardControllers.BoardController;
import com.example.banksystemservlet.web.boardControllers.BoardModelView;

import java.util.Map;

public class ArticleReadResultController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {


        String page = parameterMap.get("page");
        int pageStart = page.equals("default") ? 1 : Integer.parseInt(page);

        BoardResult boardResult = boardManager.readWithPageLimit(3, pageStart);

        BoardModelView boardModelView = new BoardModelView("article-list");
        boardModelView.getModel().put("boardResult", boardResult);
        return boardModelView;
    }
}
