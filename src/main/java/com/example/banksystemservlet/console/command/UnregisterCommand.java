package com.example.banksystemservlet.console.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;

public class UnregisterCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "2".equals(userInput);
    }

    @Override
    public BankResult doBankJob(Bank bank) {
//        return bank.unRegister();
        return null;
    }
}
