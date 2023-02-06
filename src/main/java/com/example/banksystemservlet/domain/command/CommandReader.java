package com.example.banksystemservlet.domain.command;



import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;

import java.util.Arrays;
import java.util.List;

public class CommandReader {

    private final List<Command> commands;

    public CommandReader(Command... commands) {
        this.commands = Arrays.asList(commands);
    }

    public BankResult handleCommand(Bank bank, String userInput) {
        return commands.stream()
                .filter(command -> command.support(userInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 명령입니다."))
                .doBankJob(bank);
    }
}
