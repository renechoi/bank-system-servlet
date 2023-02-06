package com.example.banksystemservlet.web.boardControllers.form;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.web.boardControllers.BoardController;
import com.example.banksystemservlet.web.boardControllers.BoardModelView;

import java.util.Map;

public class ArticleWriteFormController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {
        return new BoardModelView("article-write-form");
    }
}
