package com.example.banksystemservlet.console.command;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;

public interface Command {
    boolean support(String userInput);

    BankResult doBankJob(Bank bank);

}
