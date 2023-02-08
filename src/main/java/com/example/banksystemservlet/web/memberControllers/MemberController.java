package com.example.banksystemservlet.web.memberControllers;

import com.example.banksystemservlet.domain.board.BoardManager;

import java.util.Map;

public interface MemberController {

    MemberModelView process(BoardManager boardManager, Map<String, String> parameterMap, Object result);
}
