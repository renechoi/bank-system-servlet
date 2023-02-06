package com.example.banksystemservlet.web.boardControllers;

import com.example.banksystemservlet.domain.board.BoardManager;

import java.util.Map;

public interface BoardController {

    BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result);
}
