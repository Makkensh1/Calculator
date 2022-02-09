import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input name:");
        String inputData = in.nextLine();
        Validator validator = new Validator();
        Calculator calculator;
        try {
            calculator = validator.validate(inputData);
            System.out.println(calculator.calc());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
