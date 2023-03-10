package com.example.banksystemservlet.web.previousBankServlet.frontcontroller.controllers;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.web.bankControllers.BankView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebServlet(name = "frontControllerServlet", urlPatterns = "/1111bank/view/*")
public class FrontControllerServlet extends HttpServlet {

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public FrontControllerServlet() {
        controllerMap.put("/bank/view/register-form", new RegisterFormController());
        controllerMap.put("/bank/view/register-result", new RegisterResultController());
        controllerMap.put("/bank/view/login-form", new LoginFormController());
        controllerMap.put("/bank/view/login-result", new LoginResultController());
        controllerMap.put("/bank/view/logout-result", new LogoutResultController());
        controllerMap.put("/bank/view/deposit-form", new DepositFormController());
        controllerMap.put("/bank/view/deposit-result", new DepositResultController());
        controllerMap.put("/bank/view/withdraw-form", new WithdrawFormController());
        controllerMap.put("/bank/view/withdraw-result", new WithdrawResultController());
        controllerMap.put("/bank/view/transfer-form", new TransferFormController());
        controllerMap.put("/bank/view/transfer-result", new TransferResultController());
        controllerMap.put("/bank/view/check-balance-result", new CheckBalanceResultController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        Controller controller = controllerMap.get(requestURI);
        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Bank bank = Bank.getInstance();
        BankView view = controller.process(bank, request, response);
        view.render(request,response);
    }
}
