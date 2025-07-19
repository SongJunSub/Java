package modern;

import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.time.*;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Modern Java Hot Tech 실무 예제 모음
 *
 * 1. 람다와 함수형 인터페이스
 * 2. Optional (널 안전 프로그래밍)
 * 3. Stream API (데이터 처리)
 * 4. Record (Java 16+)
 * 5. LocalDate/Time API
 * 6. CompletableFuture (비동기)
 * 7. Lombok (코드 자동 생성)
 * 8. var 키워드 (Local-Variable Type Inference)
 * 9. Switch Expressions
 * 10. Text Blocks
 * 11. Sealed Classes (봉인된 클래스)
 * 12. 예외 처리 개선 (try-with-resources, 사용자 정의 예외)
 *
 * Spring Boot, JPA, 테스트 등은 별도 프로젝트/환경이 필요하므로 이론 및 코드 스니펫만 주석으로 안내합니다.
 */

public class ModernJavaHotTechExamples {

    private static final Logger logger = LoggerFactory.getLogger(ModernJavaHotTechExamples.class);

    // 1. 람다와 함수형 인터페이스
    // - 간결한 코드 작성, 함수를 일급 객체처럼 다룰 수 있게 함.
    // - 주로 Stream API, 비동기 프로그래밍, 이벤트 핸들링 등에 활용.
    public static void lambdaAndFunctionalInterface() {
        Function<String, Integer> strLength = s -> s.length();
        logger.info("람다 예제 - '실무 람다!' 길이: {}", strLength.apply("실무 람다!"));

        // BiConsumer 예제: 두 개의 인자를 받아 처리하고 반환값이 없음
        BiConsumer<String, Integer> printKeyValue = (key, value) -> 
            logger.info("Key: {}, Value: {}", key, value);
        printKeyValue.accept("Java", 21);
    }

    // 2. Optional (널 안전 프로그래밍)
    // - NullPointerException 방지, 명시적인 널 처리.
    // - 값이 없을 수 있는 경우에 Optional을 반환하여 클라이언트 코드가 널 체크를 강제하도록 유도.
    public static void optionalExample() {
        Optional<String> name = Optional.ofNullable(null);
        logger.info("Optional 예제 - 이름 (null): {}", name.orElse("이름 없음"));

        Optional<String> email = Optional.of("test@example.com");
        email.ifPresentOrElse(
            e -> logger.info("Optional 예제 - 이메일: {}", e),
            () -> logger.info("Optional 예제 - 이메일이 없습니다.")
        );

        String result = email.map(String::toUpperCase).orElse("UNKNOWN");
        logger.info("Optional 예제 - 이메일 대문자 변환: {}", result);
    }

    // 3. Stream API (데이터 처리)
    // - 컬렉션 데이터를 선언형으로 처리. 필터링, 매핑, 집계 등.
    // - 내부 반복을 사용하여 병렬 처리 용이.
    public static void streamApiExample() {
        List<String> list = Arrays.asList("Java", "Spring", "Kotlin", "Groovy", "Python");
        logger.info("Stream API 예제 - 길이 5 초과, 대문자 변환:");
        list.stream()
            .filter(s -> s.length() > 5) // 중간 연산: 조건에 맞는 요소 필터링
            .map(String::toUpperCase)   // 중간 연산: 요소 변환
            .forEach(logger::info); // 최종 연산: 각 요소에 대해 작업 수행

        long count = list.stream().filter(s -> s.startsWith("J")).count();
        logger.info("Stream API 예제 - 'J'로 시작하는 요소 개수: {}", count);
    }

    // 4. Record (Java 16+)
    // - 데이터 운반 객체(DTO)를 간결하게 정의. 불변.
    // - equals(), hashCode(), toString(), 생성자, 접근자 자동 생성.
    public record User(String name, int age) {}

    public static void recordExample() {
        User user = new User("홍길동", 30);
        logger.info("Record 예제 - User: {}", user);
        logger.info("Record 예제 - User 이름: {}", user.name());
    }

    // 5. LocalDate/Time API
    // - 날짜와 시간을 불변 객체로 안전하게 다룸. 스레드 안전.
    // - 기존 Date, Calendar의 문제점 해결.
    public static void localDateTimeExample() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusWeeks(1);
        logger.info("LocalDate 예제 - 오늘: {}, 다음 주: {}", today, nextWeek);

        LocalTime now = LocalTime.now();
        LocalTime after30Mins = now.plusMinutes(30);
        logger.info("LocalTime 예제 - 현재: {}, 30분 후: {}", now.withNano(0), after30Mins.withNano(0));

        LocalDateTime currentDateTime = LocalDateTime.now();
        logger.info("LocalDateTime 예제 - 현재 날짜/시간: {}", currentDateTime.withNano(0));
    }

    // 6. CompletableFuture (비동기)
    // - 비동기 작업의 조합 및 결과 처리. 논블로킹.
    // - 병렬 처리, 마이크로서비스 간 통신 등에 유용.
    public static void completableFutureExample() throws Exception {
        logger.info("CompletableFuture 예제 - 비동기 작업 시작...");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try { 
                logger.info("비동기 작업 실행 중...");
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "비동기 결과!";
        }).thenApply(result -> {
            logger.info("비동기 결과 처리: {}", result);
            return result.toUpperCase();
        });

        logger.info("메인 스레드는 다른 작업 수행...");
        String finalResult = future.get(); // 결과가 올 때까지 블로킹 (실제로는 콜백으로 처리)
        logger.info("CompletableFuture 예제 - 최종 결과: {}", finalResult);
    }

    // 7. Lombok (코드 자동 생성)
    // - Getter, Setter, Constructor, toString 등 반복적인 코드 자동 생성.
    // - 코드량 감소, 가독성 향상. (별도 라이브러리 설정 필요)
    // @Getter @Setter @ToString @Builder
    // public class LombokUser {
    //     private String name;
    //     private int age;
    // }
    // LombokUser user = LombokUser.builder().name("홍길동").age(30).build();
    // logger.info(user);
    public static void lombokExample() {
        logger.info("Lombok은 별도 라이브러리 설정이 필요합니다. 주석을 참고하세요.");
    }

    // 8. var 키워드 (Local-Variable Type Inference)
    // - 지역 변수의 타입을 컴파일러가 추론. 코드 간결성 향상.
    // - 가독성을 해치지 않는 선에서 사용 권장.
    public static void varKeywordExample() {
        var message = "Hello, var!"; // String으로 추론
        var numbers = List.of(1, 2, 3); // List<Integer>로 추론
        var map = new HashMap<String, String>(); // HashMap<String, String>으로 추론

        logger.info("var 키워드 예제 - message: {}", message.getClass().getName());
        logger.info("var 키워드 예제 - numbers: {}", numbers.getClass().getName());
        logger.info("var 키워드 예제 - map: {}", map.getClass().getName());
    }

    // 9. Switch Expressions
    // - 더 간결하고 안전한 switch 문. 값으로 반환 가능.
    // - break 문 없이 화살표(->) 사용.
    public static void switchExpressionsExample(int day) {
        String dayType = switch (day) {
            case 1, 7 -> "주말";
            case 2, 3, 4, 5, 6 -> "주중";
            default -> "알 수 없음";
        };
        logger.info("Switch Expressions 예제 - {}일은 {}입니다.", day, dayType);

        // yield 키워드 사용 예시 (블록 내에서 값 반환)
        int num = 10;
        String result = switch (num) {
            case 10: yield "십";
            case 20: yield "이십";
            default: yield "기타";
        };
        logger.info("Switch Expressions 예제 - num: {}", result);
    }

    // 10. Text Blocks
    // - 여러 줄의 문자열을 쉽게 정의. 이스케이프 문자 없이 사용.
    // - SQL 쿼리, JSON, HTML 등 긴 문자열에 유용.
    public static void textBlocksExample() {
        String json = """
            {
                "name": "Java",
                "version": 21
            }
            """;
        logger.info("Text Blocks 예제 - JSON:\n{}", json);

        String html = """
            <html>
                <body>
                    <h1>Hello, Text Blocks!</h1>
                </body>
            </html>
            """;
        logger.info("Text Blocks 예제 - HTML:\n{}", html);
    }

    // 11. Sealed Classes (봉인된 클래스)
    // - 클래스 계층 구조를 명시적으로 제한. 특정 서브클래스만 상속/구현 허용.
    // - 유연성과 보안을 동시에 제공.
    public sealed interface Shape permits Circle, Rectangle {
        double area();
    }

    public record Circle(double radius) implements Shape {
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    public record Rectangle(double length, double width) implements Shape {
        @Override
        public double area() {
            return length * width;
        }
    }

    public static void sealedClassesExample() {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        logger.info("Sealed Classes 예제 - 원 면적: {}", circle.area());
        logger.info("Sealed Classes 예제 - 사각형 면적: {}", rectangle.area());

        // Shape unknownShape = new Triangle(); // 컴파일 오류: Triangle은 Shape를 permits 하지 않음
    }

    // 12. 예외 처리 개선 (try-with-resources, 사용자 정의 예외)
    // - try-with-resources: AutoCloseable 인터페이스를 구현한 리소스 자동 해제.
    // - 사용자 정의 예외: 특정 비즈니스 로직 오류를 명확하게 표현.
    static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static void exceptionHandlingExample() {
        // try-with-resources 예제
        try (Scanner scanner = new Scanner(System.in)) {
            logger.info("try-with-resources 예제 - 숫자를 입력하세요 (입력 후 Enter): ");
            // int num = scanner.nextInt(); // 실제 입력은 주석 처리
            logger.info("입력 처리 완료 (Scanner 자동 종료)");
        } catch (Exception e) {
            logger.error("오류 발생: {}", e.getMessage());
        }

        // 사용자 정의 예외 예제
        try {
            validateAge(15);
        } catch (CustomException e) {
            logger.error("사용자 정의 예외 발생: {}", e.getMessage());
        }

        try {
            validateAge(20);
        } catch (CustomException e) {
            logger.error("사용자 정의 예외 발생: {}", e.getMessage());
        }
    }

    public static void validateAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("나이가 18세 미만입니다.");
        }
        logger.info("나이 유효성 검사 통과: {}", age);
    }

    public static void main(String[] args) throws Exception {
        logger.info("\n--- 1. 람다와 함수형 인터페이스 ---");
        lambdaAndFunctionalInterface();

        logger.info("\n--- 2. Optional ---");
        optionalExample();

        logger.info("\n--- 3. Stream API ---");
        streamApiExample();

        logger.info("\n--- 4. Record ---");
        recordExample();

        logger.info("\n--- 5. LocalDate/Time API ---");
        localDateTimeExample();

        logger.info("\n--- 6. CompletableFuture ---");
        completableFutureExample();

        logger.info("\n--- 7. Lombok ---");
        lombokExample();

        logger.info("\n--- 8. var 키워드 ---");
        varKeywordExample();

        logger.info("\n--- 9. Switch Expressions ---");
        switchExpressionsExample(3);
        switchExpressionsExample(7);

        logger.info("\n--- 10. Text Blocks ---");
        textBlocksExample();

        logger.info("\n--- 11. Sealed Classes ---");
        sealedClassesExample();

        logger.info("\n--- 12. 예외 처리 개선 ---");
        exceptionHandlingExample();
    }
}