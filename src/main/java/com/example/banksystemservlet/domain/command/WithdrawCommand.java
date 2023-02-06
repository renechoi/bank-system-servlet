package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.ui.InputView;

public class WithdrawCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "6".equals(userInput);
    }

    @Override
    public BankResult doBankJob(Bank bank) {
        return bank.withdraw(requestWithdrawAmount());
    }

    private int requestWithdrawAmount() {
        return InputView.getAmount("출금");
    }
}
