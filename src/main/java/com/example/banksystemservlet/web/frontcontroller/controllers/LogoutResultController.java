package com.example.banksystemservlet.web.frontcontroller.controllers;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.web.frontcontroller.BankView;
import com.example.banksystemservlet.web.frontcontroller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutResultController implements Controller {
    @Override
    public BankView process(Bank bank, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        doBankJob(bank, request, response);

        return new BankView("/WEB-INF/views/logout-result.jsp");
    }

    public Result doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        return bank.logout();
    }
}
