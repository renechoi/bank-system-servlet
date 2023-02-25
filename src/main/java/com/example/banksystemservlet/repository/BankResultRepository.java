package com.example.banksystemservlet.repository;

import com.example.banksystemservlet.result.BankResult;
import com.example.banksystemservlet.result.Result;

import java.util.Map;

public class BankResultRepository {

    public static Result result;

    public BankResultRepository() {
    }

    public static void saveBankResult(Map<String, Object> model){
        result = (BankResult) model.get("bankResult");
    }
}
