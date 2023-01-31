package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.ui.InputView;

public class LogoutCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "4".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.logout();
    }

    private String requestMemberId() {
        return InputView.getMemberId("로그아웃");
    }
}
