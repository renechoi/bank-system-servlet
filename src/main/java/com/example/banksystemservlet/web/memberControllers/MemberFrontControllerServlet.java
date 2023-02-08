package com.example.banksystemservlet.web.memberControllers;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.result.BankResultRepository;
import com.example.banksystemservlet.result.Result;
import com.example.banksystemservlet.web.bankControllers.result.LoginResultBankController;
import com.example.banksystemservlet.web.bankControllers.result.LogoutResultBankController;
import com.example.banksystemservlet.web.bankControllers.result.RegisterResultBankController;
import com.example.banksystemservlet.web.boardControllers.BoardModelView;
import com.example.banksystemservlet.web.boardControllers.BoardView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="memberFrontControllerServlet", urlPatterns = "/member/*")
public class MemberFrontControllerServlet extends HttpServlet {

    private final Map<String, MemberController> controllerMap = new HashMap<>();

    public MemberFrontControllerServlet() {
        controllerMap.put("/member/register-result", new RegisterResultBankController());
        controllerMap.put("/member/login-result", new LoginResultBankController());
        controllerMap.put("/member/logout-result", new LogoutResultBankController());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String requestURI = request.getRequestURI();
        MemberController memberController = controllerMap.get(requestURI);
        if (memberController == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MemberManager memberManager = new MemberManager();


        Result result = BankResultRepository.result;

        Map<String, String> paramMap = createParamMap(request);
        MemberModelView memberModelView = memberController.process(memberManager, paramMap, result);

        MemberView memberView = viewResolver(memberModelView.getViewName());
        memberView.render(memberModelView.getModel(), request, response);
    }

    private static BoardView viewResolver(String viewName) {
        return new BoardView("/WEB-INF/member/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
