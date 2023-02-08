package com.example.banksystemservlet.web.boardController.result;

import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.domain.board.BoardResult;
import com.example.banksystemservlet.domain.member.MemberData;
import com.example.banksystemservlet.web.boardController.BoardController;
import com.example.banksystemservlet.web.boardController.BoardModelView;

import java.util.Map;

public class CommentWriteResultController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {

        String articleId = parameterMap.get("id");
        String commentContent = parameterMap.get("comment-content");

        MemberData bankMemberData = getBankData((BankResult) result);
        BoardResult boardResult = boardManager.writeComment(bankMemberData, commentContent, articleId);

        BoardModelView boardModelView = new BoardModelView("article-content");
        boardModelView.getModel().put("boardResult", boardResult);
        return boardModelView;
    }

    private static MemberData getBankData(BankResult result) {
        return result.getData();
    }
}
