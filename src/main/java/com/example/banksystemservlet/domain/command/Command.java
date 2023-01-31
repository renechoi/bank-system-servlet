package work.atm.step3.domain.command;

import work.atm.step3.domain.bank.Bank;
import work.atm.step3.domain.bank.Result;

public interface Command {
    boolean support(String userInput);

    Result doBankJob(Bank bank);

}
