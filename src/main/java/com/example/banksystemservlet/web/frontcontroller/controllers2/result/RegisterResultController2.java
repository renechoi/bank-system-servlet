package com.example.banksystemservlet.web.frontcontroller.controllers2.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.web.frontcontroller.controllers2.Controller2;
import com.example.banksystemservlet.web.frontcontroller.controllers2.ModelView;

import java.util.Map;

public class RegisterResultController2 implements Controller2 {
    @Override
    public ModelView process(Bank bank, Map<String, String> parameterMap) {

        Member member = new Member(
                parameterMap.get("memberName"),
                parameterMap.get("memberId"),
                parameterMap.get("password"));

        Result result = bank.register2(member);
        ModelView modelView = new ModelView("register-result");

        modelView.getModel().put("member", member);
        modelView.getModel().put("result", result);
        return modelView;
    }

}
