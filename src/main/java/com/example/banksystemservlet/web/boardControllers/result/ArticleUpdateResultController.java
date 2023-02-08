package com.example.banksystemservlet.web.boardControllers.result;

import com.example.banksystemservlet.result.BankResultRepository;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.domain.board.BoardResult;
import com.example.banksystemservlet.domain.member.MemberData;
import com.example.banksystemservlet.web.boardControllers.BoardController;
import com.example.banksystemservlet.web.boardControllers.BoardModelView;

import java.util.Map;

public class ArticleUpdateResultController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {

        String title = parameterMap.get("title");
        String content = parameterMap.get("content");

//        MemberData bankMemberData = getBankData((BankResult) result);
        MemberData bankMemberData = ((BankResult) BankResultRepository.result).getData();


        BoardResult boardResult = boardManager.post(title, content, bankMemberData);

        BoardModelView boardModelView = new BoardModelView("article-save-result");
        boardModelView.getModel().put("boardResult", boardResult);
        return boardModelView;
    }

    private static MemberData getBankData(BankResult result) {
        return result.getData();
    }
}
