package com.example.banksystemservlet.domain.board;

public class BoardResult {

    private final String message;
    private final boolean result;
    private final Object boardData;
    private final Object boardCommentData;

    public BoardResult(String message, boolean result) {
        this(message, result, null);
    }

    public BoardResult(String message, boolean result, Object boardData) {
        this(message, result, boardData, null);
    }

    public BoardResult(String message, boolean result, Object boardData, Object boardCommentData) {
        this.message = message;
        this.result = result;
        this.boardData = boardData;
        this.boardCommentData = boardCommentData;
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

    public Object getBoardCommentData() {
        return boardCommentData;
    }
}
