package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.domain.bank.BankManager;
import com.example.banksystemservlet.result.BankResult;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class WithdrawResultBankController implements BankController {
    @Override
    public BankModelView process(BankManager bankManager, Map<String, String> parameterMap) {
        int withdrawAmount = validate(parameterMap.get("withdraw"));
        BankResult bankResult = bankManager.withdraw(withdrawAmount);
        BankModelView bankModelView = new BankModelView("withdraw-result");

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
