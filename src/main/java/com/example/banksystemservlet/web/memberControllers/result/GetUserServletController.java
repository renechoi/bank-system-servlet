package com.example.banksystemservlet.web.memberControllers.result;


import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.result.MemberResult;
import com.example.banksystemservlet.web.memberControllers.MemberController;
import com.example.banksystemservlet.web.memberControllers.MemberModelView;

import java.util.Map;


public class GetUserServletController implements MemberController {

    @Override
    public MemberModelView process(MemberManager memberManager, Map<String, String> parameterMap) {
        String memberId = parameterMap.get("memberId").trim();

        if(memberId == null || "".equals(memberId)){
            memberId = "Guest";
        }

        MemberResult memberResult = memberManager.validateDuplicateId(memberId);
        MemberModelView memberModelView = new MemberModelView("check-id");
        memberModelView.getModel().put("memberResult", memberResult);

        return memberModelView;
    }
}