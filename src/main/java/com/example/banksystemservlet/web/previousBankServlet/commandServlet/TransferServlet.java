package com.example.banksystemservlet.web.previousBankServlet.commandServlet;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "transferServlet", urlPatterns = "/view/transfer1")
public class TransferServlet extends HttpServlet implements BankServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Bank bank = Bank.getInstance();
        doBankJob(bank, request, response);

        request.getRequestDispatcher("./transfer-result.jsp")
                .forward(request,response);
    }

    @Override
    public BankResult doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        String transferId = request.getParameter("transferId");
        int transferAmount = Integer.parseInt(request.getParameter("transferAmount"));
        return bank.transfer(transferId, transferAmount);
    }
}
