package com.example.banksystemservlet.result;

import com.example.banksystemservlet.domain.bank.Account;
import com.example.banksystemservlet.domain.member.Member;
import com.example.banksystemservlet.domain.member.MemberData;

import java.util.Map;
import java.util.Objects;

public record BankResult2(String message, boolean result, Map<Member, Account> memberWithAccount)  {

}
