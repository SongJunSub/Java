package optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        // Optional.of() : null이 아닌 값을 감싸는 Optional 객체 생성
        Optional<String> optionalValue = Optional.of("Hello");
        System.out.println("of() : " + optionalValue.get());

        // Optional.ofNullable() : null일 수도 있는 값을 감싸는 Optional 객체 생성
        Optional<String> nullableValue = Optional.ofNullable(null);
        System.out.println("ofNullable() : " + nullableValue.orElse("Default"));

        // isPresent() : 값이 존재하는지 확인
        if (optionalValue.isPresent()) {
            System.out.println("isPresent() : Value is present");
        }

        // ifPresent() : 값이 존재할 경우에만 동작 수행
        optionalValue.ifPresent(value -> System.out.println("ifPresent() : " + value.toUpperCase()));

        // orElse() : 값이 없을 경우 기본값 반환
        String value1 = nullableValue.orElse("Default Value");
        System.out.println("orElse() : " + value1);

        // orElseGet() : 값이 없을 경우 Supplier를 통해 기본값 제공
        String value2 = nullableValue.orElseGet(() -> "Default value from Supplier");
        System.out.println("orElseGet() : " + value2);

        // orElseThrow() : 값이 없을 경우 예외 발생
        try {
            nullableValue.orElseThrow(() -> new IllegalStateException("Value not present"));
        } catch (IllegalStateException e) {
            System.out.println("orElseThrow() : " + e.getMessage());
        }
    }
}
