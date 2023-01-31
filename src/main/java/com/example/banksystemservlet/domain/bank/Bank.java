package work.atm.step3.domain.bank;

import work.atm.step3.domain.member.AccountManager;
import work.atm.step3.domain.member.Member;
import work.atm.step3.domain.member.MemberManager;

public class Bank {

    public static final MemberManager MEMBER_MANAGER = new MemberManager();
    public static final AccountManager ACCOUNT_MANAGER = new AccountManager();
    private String currentlyLogin = "-1";

    public Result register(Member member) {
        validateRegisterId(member);
        try {
            MEMBER_MANAGER.add(member);
            ACCOUNT_MANAGER.create(member, MEMBER_MANAGER.getMemberCount());
        } catch (RuntimeException e) {
            return new Result("회원 가입에 실패하였습니다", false);
        }
        return new Result("회원 가입에 성공하였습니다", true);
    }

    public Result unRegister() {
        validateLoginOff();
        try {
            MEMBER_MANAGER.delete(validateLoginId(currentlyLogin));
            ACCOUNT_MANAGER.delete(currentlyLogin);
        } catch (RuntimeException e) {
            return new Result("회원 탈퇴에 실패하였습니다", false);
        }
        setLoginStatusNone();
        return new Result("회원 탈퇴에 성공하였습니다", true);
    }

    public Result login(String requestedId, String requestedPassword) {
        try {
            validateLoginOn();
            this.currentlyLogin = validateLoginIdAndPassword(requestedId, requestedPassword);
        } catch (RuntimeException e) {
            return new Result("로그인에 실패하였습니다 \n" + e.getMessage(), false);
        }
        return new Result("로그인에 성공하였습니다", true);
    }

    public Result logout() {
        try {
            validateLoginId(currentlyLogin);
        } catch (RuntimeException e) {
            return new Result("로그아웃에 실패하였습니다", false);
        }
        setLoginStatusNone();
        return new Result("로그아웃에 성공하였습니다", true);
    }

    public Result deposit(int amount) {
        validateLoginOff();
        try {
            Member member = MEMBER_MANAGER.getMember(currentlyLogin);
            ACCOUNT_MANAGER.deposit(member, amount);
        } catch (RuntimeException e) {
            return new Result("입금에 실패하였습니다", false);
        }
        return new Result("입금에 성공하였습니다", true);
    }

    public Result withdraw(int amount) {
        validateLoginOff();
        try {
            Member member = MEMBER_MANAGER.getMember(currentlyLogin);
            ACCOUNT_MANAGER.withdraw(member, amount);
        } catch (RuntimeException e) {
            return new Result("출금에 실패하였습니다", false);
        }
        return new Result("출금에 성공하였습니다", true);
    }

    public Result transfer(String requestMemberId, int requestTransferAmount) {
        validateLoginOff();
        try {
            ACCOUNT_MANAGER.withdraw(MEMBER_MANAGER.getMember(currentlyLogin), requestTransferAmount);
            ACCOUNT_MANAGER.deposit(MEMBER_MANAGER.getMember(requestMemberId), requestTransferAmount);
        } catch (RuntimeException e) {
            return new Result("송금에 실패하였습니다", false);
        }
        return new Result("송금에 성공하였습니다", true);
    }

    public Result checkBalance() {
        showAccount();
        return new Result("조회에 성공하였습니다", true);
    }

    public Result quit() {
        return new Result("종료합니다", true);
    }

    private void setLoginStatusNone() {
        this.currentlyLogin = "-1";
    }

    private void validateRegisterId(Member member) {
        if (MEMBER_MANAGER.exist(member)) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
    }

    private void validateLoginOff() {
        if (currentlyLogin.equals("-1")) {
            throw new IllegalArgumentException("로그인이 되어 있지 않습니다.");
        }
    }

    private void validateLoginOn() {
        if (!currentlyLogin.equals("-1")) {
            throw new IllegalArgumentException("현재 로그인이 되어 있습니다.");
        }
    }

    private String validateLoginId(String requestedId) {
        if (!currentlyLogin.equals(requestedId)) {
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");
        }
        return requestedId;
    }

    public String validateLoginIdAndPassword(String requestedId, String requestedPassword) {
        if (!MEMBER_MANAGER.match(requestedId, requestedPassword)) {
            throw new IllegalArgumentException("로그인 가능한 아이디가 없거나 비밀번호가 일치하지 않습니다");
        }
        return requestedId;
    }

    public void showCurrentlyLogin() {
        Runnable show = currentlyLogin.equals("-1") ?
                () -> System.out.print("") :
                () -> System.out.printf("[시스템] 현재 로그인한 계정: %s\n", currentlyLogin);
        show.run();
    }

    public void showAccount() {
        Member member = MEMBER_MANAGER.getMember(currentlyLogin);
        System.out.println(String.format("""
                        <잔액 조회>
                        고객번호: %s
                        계좌번호: %s
                        계좌명: %s
                        아이디: %s
                        잔액: %s
                        """,
                member.getMemberNumber(),
                ACCOUNT_MANAGER.getAccountNumber(member),
                member.getName(),
                member.getMemberId(),
                ACCOUNT_MANAGER.getBalance(member)
        ));
    }
}
