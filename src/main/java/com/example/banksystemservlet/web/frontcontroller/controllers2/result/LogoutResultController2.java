package com.example.banksystemservlet.web.frontcontroller.controllers2.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.web.frontcontroller.controllers2.Controller2;
import com.example.banksystemservlet.web.frontcontroller.controllers2.ModelView;

import java.util.Map;

public class LogoutResultController2 implements Controller2 {
    @Override
    public ModelView process(Bank bank, Map<String, String> parameterMap) {
        bank.logout();
        return new ModelView("logout-result");
    }
}
