package com.example.banksystemservlet.web.memberControllers.result;

import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.result.MemberResult;
import com.example.banksystemservlet.web.memberControllers.MemberController;
import com.example.banksystemservlet.web.memberControllers.MemberModelView;

import java.util.Map;

public class LoginResultController implements MemberController {
    @Override
    public MemberModelView process(MemberManager memberManager, Map<String, String> parameterMap) {

        String memberId = parameterMap.get("memberId");
        String password = parameterMap.get("password");

        MemberResult memberResult = memberManager.login(memberId, password);
        MemberModelView memberModelView = new MemberModelView("login-result");
        memberModelView.getModel().put("memberResult", memberResult);

        return memberModelView;
    }
}
