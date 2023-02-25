package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.domain.bank.BankManager;
import com.example.banksystemservlet.result.BankResult;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class DepositResultBankController implements BankController {
    @Override
    public BankModelView process(BankManager bankManager, Map<String, String> parameterMap) {
        int depositAmount = validate(parameterMap.get("deposit"));

        BankResult bankResult = bankManager.deposit(depositAmount);
        BankModelView bankModelView = new BankModelView("deposit-result");
        bankModelView.getModel().put("bankResult", bankResult);
        return bankModelView;
    }

    private int validate(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (Exception e) {
            throw new IllegalArgumentException("input not valid");
        }
    }
}
