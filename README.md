# Java 학습 저장소

이 저장소는 Java 문법을 학습하고 실습하는 공간입니다.

## 리팩토링

*   `java-level1/src/class_01/Class_01.java`: 기존의 변수 선언 및 출력을 Student 객체와 리스트, Stream API를 사용하도록 리팩토링했습니다.
*   `java-level1/src/class_01/Class_02.java`: 배열을 사용하여 학생 정보를 관리하던 코드를 Student 객체와 리스트를 사용하도록 리팩토링했습니다.
*   `java-level1/src/class_01/Class_03.java`: 개별적인 Student 객체 변수들을 리스트로 묶어 관리하도록 리팩토링했습니다.
*   `java-level1/src/class_01/Class_04.java`: Student 객체 배열을 리스트로 변경하고, Stream API를 사용하여 출력하도록 리팩토링했습니다.
*   `java-level1/src/class_01/Class_05.java`: Student 객체 배열과 for문을 리스트와 Stream API로 변경하여 코드를 간소화했습니다.

## Optional

*   `java-level1/src/optional/OptionalExample.java`: `Optional` 클래스의 사용법을 보여주는 예제 코드를 추가했습니다. `of()`, `ofNullable()`, `isPresent()`, `ifPresent()`, `orElse()`, `orElseGet()`, `orElseThrow()` 등의 메소드를 활용하여 NPE를 방지하고 코드의 안정성을 높이는 방법을 학습할 수 있습니다.

## Lombok

*   `spring-boot-demo/build.gradle`: Lombok 의존성을 추가했습니다.
*   `spring-boot-demo/src/main/java/com/example/demo/HelloController.java`: `@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor` 어노테이션이 적용된 `User` 클래스를 포함하는 `HelloController` 예제를 추가했습니다.

## Spring Data JPA

*   `spring-boot-demo/build.gradle`: Spring Data JPA 및 H2 데이터베이스 의존성을 추가했습니다.
*   `spring-boot-demo/src/main/java/com/example/demo/User.java`: JPA 엔티티로 사용할 `User` 클래스를 정의했습니다.
*   `spring-boot-demo/src/main/java/com/example/demo/UserRepository.java`: `JpaRepository`를 상속받는 `UserRepository` 인터페이스를 정의했습니다.
*   `spring-boot-demo/src/main/java/com/example/demo/UserService.java`: `UserRepository`를 사용하여 비즈니스 로직을 처리하는 `UserService`를 정의했습니다.
*   `spring-boot-demo/src/main/java/com/example/demo/UserController.java`: `UserService`를 사용하여 RESTful API를 제공하는 `UserController`를 정의했습니다.

## Spring Security

*   `spring-boot-demo/build.gradle`: Spring Security 의존성을 추가했습니다.
*   `spring-boot-demo/src/main/java/com/example/demo/SecurityConfig.java`: Spring Security 설정을 추가하여 `/users/**` 경로에 대한 접근을 허용하고, 그 외 모든 요청은 인증을 요구하도록 구성했습니다.