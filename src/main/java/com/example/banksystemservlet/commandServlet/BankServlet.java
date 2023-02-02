package com.example.banksystemservlet.commandServlet;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BankServlet {

    Result doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response);
}
