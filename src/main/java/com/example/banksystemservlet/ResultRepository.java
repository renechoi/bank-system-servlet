package com.example.banksystemservlet;

import com.example.banksystemservlet.domain.bank.BankResult;

import java.util.Map;

public class ResultRepository {

    public static Result result;

    public ResultRepository() {
    }

    public static void saveBankResult(Map<String, Object> model){
        result = (BankResult) model.get("bankResult");
    }
}
