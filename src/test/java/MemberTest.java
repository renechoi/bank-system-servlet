package work.atm.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import work.atm.step2.domain.member.Account;
import work.atm.step2.domain.member.Member;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MemberTest {
    @DisplayName("멤버 객체 생성을 확인한다.")
    @Test
    void createTest() {
        assertThatCode(()-> new Member(
                "홍길동",
                "abc123","1111",
                new Account(  1000, "abc123")    ))
                .doesNotThrowAnyException();
    }


}
