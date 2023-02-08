package com.example.banksystemservlet.web.boardController.result;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.domain.board.BoardResult;
import com.example.banksystemservlet.web.boardController.BoardController;
import com.example.banksystemservlet.web.boardController.BoardModelView;

import java.util.Map;

public class ArticlePrevResultController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {

        String articleId = parameterMap.get("id");
        // TODO : pagination 할 때 아예 prev와 next 값을 받아와서 하나의 클래스에서 관리할 수 있도록 하자
        BoardResult boardResult = boardManager.getPrevOrNextArticleAndComments(articleId, "prev");

        BoardModelView boardModelView = new BoardModelView("article-content");
        boardModelView.getModel().put("boardResult", boardResult);
        return boardModelView;
    }
}
