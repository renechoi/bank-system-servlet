package com.example.banksystemservlet.web.frontcontroller.controllers;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.web.frontcontroller.BankView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckBalanceResultController implements Controller {
    @Override
    public BankView process(Bank bank, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doBankJob(bank, request, response);

        return new BankView("/WEB-INF/views/check-balance-result.jsp");
    }

    public Result doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        return bank.checkBalance2();
    }
}