package com.example.banksystemservlet.console.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.console.ui.InputView;

public class DepositCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "5".equals(userInput);
    }

    @Override
    public BankResult doBankJob(Bank bank) {
        return bank.deposit(requestDepositAmount());
    }

    private int requestDepositAmount() {
        return InputView.getAmount("입금");
    }

}
