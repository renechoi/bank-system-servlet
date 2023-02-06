package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class LoginResultBankController implements BankController {
    @Override
    public BankModelView process(Bank bank, Map<String, String> parameterMap) {

        String memberId = parameterMap.get("memberId");
        String password = parameterMap.get("password");
        Member member = new Member("임시 이름", memberId, password);

        BankResult bankResult = bank.login(member.getMemberId(), member.getPassword());

        BankModelView bankModelView = new BankModelView("login-result");

        bankModelView.getModel().put("member", member);
        bankModelView.getModel().put("bankResult", bankResult);
        return bankModelView;
    }
}
