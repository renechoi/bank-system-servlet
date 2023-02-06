package com.example.banksystemservlet.web.bankControllers;

import com.example.banksystemservlet.domain.bank.Bank;

import java.util.Map;

public interface BankController {
    BankModelView process(Bank bank, Map<String, String> parameterMap);
}
