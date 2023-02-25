package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.result.BankResult;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class CreateAccountResultBankController implements BankController {
    @Override
    public BankModelView process(Bank bank, Map<String, String> parameterMap) {

        String memberId = parameterMap.get("memberId");
        String password = parameterMap.get("password");

        BankResult bankResult = bank.createAccount(memberId, password);
        BankModelView bankModelView = new BankModelView("create-account-result");
        bankModelView.getModel().put("bankResult", bankResult);
        return bankModelView;
    }
}
