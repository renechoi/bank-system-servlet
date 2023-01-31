package com.example.banksystemservlet.domain.command;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.Result;

public interface Command {
    boolean support(String userInput);

    Result doBankJob(Bank bank);

}
