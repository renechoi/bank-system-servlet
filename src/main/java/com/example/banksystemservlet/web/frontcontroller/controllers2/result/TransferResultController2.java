package com.example.banksystemservlet.web.frontcontroller.controllers2.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.web.frontcontroller.controllers2.Controller2;
import com.example.banksystemservlet.web.frontcontroller.controllers2.ModelView;

import java.util.Map;

public class TransferResultController2 implements Controller2 {
    @Override
    public ModelView process(Bank bank, Map<String, String> parameterMap) {
        String transferId = parameterMap.get("transferId");
        int transferAmount = Integer.parseInt(parameterMap.get("transferAmount"));
        bank.transfer2(transferId, transferAmount);
        return new ModelView("transfer-result");
    }
}
