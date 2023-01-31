package work.atm.step3.domain.command;

import work.atm.step3.domain.bank.Bank;
import work.atm.step3.domain.bank.Result;
import work.atm.step3.ui.InputView;

public class DepositCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "5".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.deposit(requestDepositAmount());
    }

    private int requestDepositAmount() {
        return InputView.getAmount("입금");
    }

}
