package com.example.banksystemservlet.web.previousBankServlet.frontcontroller.controllers;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.web.bankControllers.BankView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterResultController implements Controller {
    @Override
    public BankView process(Bank bank, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doBankJob(bank, request, response);
        return new BankView("/WEB-INF/views/register-result.jsp");
    }

    public BankResult doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        String memberName = request.getParameter("memberName");
        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        return bank.register(new Member(memberName, memberId, password));
    }
}
