package com.example.banksystemservlet.domain.command;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;

public interface Command {
    boolean support(String userInput);

    BankResult doBankJob(Bank bank);

}
