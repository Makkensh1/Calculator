import java.util.Locale;

public class Validator {
    final static int MAX_INT = 10;
    final static String IN_DATA_EXCEPTION = "строка не является математической операцией";
    final static String IN_DATA_OVERLOAD = "формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
    final static String MAX_IN_DATA = "Введенное значение больше 10";
    final static String DIF_SYSTEMS = "используются одновременно разные системы счисления";
    final static String UNKNOWN_OPERATION = "неправильная математическая операция";


    public Calculator validate(String inData) throws Exception {
        MathOperations operation ;
        int firstNumber;
        int secondNumber;
        boolean isItArab = false;
        boolean isItRoman = false;
        String[] massInputData = inData.toUpperCase(Locale.ROOT).split("\\s");
        if (massInputData.length > 3) {
            throw new Exception(IN_DATA_OVERLOAD);
        }
        try {
            operation = MathOperations.getByTitle(massInputData[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception(IN_DATA_EXCEPTION);
        }
        if (operation == null) {
            throw new Exception(UNKNOWN_OPERATION);
        }


        try {
            firstNumber = Integer.parseInt(massInputData[0]);
            if (firstNumber > MAX_INT) {
                throw new Exception(MAX_IN_DATA);
            }
            isItArab = true;
        } catch (NumberFormatException e) {
            firstNumber = RomanNumConverter.convertRomToArab(massInputData[0]);
            if (firstNumber > 0) {
                isItRoman = true;
            }
            if (firstNumber > MAX_INT) {
                throw new Exception(MAX_IN_DATA);
            }
        }
        try {
            secondNumber = Integer.parseInt(massInputData[2]);
            isItArab = true;
            if (secondNumber > MAX_INT) {
                throw new Exception(MAX_IN_DATA);
            }
        } catch (NumberFormatException e) {
            secondNumber = RomanNumConverter.convertRomToArab(massInputData[2]);
            if (secondNumber > 0) {
                isItRoman = true;
            }
            if (secondNumber > MAX_INT) {
                throw new Exception(MAX_IN_DATA);
            }
        }
        if (isItArab && isItRoman) {
            throw new Exception(DIF_SYSTEMS);
        }
        return new Calculator(isItArab, operation, firstNumber, secondNumber);
    }
}



