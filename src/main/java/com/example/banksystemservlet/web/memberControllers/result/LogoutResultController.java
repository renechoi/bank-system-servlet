package com.example.banksystemservlet.web.memberControllers.result;

import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.result.MemberResult;
import com.example.banksystemservlet.web.memberControllers.MemberController;
import com.example.banksystemservlet.web.memberControllers.MemberModelView;

import java.util.Map;

public class LogoutResultController implements MemberController {
    @Override
    public MemberModelView process(MemberManager memberManager, Map<String, String> parameterMap) {
        MemberResult memberResult = memberManager.logout();

        MemberModelView memberModelView = new MemberModelView("logout-result");

        memberModelView.getModel().put("memberResult", memberResult);
        return memberModelView;
    }
}
