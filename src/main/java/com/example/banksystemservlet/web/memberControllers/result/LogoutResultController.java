package com.example.banksystemservlet.web.memberControllers.result;

import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.member.MemberManager;
import com.example.banksystemservlet.web.bankControllers.BankModelView;
import com.example.banksystemservlet.web.memberControllers.MemberController;
import com.example.banksystemservlet.web.memberControllers.MemberModelView;

import java.util.Map;

public class LogoutResultController implements MemberController {
    @Override
    public MemberModelView process(MemberManager memberManager, Map<String, String> parameterMap, Object result) {
//        BankResult bankResult = bank.logout();
        MemberModelView bankModelView = new MemberModelView("logout-result");

//        bankModelView.getModel().put("bankResult", bankResult);
        return bankModelView;
    }
}
