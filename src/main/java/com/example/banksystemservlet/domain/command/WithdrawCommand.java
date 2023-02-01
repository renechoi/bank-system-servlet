package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.ui.InputView;

public class WithdrawCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "6".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.withdraw2(requestWithdrawAmount());
    }

    private int requestWithdrawAmount() {
        return InputView.getAmount("출금");
    }
}
