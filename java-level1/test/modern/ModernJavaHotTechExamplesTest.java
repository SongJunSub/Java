package modern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ModernJavaHotTechExamplesTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("람다와 함수형 인터페이스 예제 테스트")
    void lambdaAndFunctionalInterfaceTest() {
        ModernJavaHotTechExamples.lambdaAndFunctionalInterface();
        String expectedOutput = "람다 예제 - '실무 람다!' 길이: 5\nKey: Java, Value: 21\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Optional 예제 테스트")
    void optionalExampleTest() {
        ModernJavaHotTechExamples.optionalExample();
        String expectedOutput = "Optional 예제 - 이름 (null): 이름 없음\nOptional 예제 - 이메일: test@example.com\nOptional 예제 - 이메일 대문자 변환: UNKNOWN\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Stream API 예제 테스트")
    void streamApiExampleTest() {
        ModernJavaHotTechExamples.streamApiExample();
        String expectedOutput = "Spring\nKotlin\nPython\nStream API 예제 - 'J'로 시작하는 요소 개수: 1\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Record 예제 테스트")
    void recordExampleTest() {
        ModernJavaHotTechExamples.recordExample();
        String expectedOutput = "Record 예제 - User: User[name=홍길동, age=30]\nRecord 예제 - User 이름: 홍길동\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("LocalDate/Time API 예제 테스트")
    void localDateTimeExampleTest() {
        ModernJavaHotTechExamples.localDateTimeExample();
        // 날짜는 매번 달라지므로, 특정 부분만 검증하거나 패턴 매칭을 사용해야 함.
        // 여기서는 간단히 출력 내용이 비어있지 않음을 확인.
        assertFalse(outContent.toString().isEmpty());
        assertTrue(outContent.toString().contains("LocalDate 예제"));
    }

    @Test
    @DisplayName("CompletableFuture 예제 테스트")
    void completableFutureExampleTest() throws Exception {
        ModernJavaHotTechExamples.completableFutureExample();
        String output = outContent.toString();
        assertTrue(output.contains("CompletableFuture 예제 - 비동기 작업 시작..."));
        assertTrue(output.contains("비동기 작업 실행 중..."));
        assertTrue(output.contains("메인 스레드는 다른 작업 수행..."));
        assertTrue(output.contains("비동기 결과 처리: 비동기 결과!"));
        assertTrue(output.contains("CompletableFuture 예제 - 최종 결과: 비동기 결과!"));
    }

    @Test
    @DisplayName("Lombok 예제 테스트")
    void lombokExampleTest() {
        ModernJavaHotTechExamples.lombokExample();
        String expectedOutput = "Lombok은 별도 라이브러리 설정이 필요합니다. 주석을 참고하세요.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("var 키워드 예제 테스트")
    void varKeywordExampleTest() {
        ModernJavaHotTechExamples.varKeywordExample();
        String output = outContent.toString();
        assertTrue(output.contains("var 키워드 예제 - message: java.lang.String"));
        assertTrue(output.contains("var 키워드 예제 - numbers: java.util.ImmutableCollections$ListN"));
        assertTrue(output.contains("var 키워드 예제 - map: java.util.HashMap"));
    }

    @Test
    @DisplayName("Switch Expressions 예제 테스트")
    void switchExpressionsExampleTest() {
        ModernJavaHotTechExamples.switchExpressionsExample(3);
        ModernJavaHotTechExamples.switchExpressionsExample(7);
        String expectedOutput = "Switch Expressions 예제 - 3일은 주중입니다.\nSwitch Expressions 예제 - 7일은 주말입니다.\nSwitch Expressions 예제 - num: 십\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Text Blocks 예제 테스트")
    void textBlocksExampleTest() {
        ModernJavaHotTechExamples.textBlocksExample();
        String output = outContent.toString();
        assertTrue(output.contains("Text Blocks 예제 - JSON:"));
        assertTrue(output.contains("\"name\": \"Java\""));
        assertTrue(output.contains("Text Blocks 예제 - HTML:"));
        assertTrue(output.contains("<h1>Hello, Text Blocks!</h1>"));
    }

    @Test
    @DisplayName("Sealed Classes 예제 테스트")
    void sealedClassesExampleTest() {
        ModernJavaHotTechExamples.sealedClassesExample();
        String output = outContent.toString();
        assertTrue(output.contains("Sealed Classes 예제 - 원 면적:"));
        assertTrue(output.contains("Sealed Classes 예제 - 사각형 면적:"));
    }

    @Test
    @DisplayName("예외 처리 개선 예제 테스트")
    void exceptionHandlingExampleTest() {
        // System.in을 Mocking하기 어려우므로, 콘솔 출력과 예외 발생 여부만 확인
        ModernJavaHotTechExamples.exceptionHandlingExample();
        String output = outContent.toString();
        assertTrue(output.contains("try-with-resources 예제 - 숫자를 입력하세요"));
        assertTrue(output.contains("입력 처리 완료 (Scanner 자동 종료)"));
        assertTrue(output.contains("사용자 정의 예외 발생: 나이가 18세 미만입니다."));
        assertTrue(output.contains("나이 유효성 검사 통과: 20"));
    }
}
