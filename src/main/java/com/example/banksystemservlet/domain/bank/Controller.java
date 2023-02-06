package com.example.banksystemservlet.domain.bank;


import com.example.banksystemservlet.domain.command.*;
import com.example.banksystemservlet.ui.InputView;

public class Controller {

    public void openBank() {
        Bank bank = new Bank();
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
            BankResult bankResult = commandReader.handleCommand(bank, InputView.getSystemCommand());
            bankResult.show();
            if (bankResult.isQuit()) {
                return;
            }
            runBank(bank, commandReader);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            runBank(bank, commandReader);
        }
    }
}
