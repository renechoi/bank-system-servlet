package com.example.banksystemservlet.web.bankControllers;

import com.example.banksystemservlet.result.BankResultRepository;
import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.web.bankControllers.form.*;
import com.example.banksystemservlet.web.bankControllers.result.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", urlPatterns = "/bank/*")
public class BankFrontControllerServlet extends HttpServlet {

    private final Map<String, BankController> controllerMap2 = new HashMap<>();

    public BankFrontControllerServlet() {

        controllerMap2.put("/bank/create-account-form", new CreateAccountFormBankController());
        controllerMap2.put("/bank/deposit-form", new DepositFormBankController());
        controllerMap2.put("/bank/withdraw-form", new WithdrawFormBankController());
        controllerMap2.put("/bank/transfer-form", new TransferFormBankController());

        controllerMap2.put("/bank/create-account-result", new CreateAccountResultBankController());
        controllerMap2.put("/bank/deposit-result", new DepositResultBankController());
        controllerMap2.put("/bank/withdraw-result", new WithdrawResultBankController());
        controllerMap2.put("/bank/transfer-result", new TransferResultBankController());
        controllerMap2.put("/bank/check-balance-result", new CheckBalanceResultBankController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        BankController bankController = controllerMap2.get(requestURI);
        if (bankController == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Bank bank = Bank.getInstance();

        Map<String, String> paramMap = createParamMap(request);
        BankModelView bankModelView = bankController.process(bank, paramMap);
        saveResult(bankModelView.getModel());

        BankView bankView = viewResolver(bankModelView.getViewName());
        bankView.render(bankModelView.getModel(), request, response);
    }

    private static void saveResult(Map<String, Object> model) {
        BankResultRepository.saveBankResult(model);
    }

    private static BankView viewResolver(String viewName) {
        return new BankView("/WEB-INF/bank/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
