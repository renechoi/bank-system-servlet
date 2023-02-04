package com.example.banksystemservlet.web.frontcontroller.controllers2.form;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.web.frontcontroller.controllers2.Controller2;
import com.example.banksystemservlet.web.frontcontroller.controllers2.ModelView;

import java.util.Map;

public class WithdrawFormController2 implements Controller2 {
    @Override
    public ModelView process(Bank bank, Map<String, String> parameterMap) {
        return new ModelView("withdraw-form");
    }
}
