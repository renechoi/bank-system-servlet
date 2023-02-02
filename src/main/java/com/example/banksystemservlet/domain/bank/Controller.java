package com.example.banksystemservlet.domain.bank;


import com.example.banksystemservlet.domain.command.*;
import com.example.banksystemservlet.domain.jdbc.JdbcTemplate;
import com.example.banksystemservlet.domain.member.AccountDao;
import com.example.banksystemservlet.domain.member.MemberDao;
import com.example.banksystemservlet.ui.InputView;

public class Controller {

    public void openBank() {
        JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
        Bank bank = new Bank(new MemberDao(jdbcTemplate), new AccountDao(jdbcTemplate));
        CommandReader commandReader = new CommandReader(
                new RegisterCommand(),
                new UnregisterCommand(),
                new LoginCommand(),
                new LogoutCommand(),
                new DepositCommand(),
                new WithdrawCommand(),
                new TransferCommand(),
                new CheckBalanceCommand(),
                new QuitCommand()
        );

        runBank(bank, commandReader);
    }

    private void runBank(Bank bank, CommandReader commandReader) {
        try {
            bank.showCurrentlyLogin();
            Result result = commandReader.handleCommand(bank, InputView.getSystemCommand());
            result.show();
            if (result.isQuit()) {
                return;
            }
            runBank(bank, commandReader);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            runBank(bank, commandReader);
        }
    }
}
