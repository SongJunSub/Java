package collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionAdvancedExamplesTest {

    private final CollectionAdvancedExamples examples = new CollectionAdvancedExamples();

    @Test
    @DisplayName("불변 리스트에 원소를 추가하면 UnsupportedOperationException이 발생한다.")
    void immutableCollectionsTest() {
        assertThrows(UnsupportedOperationException.class, () -> {
            List<String> immutableList = List.of("A", "B");
            immutableList.add("C");
        });
    }
}
