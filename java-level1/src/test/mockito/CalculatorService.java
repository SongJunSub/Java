package test.mockito;

public class CalculatorService {
    private Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int performAddition(int a, int b) {
        return calculator.add(a, b);
    }

    public int performSubtraction(int a, int b) {
        return calculator.subtract(a, b);
    }
}