package com.example.banksystemservlet.web.frontcontroller.controllers2;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.web.frontcontroller.BankView;
import com.example.banksystemservlet.web.frontcontroller.controllers2.form.*;
import com.example.banksystemservlet.web.frontcontroller.controllers2.result.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", urlPatterns = "/bank/view/*")
public class FrontControllerServlet2 extends HttpServlet {

    private final Map<String, Controller2> controllerMap2 = new HashMap<>();

    public FrontControllerServlet2() {
        controllerMap2.put("/bank/view/register-form", new RegisterFormController2());
        controllerMap2.put("/bank/view/login-form", new LoginFormController2());
        controllerMap2.put("/bank/view/deposit-form", new DepositFormController2());
        controllerMap2.put("/bank/view/withdraw-form", new WithdrawFormController2());
        controllerMap2.put("/bank/view/transfer-form", new TransferFormController2());


        controllerMap2.put("/bank/view/register-result", new RegisterResultController2());
        controllerMap2.put("/bank/view/login-result", new LoginResultController2());
        controllerMap2.put("/bank/view/logout-result", new LogoutResultController2());
        controllerMap2.put("/bank/view/deposit-result", new DepositResultController2());
        controllerMap2.put("/bank/view/withdraw-result", new WithdrawResultController2());
        controllerMap2.put("/bank/view/transfer-result", new TransferResultController2());
        controllerMap2.put("/bank/view/check-balance-result", new CheckBalanceResultController2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        Controller2 controller2 = controllerMap2.get(requestURI);
        if (controller2 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Bank bank = Bank.getInstance();

        Map<String, String> paramMap = createParamMap(request);
        ModelView modelView = controller2.process(bank, paramMap);

        BankView bankView = viewResolver(modelView.getViewName());
        bankView.render(modelView.getModel(), request, response);
    }

    private static BankView viewResolver(String viewName) {
        return new BankView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
