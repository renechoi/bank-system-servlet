package com.example.banksystemservlet.web.memberControllers;

import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.result.BankResultRepository;
import com.example.banksystemservlet.result.Result;
import com.example.banksystemservlet.web.bankControllers.form.LoginFormBankController;
import com.example.banksystemservlet.web.bankControllers.form.RegisterFormBankController;
import com.example.banksystemservlet.web.memberControllers.form.LoginFormController;
import com.example.banksystemservlet.web.memberControllers.form.RegisterFormController;
import com.example.banksystemservlet.web.memberControllers.result.LoginResultController;
import com.example.banksystemservlet.web.memberControllers.result.LogoutResultController;
import com.example.banksystemservlet.web.memberControllers.result.RegisterResultController;

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

        controllerMap.put("/member/register-form", new RegisterFormController());
        controllerMap.put("/member/login-form", new LoginFormController());

        controllerMap.put("/member/register-result", new RegisterResultController());
        controllerMap.put("/member/login-result", new LoginResultController());
        controllerMap.put("/member/logout-result", new LogoutResultController());
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
        MemberModelView memberModelView = memberController.process(memberManager, paramMap);

        MemberView memberView = viewResolver(memberModelView.getViewName());
        memberView.render(memberModelView.getModel(), request, response);
    }

    private static MemberView viewResolver(String viewName) {
        return new MemberView("/WEB-INF/member/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
