public abstract class MathOperations implements Calculable {

    private String title;

    MathOperations(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    static MathOperations Addition = new MathOperations("+") {

        public int getResult(int firstNumber, int secondNumber) {
            return firstNumber + secondNumber;
        }
    };

    static MathOperations Subtraction = new MathOperations("-") {
        @Override
        public int getResult(int firstNumber, int secondNumber) {
            return firstNumber - secondNumber;
        }
    };

    static MathOperations Multiplication = new MathOperations("*") {
        @Override
        public int getResult(int firstNumber, int secondNumber) {
            return firstNumber * secondNumber;
        }
    };

    static MathOperations Division = new MathOperations("/") {
        @Override
        public int getResult(int firstNumber, int secondNumber) {
            return firstNumber / secondNumber;
        }
    };


    public static MathOperations getByTitle(String inTitle) {
        MathOperations result;
        if (Addition.title.equals(inTitle)) {
            result = Addition;
        } else if (Subtraction.title.equals(inTitle)) {
            result = Subtraction;
        } else if (Multiplication.title.equals(inTitle)) {
            result = Multiplication;
        } else if (Division.title.equals(inTitle)) {
            result = Division;
        } else {
            return null;
        }
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MathOperations operation)) {
            return false;
        }
        return title.equals(operation.getTitle());
    }
}


