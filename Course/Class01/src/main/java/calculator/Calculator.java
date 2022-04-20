package calculator;

public class Calculator {

    public Calculator() {
        printLine();
    }

    private void printLine() {
        System.out.println("initialized calculator");
    }

    public int add(int number1, int number2) {return number1 + number2;}

    public static int multi(int number1, int number2) {
        return number1 * number2;
    }

    protected void is_protected() {
        System.out.println("I am protected ))");
    }

}
