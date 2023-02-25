package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.result.BankResult;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class TransferResultBankController implements BankController {
    @Override
    public BankModelView process(Bank bank, Map<String, String> parameterMap) {
        String transferId = parameterMap.get("transferId");
        int transferAmount = Integer.parseInt(parameterMap.get("transferAmount"));

        BankResult bankResult = bank.transfer(transferId, transferAmount);
        BankModelView bankModelView = new BankModelView("transfer-result");

        bankModelView.getModel().put("bankResult", bankResult);
        return bankModelView;
    }
}
