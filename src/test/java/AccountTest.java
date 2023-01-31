package work.atm.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import work.atm.step2.domain.member.Account;

import static org.assertj.core.api.Assertions.assertThatCode;

public class AccountTest {
    @DisplayName("계좌 생성을 확인한다.")
    @Test
    void createTest() {
        assertThatCode(()-> new Account( 1000, "abc123"))
                .doesNotThrowAnyException();
    }
}
