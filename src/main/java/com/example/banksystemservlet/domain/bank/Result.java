package work.atm.step3.domain.bank;

import java.util.Objects;

public class Result {
    private final boolean result;
    private final String message;

    public Result(String message, boolean result) {
        this.message = message;
        this.result = result;
    }

    public boolean isSuccess() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return result == result1.result && Objects.equals(message, result1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, message);
    }

    public String getMessage() {
        return message;
    }

    public void show() {
        System.out.println(message + "\n");
    }

    public boolean isQuit() {
        return message.equals("종료합니다");
    }
}
