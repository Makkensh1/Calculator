public class   Calculator {
    private boolean isArab;
    private MathOperations operation;
    private int firstNumber;
    private int secondNumber;
    final static String WRONG_ROMAN_RESULT = "в римской системе нет отрицательных чисел и 0";
    final static String WRONG_DIVISION = "на ноль делить нельзя";

    public Calculator(boolean isItArab, MathOperations operation, int firstNumber, int secondNumber) {
        this.isArab = isItArab;
        this.operation = operation;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public String calc() throws Exception {
        if (secondNumber == 0 && operation.equals(MathOperations.Division)) {
            throw new Exception(WRONG_DIVISION);
        }
        int result = operation.getResult(firstNumber, secondNumber);
        String resultString = "";
        if (isArab) {
            resultString = Integer.toString(result);
        } else if (result < 1) {
            throw new Exception(WRONG_ROMAN_RESULT);
        } else {
            resultString = RomanNumConverter.convertArabToRom(result);
        }
        return resultString;
    }
}

