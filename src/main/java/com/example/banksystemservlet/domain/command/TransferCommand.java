package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.ui.InputView;

public class TransferCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "7".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.transfer2(requestMemberId(), requestTransferAmount());
    }

    private int requestTransferAmount() {
        return InputView.getAmount("송금");
    }

    private String requestMemberId() {
        return InputView.getMemberId("송금");
    }
}
