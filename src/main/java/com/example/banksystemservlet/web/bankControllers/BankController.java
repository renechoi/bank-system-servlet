package com.example.banksystemservlet.web.bankControllers;

import com.example.banksystemservlet.domain.bank.BankManager;

import java.util.Map;

public interface BankController {
    BankModelView process(BankManager bankManager, Map<String, String> parameterMap);
}
