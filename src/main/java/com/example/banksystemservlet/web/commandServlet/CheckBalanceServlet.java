package com.example.banksystemservlet.web.commandServlet;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "checkBalanceServlet", urlPatterns = "/view/check-balance1")
public class CheckBalanceServlet extends HttpServlet implements BankServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Bank bank = Bank.getInstance();
        doBankJob(bank, request, response);

        request.getRequestDispatcher("./check-balance-result.jsp")
                .forward(request,response);
    }

    @Override
    public Result doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        return bank.checkBalance2();
    }
}
