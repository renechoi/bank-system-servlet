package com.example.banksystemservlet.console.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.console.ui.InputView;

public class RegisterCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "1".equals(userInput);
    }

    @Override
    public BankResult doBankJob(Bank bank) {
        return bank.register(new Member(requestMemberName(), requestMemberId(), requestMemberPassword()));
    }

    private String requestMemberName() {
        return InputView.getMemberName("회원가입");
    }

    private String requestMemberId() {
        return InputView.getMemberId("회원가입");
    }

    private String requestMemberPassword() {
        return InputView.getMemberPassword("회원가입");
    }
}
