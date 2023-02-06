package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.ui.InputView;

public class LoginCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "3".equals(userInput);
    }

    @Override
    public BankResult doBankJob(Bank bank) {
        return bank.login(requestMemberId(), requestMemberPassword());
    }

    private String requestMemberId() {
        return InputView.getMemberId("로그인");
    }

    private String requestMemberPassword() {
        return InputView.getMemberPassword("로그인");
    }

}
