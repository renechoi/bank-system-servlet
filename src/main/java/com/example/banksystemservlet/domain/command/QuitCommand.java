package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;

public class QuitCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "0".equals(userInput);
    }

    @Override
    public BankResult doBankJob(Bank bank) {
        return bank.quit();
    }
}
