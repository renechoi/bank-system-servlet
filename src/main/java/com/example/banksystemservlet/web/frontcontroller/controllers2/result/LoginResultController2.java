package com.example.banksystemservlet.web.frontcontroller.controllers2.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.web.frontcontroller.BankView;
import com.example.banksystemservlet.web.frontcontroller.controllers2.Controller2;
import com.example.banksystemservlet.web.frontcontroller.controllers2.ModelView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class LoginResultController2 implements Controller2 {
    @Override
    public ModelView process(Bank bank, Map<String, String> parameterMap) {

        String memberId = parameterMap.get("memberId");
        String password = parameterMap.get("password");
        Member member = new Member("임시 이름", memberId, password);

        Result result = bank.login(member.getMemberId(), member.getPassword());

        ModelView modelView = new ModelView("login-result");

        modelView.getModel().put("member", member);
        modelView.getModel().put("result", result);
        return modelView;
    }
}
