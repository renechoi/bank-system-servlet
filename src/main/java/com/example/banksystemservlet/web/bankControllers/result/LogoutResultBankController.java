package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class LogoutResultBankController implements BankController {
    @Override
    public BankModelView process(Bank bank, Map<String, String> parameterMap) {
        BankResult bankResult = bank.logout();
        BankModelView bankModelView = new BankModelView("logout-result");

        bankModelView.getModel().put("bankResult", bankResult);
        return bankModelView;
    }
}
