package com.example.banksystemservlet.web.commandServlet;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.domain.member.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name ="loginServlet", urlPatterns = "/view/login-result1")
public class LoginServlet extends HttpServlet implements BankServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Bank bank = Bank.getInstance();
        doBankJob(bank, request, response);

        String viewPath = "./login-result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);
    }

    @Override
    public Result doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        Member member = getMember(request);
        createSession(request, member);
        return bank.login2(member.getMemberId(), member.getPassword());
    }

    private static Member getMember(HttpServletRequest request) {
        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        return new Member("임시 이름", memberId, password);
    }

    private static void createSession(HttpServletRequest request, Member member) {
        HttpSession session = request.getSession();
        session.setAttribute("member", member);
    }

    private void forwardWhenFail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LogInFail.jsp");
        requestDispatcher.forward(request, response);
    }
}
