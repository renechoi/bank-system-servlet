package work.atm.step3.domain.command;

import work.atm.step3.domain.bank.Bank;
import work.atm.step3.domain.bank.Result;
import work.atm.step3.ui.InputView;

public class TransferCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "7".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.transfer(requestMemberId(), requestTransferAmount());
    }

    private int requestTransferAmount() {
        return InputView.getAmount("송금");
    }

    private String requestMemberId() {
        return InputView.getMemberId("송금");
    }
}
