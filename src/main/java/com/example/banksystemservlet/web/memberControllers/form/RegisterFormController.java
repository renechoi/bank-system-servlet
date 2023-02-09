package com.example.banksystemservlet.web.memberControllers.form;

import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.web.memberControllers.MemberController;
import com.example.banksystemservlet.web.memberControllers.MemberModelView;

import java.util.Map;

public class RegisterFormController implements MemberController {
    @Override
    public MemberModelView process(MemberManager memberManager, Map<String, String> parameterMap) {
        return new MemberModelView("register-page");
    }
}
