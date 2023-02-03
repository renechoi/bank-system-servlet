package com.example.banksystemservlet.web.frontcontroller.controllers;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.web.frontcontroller.BankView;
import com.example.banksystemservlet.web.frontcontroller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WithdrawFormController implements Controller {
    @Override
    public BankView process(Bank bank, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new BankView("/WEB-INF/views/withdraw-form.jsp");
    }
}
