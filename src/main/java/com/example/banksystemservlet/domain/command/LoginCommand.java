package work.atm.step3.domain.command;

import work.atm.step3.domain.bank.Bank;
import work.atm.step3.domain.bank.Result;
import work.atm.step3.ui.InputView;

public class LoginCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "3".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.login(requestMemberId(), requestMemberPassword());
    }

    private String requestMemberId() {
        return InputView.getMemberId("로그인");
    }

    private String requestMemberPassword() {
        return InputView.getMemberPassword("로그인");
    }

}
