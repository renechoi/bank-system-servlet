package work.atm.step2;

import org.junit.jupiter.api.Test;
import work.atm.step2.domain.bank.Bank;
import work.atm.step2.domain.member.Account;
import work.atm.step2.domain.member.Member;
import work.atm.step2.domain.member.MemberManager;

import static org.assertj.core.api.Assertions.assertThatCode;

public class BankTest {
    Bank bank = new Bank();

    @Test
    void validateRegisterFunction() {
        MemberManager memberManager = new MemberManager();
        Account account1 = new Account(1000, "abc123");
        Member member1 = new Member("홍길동", "abc123", "1111", account1);

        assertThatCode(() -> bank.register(member1)).doesNotThrowAnyException();
    }

    @Test
    void validateLoginFunction() {
        Member member = new Member("홍길동", "abc123", "1111", new Account(1000, "abc123"));
        bank.register(member);

        String requestedId1 = "abc123";
        String requestedPassword1 = "abc123";

        assertThatCode(() -> bank.login(requestedId1, requestedPassword1)).doesNotThrowAnyException();

        String requestedId2 = "abc";
        String requestedPassword2 = "abc";
        assertThatCode(() -> bank.login(requestedId2, requestedPassword2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUnregisterFunction() {
        Member member = new Member("홍길동", "abc123", "1111", new Account(1000, "abc123"));
        bank.register(member);

        String requestedId1 = "abc123";
        String requestedPassword1 = "abc123";
        assertThatCode(() -> bank.login(requestedId1, requestedPassword1)).doesNotThrowAnyException();
        assertThatCode(() -> bank.unRegister()).doesNotThrowAnyException();

    }
}
