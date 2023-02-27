package com.example.banksystemservlet.web.memberControllers.result;

import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.result.MemberResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 컨트롤러 방식에서 model을 넘겨주는 방식으로 비동기 방식이 불가해
 * 서블릿에서 받아서 바로 출력해 주는 것으로 차선의 선택
 */
@WebServlet(urlPatterns = "/check-id")
public class UserIdCheckServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId =  request.getParameter("memberId").trim();

        if(memberId == null || "".equals(memberId)){
            memberId = "Guest";
        }

        MemberManager memberManager = new MemberManager();
        MemberResult memberResult = memberManager.validateDuplicateId(memberId);

        String message = memberResult.message();
        response.getWriter().write(message);
    }

}
