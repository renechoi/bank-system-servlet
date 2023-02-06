package com.example.banksystemservlet.web.previousBankServlet.commandServlet;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "depositServlet", urlPatterns = "/view/deposit1")
public class DepositServlet extends HttpServlet implements BankServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Bank bank = Bank.getInstance();
        doBankJob(bank, request, response);

        String viewPath = "./deposit-result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);
    }

    @Override
    public BankResult doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        int depositAmount = validate(request.getParameter("deposit"));
        return bank.deposit(depositAmount);
    }

    private int validate(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (Exception e) {
            throw new IllegalArgumentException("input not valid");
        }
    }
}
