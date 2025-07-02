/*
 * 예외 처리 심화
 * - 커스텀 예외, 예외 전환, try-with-resources, 예외와 Optional/Result 패턴
 */
import java.util.Optional;

// 커스텀 예외
class MyException extends Exception {
    public MyException(String msg) { super(msg); }
}

public class CustomExceptionExamples {
    // 예외 전환
    public static int parseInt(String s) throws MyException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new MyException("정수 변환 실패: " + s);
        }
    }

    // Optional로 예외 처리
    public static Optional<Integer> safeParseInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        // try-with-resources
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.StringReader("123\nabc"))) {
            System.out.println(br.readLine());
        } catch (Exception e) {
            System.out.println("IO 예외: " + e.getMessage());
        }

        // 커스텀 예외 & 예외 전환
        try {
            parseInt("abc");
        } catch (MyException e) {
            System.out.println("커스텀 예외: " + e.getMessage());
        }

        // Optional 예외 처리
        Optional<Integer> result = safeParseInt("123a");
        System.out.println("Optional 결과: " + result.orElse(-1));
    }
} 