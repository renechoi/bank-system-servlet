package com.example.banksystemservlet.result;

import com.example.banksystemservlet.domain.bank.Account;
import com.example.banksystemservlet.domain.member.Member;

import java.util.Map;

public record BankResult(String message, boolean result, Map<Member, Account> memberWithAccount)  {

}
