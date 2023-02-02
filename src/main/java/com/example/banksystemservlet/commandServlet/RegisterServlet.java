package com.example.banksystemservlet.commandServlet;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.member.AccountDao;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.domain.member.MemberDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "registerServlet", urlPatterns = "/view/register-result")
public class RegisterServlet extends HttpServlet implements BankServlet {

    // Todo : validation 로직 구현  -> db id 중복 체크시 ch14 memberMgr 확인
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Bank bank = Bank.getInstance();
        doBankJob(bank, request, response);

        String viewPath = "./register-result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);
    }

    @Override
    public Result doBankJob(Bank bank, HttpServletRequest request, HttpServletResponse response) {
        String memberName = request.getParameter("memberName");
        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        return bank.register2(new Member(memberName, memberId, password));
    }
}
