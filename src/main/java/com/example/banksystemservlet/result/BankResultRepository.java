package com.example.banksystemservlet.result;

import com.example.banksystemservlet.domain.bank.BankResult;

import java.util.Map;

public class BankResultRepository {

    public static Result result;

    public BankResultRepository() {
    }

    public static void saveBankResult(Map<String, Object> model){
        result = (BankResult) model.get("bankResult");
    }
}
