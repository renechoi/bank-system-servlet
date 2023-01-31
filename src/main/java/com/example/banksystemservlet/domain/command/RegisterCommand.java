package work.atm.step3.domain.command;

import work.atm.step3.domain.bank.Bank;
import work.atm.step3.domain.bank.Result;
import work.atm.step3.domain.member.Member;
import work.atm.step3.ui.InputView;

public class RegisterCommand implements Command {
    @Override
    public boolean support(String userInput) {
        return "1".equals(userInput);
    }

    @Override
    public Result doBankJob(Bank bank) {
        return bank.register(new Member(requestMemberName(), requestMemberId(), requestMemberPassword()));
    }

    private String requestMemberName() {
        return InputView.getMemberName("회원가입");
    }

    private String requestMemberId() {
        return InputView.getMemberId("회원가입");
    }

    private String requestMemberPassword() {
        return InputView.getMemberPassword("회원가입");
    }
}
