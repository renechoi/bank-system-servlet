package work.atm.step3.domain.member;

public class Account {
    private int accountNumber;
    private int balance;
    private final String memberId;

    public Account(int balance, String memberId) {
        this.balance = balance;
        this.memberId = memberId;
    }

    public Account(int accountNumber, int balance, String memberId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.memberId = memberId;
    }

    public void addAmount(int amount) {
        this.balance = this.balance + amount;
    }

    public void subtractAmount(int amount) {
        validateAmount(amount);
        this.balance = this.balance - amount;
    }

    private void validateAmount(int amount) {
        if (this.balance < amount) {
            throw new IllegalArgumentException("잔액이 충분하지 않습니다.");
        }
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMemberId() {
        return memberId;
    }

    public boolean matchId(String memberId) {
        return memberId.equals(this.memberId);
    }
}
