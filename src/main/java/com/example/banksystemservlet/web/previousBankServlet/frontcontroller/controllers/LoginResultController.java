package com.example.banksystemservlet.web.previousBankServlet.frontcontroller.controllers;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.web.bankControllers.BankView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginResultController implements Controller {
    @Override
    public BankView process(Bank bank, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doBankJob(bank, request, response);
        return new BankView("/WEB-INF/views/login-result.jsp");
    }

    public BankResult doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        Member member = getMember(request);
        createSession(request, member);
//        return bank.login(member.getMemberId(), member.getPassword());
        return null;
    }

    private static Member getMember(HttpServletRequest request) {
        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        return new Member("임시 이름", memberId, password);
    }

    private static void createSession(HttpServletRequest request, Member member) {
        HttpSession session = request.getSession();
        session.setAttribute("member", member);
    }

    private void forwardWhenFail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LogInFail.jsp");
        requestDispatcher.forward(request, response);
    }
}
