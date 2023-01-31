package work.atm.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import work.atm.step2.domain.command.RegisterCommand;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterCommandTest {
    @DisplayName("회원가입 명령의 유효성을 검증한다")
    @Test
    void validateInput() {
        String expected = "1";
        String actual = mockUserInput(expected);
        assertEquals(expected, actual);

        RegisterCommand registerCommand = new RegisterCommand();
        assertThatCode(() -> registerCommand.support(expected)).doesNotThrowAnyException();
    }

    private static String mockUserInput(String expected) {
        System.setIn(new ByteArrayInputStream(String.format("%s\n", expected).getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        printStream.println((userInput));

        return byteArrayOutputStream.toString().trim();
    }
}
