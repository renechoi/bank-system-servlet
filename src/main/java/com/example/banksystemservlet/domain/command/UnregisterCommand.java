package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;

public class UnregisterCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "2".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.unRegister2();
    }
}
