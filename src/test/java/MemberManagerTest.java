package work.atm.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import work.atm.step2.domain.member.Account;
import work.atm.step2.domain.member.Member;
import work.atm.step2.domain.member.MemberManager;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MemberManagerTest {
    @DisplayName("멤버 매니지먼트 객체 생성을 확인한다")
    @Test
    void createTest() {
        Account account1 = new Account( 1000, "abc123");
        Account account2 = new Account( 1000, "bcd234");
        Member member1 = new Member("홍길동", "abc123", "1111", account1);
        Member member2 = new Member("김길동", "bcd234","2222", account2);

        assertThatCode(() -> new MemberManager(member1, member2))
                .doesNotThrowAnyException();
    }

    @Test
    void validateRegisterFunction() {
        MemberManager memberManager = new MemberManager();
        Account account1 = new Account( 1000, "abc123");
        Member member1 = new Member("홍길동", "abc123", "1111", account1);

        assertThatCode(()-> memberManager.add(member1)).doesNotThrowAnyException();
    }
}
