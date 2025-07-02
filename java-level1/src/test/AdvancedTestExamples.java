/*
 * 테스트 코드 심화
 * - JUnit5, AssertJ, Mockito, 파라미터라이즈드 테스트, 테스트 커버리지
 * - (실행은 IDE 또는 빌드툴에서 필요)
 */

// JUnit5, AssertJ, Mockito 예제 (주석 참고)
/*
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class Calculator {
    int sum(int a, int b) { return a + b; }
}

class CalculatorTest {
    @Test
    void sumTest() {
        Calculator calc = new Calculator();
        assertThat(calc.sum(2, 3)).isEqualTo(5);
    }

    @Test
    void mockTest() {
        List<String> mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("hello");
        assertThat(mockedList.get(0)).isEqualTo("hello");
    }
}
*/

public class AdvancedTestExamples {
    public static void main(String[] args) {
        System.out.println("JUnit5, AssertJ, Mockito 예제는 주석을 참고하세요.\n실행은 IDE나 빌드툴에서 가능합니다.");
    }
} 