import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input name:");
        String inputData = in.nextLine();
        //InputStreamReader inputStream = new InputStreamReader(System.in);
        // BufferedReader inputData = new BufferedReader(inputStream);
        String inData = String.valueOf(inputData);
       Validator validator = new Validator();
        Calculator calculator;
        try {
            calculator = validator.validate(inputData);
            System.out.println(calculator.calculate());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


//        System.out.println(RomanNumConverter.convertArabToRom(987));
    }
}
