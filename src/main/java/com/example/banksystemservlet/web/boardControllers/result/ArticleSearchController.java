package com.example.banksystemservlet.web.boardControllers.result;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.domain.board.BoardResult;
import com.example.banksystemservlet.web.boardControllers.BoardController;
import com.example.banksystemservlet.web.boardControllers.BoardModelView;

import java.util.Map;

public class ArticleSearchController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {

        String searchType = parameterMap.get("searchType");
        String searchValue = parameterMap.get("searchValue");
        BoardResult boardResult = boardManager.readWithSearch(searchType, searchValue, 5);

        BoardModelView boardModelView = new BoardModelView("article-list");
        boardModelView.getModel().put("boardResult", boardResult);
        return boardModelView;
    }
}
