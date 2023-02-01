package com.example.banksystemservlet.domain.command;


import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.ui.InputView;

public class RegisterCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "1".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.register2(new Member(requestMemberName(), requestMemberId(), requestMemberPassword()));
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
