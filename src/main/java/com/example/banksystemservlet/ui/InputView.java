package work.atm.step3.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getSystemCommand() {
        System.out.print("[시스템] 1.회원가입 2.회원탈퇴 3.로그인 4.로그아웃 5.입금 6.출금 7.송금 8.잔액조회 0.종료: \n");
        return scanner.nextLine();
    }

    public static String getMemberName(String CommandType) {
        System.out.printf("[%s] 이름을 입력하세요: \n", CommandType);
        return scanner.nextLine();
    }

    public static String getMemberId(String CommandType) {
        System.out.printf("[%s] 아이디를 입력하세요: \n", CommandType);
        return scanner.nextLine();
    }

    public static String getMemberPassword(String CommandType) {
        System.out.printf("[%s] 비밀번호를 입력하세요: \n", CommandType);
        return scanner.nextLine();
    }

    public static int getAmount(String CommandType) {
        System.out.printf("[%s] 금액을 입력하세요: \n", CommandType);
        return Integer.parseInt(scanner.nextLine());
    }
}
