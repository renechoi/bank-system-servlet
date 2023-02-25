package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.domain.bank.BankManager;
import com.example.banksystemservlet.result.BankResult;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class CreateAccountResultBankController implements BankController {
    @Override
    public BankModelView process(BankManager bankManager, Map<String, String> parameterMap) {

        String memberId = parameterMap.get("memberId");
        String password = parameterMap.get("password");

        BankResult bankResult = bankManager.createAccount(memberId, password);
        BankModelView bankModelView = new BankModelView("create-account-result");
        bankModelView.getModel().put("bankResult", bankResult);
        return bankModelView;
    }
}
