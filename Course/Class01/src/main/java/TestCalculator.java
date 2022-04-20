import calculator.Calculator;

public class TestCalculator {

    public static void main(String[] args) {

        int x = 6;
        int y = 8;

        //Init & static
        Calculator calculator0 = new Calculator();
        Calculator calculator1 = new Calculator();

        System.out.println(calculator0.add(x, y));
        System.out.println(Calculator.multi(x, y));

        //Shows error, since function is private
        //calculator.printLine();

        //Shows error, since function is protected
        //calculator.is_protected();

    }
}
