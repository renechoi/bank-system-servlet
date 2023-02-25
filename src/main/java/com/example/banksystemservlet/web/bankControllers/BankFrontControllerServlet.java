package com.example.banksystemservlet.web.bankControllers;

import com.example.banksystemservlet.domain.bank.BankManager;
import com.example.banksystemservlet.repository.ResultRepository;
import com.example.banksystemservlet.web.bankControllers.form.CreateAccountFormBankController;
import com.example.banksystemservlet.web.bankControllers.form.DepositFormBankController;
import com.example.banksystemservlet.web.bankControllers.form.TransferFormBankController;
import com.example.banksystemservlet.web.bankControllers.form.WithdrawFormBankController;
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

        BankManager bankManager = BankManager.getInstance();

        Map<String, String> paramMap = createParamMap(request);
        BankModelView bankModelView = bankController.process(bankManager, paramMap);
        saveRepository(bankModelView);

        BankView bankView = viewResolver(bankModelView.getViewName());
        bankView.render(bankModelView.getModel(), request, response);
    }

    private static void saveRepository(BankModelView bankModelView) {
//        ResultRepository.saveBankResult(bankModelView.getModel());
//        BankResultRepository.saveBankResult(bankModelView.getModel());   // TODO : 지우고 하나로 통합하는 거 필요
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
