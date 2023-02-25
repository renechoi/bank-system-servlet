package com.example.banksystemservlet.web.boardControllers.result;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.result.BoardResult;
import com.example.banksystemservlet.web.boardControllers.BoardController;
import com.example.banksystemservlet.web.boardControllers.BoardModelView;

import java.util.Map;

public class ArticleDeleteResultController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {

        String articleId = parameterMap.get("id");

        // TODO : 삭제 기능을 수행해 준다음에 read 작업을 해서 받아주어야 다시 리스트 화면으로 출력이 가능해진다. 하지만 이렇게 했을 때 중복코드...로직상 맞지 않다.
        boardManager.delete(articleId);
        BoardResult boardResult = boardManager.readAll();

        BoardModelView boardModelView = new BoardModelView("article-list");
        boardModelView.getModel().put("boardResult", boardResult);
        return boardModelView;
    }
}
