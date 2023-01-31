package work.atm.step3.domain.command;

import work.atm.step3.domain.bank.Bank;
import work.atm.step3.domain.bank.Result;

public class QuitCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "0".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.quit();
    }
}
