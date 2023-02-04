package com.example.banksystemservlet.web.frontcontroller.controllers2.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.web.frontcontroller.BankView;
import com.example.banksystemservlet.web.frontcontroller.controllers2.Controller2;
import com.example.banksystemservlet.web.frontcontroller.controllers2.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class DepositResultController2 implements Controller2 {
    @Override
    public ModelView process(Bank bank, Map<String, String> parameterMap) {
        int depositAmount = validate(parameterMap.get("deposit"));
        bank.deposit2(depositAmount);
        return new ModelView("deposit-result");
    }

    private int validate(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (Exception e) {
            throw new IllegalArgumentException("input not valid");
        }
    }
}
