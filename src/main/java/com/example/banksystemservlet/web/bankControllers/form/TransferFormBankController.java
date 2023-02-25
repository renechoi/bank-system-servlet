package com.example.banksystemservlet.web.bankControllers.form;

import com.example.banksystemservlet.domain.bank.BankManager;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class TransferFormBankController implements BankController {
    @Override
    public BankModelView process(BankManager bankManager, Map<String, String> parameterMap) {
        return new BankModelView("transfer-form");
    }
}
