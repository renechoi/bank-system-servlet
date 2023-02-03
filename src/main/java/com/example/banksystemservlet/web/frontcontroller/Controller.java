package com.example.banksystemservlet.web.frontcontroller;

import com.example.banksystemservlet.domain.bank.Bank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    BankView process(Bank bank, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
