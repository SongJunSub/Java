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
 *
 * Spring Boot, JPA, 테스트 등은 별도 프로젝트/환경이 필요하므로 이론 및 코드 스니펫만 주석으로 안내합니다.
 */

import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.time.*;

public class ModernJavaHotTechExamples {
    // 1. 람다와 함수형 인터페이스
    public static void lambdaAndFunctionalInterface() {
        Function<String, Integer> strLength = s -> s.length();
        System.out.println(strLength.apply("실무 람다!"));
    }

    // 2. Optional (널 안전 프로그래밍)
    public static void optionalExample() {
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("이름 없음"));
        name.ifPresentOrElse(
            n -> System.out.println("이름: " + n),
            () -> System.out.println("값이 없습니다.")
        );
    }

    // 3. Stream API (데이터 처리)
    public static void streamApiExample() {
        List<String> list = Arrays.asList("Java", "Spring", "Kotlin", "Groovy");
        list.stream()
            .filter(s -> s.length() > 5)
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }

    // 4. Record (Java 16+)
    public static void recordExample() {
        // record User(String name, int age) {} // 파일 최상단에 선언 필요 (JDK 16+)
        // User user = new User("홍길동", 30);
        // System.out.println(user);
        System.out.println("record는 JDK 16+에서 지원됩니다. 위 주석 참고");
    }

    // 5. LocalDate/Time API
    public static void localDateTimeExample() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusWeeks(1);
        System.out.println(today + " ~ " + nextWeek);
    }

    // 6. CompletableFuture (비동기)
    public static void completableFutureExample() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(500); } catch (Exception e) {}
            return "비동기 결과!";
        });
        System.out.println(future.get());
    }

    // 7. Lombok (코드 자동 생성)
    // LombokUser 클래스는 lombok 라이브러리와 별도 파일 필요
    // @Getter @Setter @ToString @Builder
    // public class LombokUser {
    //     private String name;
    //     private int age;
    // }
    // LombokUser user = LombokUser.builder().name("홍길동").age(30).build();
    // System.out.println(user);

    // 8. Spring Boot, JPA, 테스트 프레임워크 (이론 및 코드 스니펫)
    /*
    // Spring Boot REST Controller 예시
    @RestController
    public class HelloController {
        @GetMapping("/hello")
        public String hello() {
            return "Hello, Spring Boot!";
        }
    }

    // JPA Entity 예시
    @Entity
    public class Member {
        @Id @GeneratedValue
        private Long id;
        private String name;
    }

    // JUnit5 + AssertJ 테스트 예시
    @Test
    void sumTest() {
        int result = 2 + 3;
        assertThat(result).isEqualTo(5);
    }
    */

    public static void main(String[] args) throws Exception {
        System.out.println("[람다와 함수형 인터페이스]");
        lambdaAndFunctionalInterface();
        System.out.println("\n[Optional]");
        optionalExample();
        System.out.println("\n[Stream API]");
        streamApiExample();
        System.out.println("\n[Record]");
        recordExample();
        System.out.println("\n[LocalDate/Time API]");
        localDateTimeExample();
        System.out.println("\n[CompletableFuture]");
        completableFutureExample();
        System.out.println("\n[Lombok, Spring Boot, JPA, 테스트는 주석 참고]");
    }
} 