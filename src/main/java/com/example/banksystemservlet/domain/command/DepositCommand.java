package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.ui.InputView;

public class DepositCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "5".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.deposit(requestDepositAmount());
    }

    private int requestDepositAmount() {
        return InputView.getAmount("입금");
    }

}
