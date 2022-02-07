import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Boolean> testResults = List.of(
                getTestResult("1 + 1", "2"), //1
                getTestResult("1 + V", Validator.DIF_SYSTEMS), //2
                getTestResult("11 + 1", Validator.MAX_IN_DATA), //3
                getTestResult("V + V", "X"), //4
                getTestResult("1", Validator.IN_DATA_EXCEPTION), //5
                getTestResult("1 O X", Validator.UNKNOWN_OPERATION), //6
                getTestResult("1O1231", Validator.IN_DATA_EXCEPTION),//7
                getTestResult("XV + 5", Validator.MAX_IN_DATA), //8
                getTestResult("XV", Validator.IN_DATA_EXCEPTION), //9
                getTestResult("1 / 0", Calculator.WRONG_DIVISION) //10
        );
        Integer ind = 1;
        for (boolean result : testResults) {
            System.out.println(ind.toString() + " " + result);
            ind++;
        }
    }

    static boolean getTestResult(String inputData, String expectedResult) {
        boolean result = false;
        Validator validator = new Validator();
        Calculator calculator;
        try {
            calculator = validator.validate(inputData);
            result = calculator.calculate().equals(expectedResult);
        } catch (Exception e) {
            result = e.getMessage().equals(expectedResult);
        }
        return result;
    }
}

