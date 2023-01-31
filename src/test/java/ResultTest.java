package work.atm.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import work.atm.step2.domain.bank.Result;

import static org.assertj.core.api.Assertions.*;

public class ResultTest {
    @DisplayName("Result 객체 생성을 확인한다")
    @Test
    void createTest() {
        assertThatCode(()-> new Result("콘솔 메시지", true))
                .doesNotThrowAnyException();
    }

    @Test
    void validateResultWhenSuccess() {
        Result result = new Result("성공하였습니다.", true);
        assertThat(result.isSuccess()).isEqualTo(true);
    }
}
