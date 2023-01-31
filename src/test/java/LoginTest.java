package work.atm.step2;

import org.junit.jupiter.api.Test;
import work.atm.step2.domain.bank.Bank;
import work.atm.step2.domain.member.Account;
import work.atm.step2.domain.member.Member;
import work.atm.step2.domain.member.MemberManager;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LoginTest {
    @Test
    void createTest() {

        // 멤버 아이디를 받았을 때
        // 그 멤버 아이디가 뱅크 회원 중에 있다면 => 로그인을 시켜라
        Bank bank = new Bank();
        Member member = new Member("홍길동", "abc123", "1111", new Account(1000, "abc123"));
        MemberManager memberManager = new MemberManager(member);

        String requestedId1 = "abc123";
        String requestedPassword1 = "123";
        assertThatCode( ()-> bank.login(requestedId1, requestedPassword1) ).doesNotThrowAnyException();

        String requestedId2 = "abc";
        String requestedPassword2 = "123";
        assertThatCode( ()-> bank.login(requestedId2,requestedPassword2 ) ).isInstanceOf(IllegalArgumentException.class);

    }
}
