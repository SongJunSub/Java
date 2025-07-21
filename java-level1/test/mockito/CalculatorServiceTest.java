package test.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorServiceTest {

    @Mock
    Calculator calculator;

    @InjectMocks
    CalculatorService calculatorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPerformAddition() {
        when(calculator.add(10, 20)).thenReturn(30);
        assertEquals(30, calculatorService.performAddition(10, 20));
    }

    @Test
    public void testPerformSubtraction() {
        when(calculator.subtract(30, 10)).thenReturn(20);
        assertEquals(20, calculatorService.performSubtraction(30, 10));
    }
}