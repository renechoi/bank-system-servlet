package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;

public class CheckBalanceCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "8".equals(userInput);
    }

    @Override
    public BankResult doBankJob(Bank bank) {
        return null;
//        return bank.checkBalance2();
    }
}
