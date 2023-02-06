package com.example.banksystemservlet.web.bankControllers.form;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class DepositFormBankController implements BankController {
    @Override
    public BankModelView process(Bank bank, Map<String, String> parameterMap) {
        return new BankModelView("deposit-form");
    }
}
