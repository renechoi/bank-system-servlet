package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.result.BankResultRepository;
import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class LoginResultBankController implements BankController {
    @Override
    public BankModelView process(Bank bank, Map<String, String> parameterMap) {

        String memberId = parameterMap.get("memberId");
        String password = parameterMap.get("password");

        BankResult bankResult = bank.login(memberId, password);

        BankModelView bankModelView = new BankModelView("login-result");

        bankModelView.getModel().put("bankResult", bankResult);

        return bankModelView;
    }

    private static void saveResult(Map<String, Object> model) {
        BankResultRepository.saveBankResult(model);
    }

}
