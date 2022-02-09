import model.CalculatorValue;

public class Calc {
    private CalculatorValue first;
    private CalculatorValue second;
    private MathOperations method;

    public Calc(CalculatorValue first, CalculatorValue second, MathOperations method) {
        this.first = first;
        this.second = second;
        this.method = method;
    }

    public CalculatorValue getFirst() {
        return first;
    }

    public void setFirst(CalculatorValue first) {
        this.first = first;
    }

    public CalculatorValue getSecond() {
        return second;
    }

    public void setSecond(CalculatorValue second) {
        this.second = second;
    }

    public MathOperations getMethod() {
        return method;
    }

    public void setMethod(MathOperations method) {
        this.method = method;
    }
}
