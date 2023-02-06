package com.example.banksystemservlet.domain.board;

import com.example.banksystemservlet.domain.member.MemberData;

public class BoardResult {

    private final String message;
    private final boolean result;
    private final Object boardData;

    public BoardResult(String message, boolean result) {
        this(message, result, null);
//        this.message = message;
//        this.result = result;
    }

    public BoardResult(String message, boolean result, Object boardData) {
        this.message = message;
        this.result = result;
        this.boardData = boardData;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResult() {
        return result;
    }

    public Object getBoardData() {
        return boardData;
    }
}
