package com.example.banksystemservlet.web.previousBankServlet.commandServlet;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.member.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "registerServlet", urlPatterns = "/view/register-result1")
public class RegisterServlet extends HttpServlet implements BankServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Bank bank = Bank.getInstance();
        doBankJob(bank, request, response);

        String viewPath = "./register-result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);
    }

    @Override
    public BankResult doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        String memberName = request.getParameter("memberName");
        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        return bank.register(new Member(memberName, memberId, password));
    }
}
