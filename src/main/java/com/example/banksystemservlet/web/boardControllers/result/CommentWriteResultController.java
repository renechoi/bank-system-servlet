package com.example.banksystemservlet.web.boardControllers.result;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.repository.ResultRepository;
import com.example.banksystemservlet.result.BoardResult;
import com.example.banksystemservlet.web.boardControllers.BoardController;
import com.example.banksystemservlet.web.boardControllers.BoardModelView;

import java.util.Map;

public class CommentWriteResultController implements BoardController {
    @Override
    public BoardModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result) {

        String articleId = parameterMap.get("id");
        String commentContent = parameterMap.get("comment-content");

        Member member = ResultRepository.getMemberResult().member();  // TODO : null 값 에러 처리
        BoardResult boardResult = boardManager.writeComment(commentContent, articleId, member);

        BoardModelView boardModelView = new BoardModelView("article-content");
        boardModelView.getModel().put("boardResult", boardResult);
        return boardModelView;
    }
}
