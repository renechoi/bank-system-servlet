package com.example.banksystemservlet.web.previousBankServlet.commandServlet;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name ="logoutServlet", urlPatterns = "/view/logout-result1")
public class LogoutServlet extends HttpServlet implements BankServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();

        Bank bank = Bank.getInstance();
        doBankJob(bank, request, response);

        String viewPath = "./logout-result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);
    }

    @Override
    public BankResult doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
//        return bank.logout();
    return null;
    }
}
