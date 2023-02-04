package com.example.banksystemservlet.web.frontcontroller.controllers2;

import com.example.banksystemservlet.domain.bank.Bank;

import java.util.Map;

public interface Controller2 {
    ModelView process(Bank bank, Map<String, String> parameterMap);
}
