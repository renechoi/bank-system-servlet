package com.example.banksystemservlet.web.memberControllers;

import com.example.banksystemservlet.domain.member.MemberManager;

import java.util.Map;

public interface MemberController {

    MemberModelView process(MemberManager memberManager, Map<String, String> parameterMap, Object result);
}
