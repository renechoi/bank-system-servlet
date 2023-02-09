package com.example.banksystemservlet.web.memberControllers.result;

import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.domain.member.MemberResult;
import com.example.banksystemservlet.web.bankControllers.BankModelView;
import com.example.banksystemservlet.web.memberControllers.MemberController;
import com.example.banksystemservlet.web.memberControllers.MemberModelView;

import java.util.Map;

public class RegisterResultController implements MemberController {
    @Override
    public MemberModelView process(MemberManager memberManager, Map<String, String> parameterMap) {

        Member member = new Member(
                parameterMap.get("memberName"),
                parameterMap.get("memberId"),
                parameterMap.get("password"),
                parameterMap.get("email"),
                parameterMap.get("address"));

        MemberResult memberResult = memberManager.register(member);
        MemberModelView memberModelView = new MemberModelView("register-result");

        memberModelView.getModel().put("memberResult", memberResult);
        return memberModelView;
    }
}
