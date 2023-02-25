package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.domain.bank.BankManager;
import com.example.banksystemservlet.result.BankResult;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class CheckBalanceResultBankController implements BankController {
    @Override
    public BankModelView process(BankManager bankManager, Map<String, String> parameterMap) {
        BankResult bankResult = bankManager.checkBalance();

        BankModelView bankModelView = new BankModelView("check-balance-result");
        bankModelView.getModel().put("bankResult", bankResult);
        return bankModelView;
    }
}
