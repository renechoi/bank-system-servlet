package com.example.banksystemservlet.web.memberControllers.result;

import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.web.memberControllers.MemberController;
import com.example.banksystemservlet.web.memberControllers.MemberModelView;

import java.util.Map;

public class RegisterResultController implements MemberController {
    @Override
    public MemberModelView process(MemberManager memberManager, Map<String, String> parameterMap, Object result) {
        return null;
    }
}
