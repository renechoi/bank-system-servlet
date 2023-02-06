package com.example.banksystemservlet.web.bankControllers.result;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.web.bankControllers.BankController;
import com.example.banksystemservlet.web.bankControllers.BankModelView;

import java.util.Map;

public class RegisterResultBankController implements BankController {
    @Override
    public BankModelView process(Bank bank, Map<String, String> parameterMap) {

        Member member = new Member(
                parameterMap.get("memberName"),
                parameterMap.get("memberId"),
                parameterMap.get("password"));

        BankResult bankResult = bank.register(member);
        BankModelView bankModelView = new BankModelView("register-result");

        bankModelView.getModel().put("member", member);
        bankModelView.getModel().put("bankResult", bankResult);
        return bankModelView;
    }

}
