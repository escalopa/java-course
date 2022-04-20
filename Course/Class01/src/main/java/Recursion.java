public class Recursion {

    public static void main(String[] args) {
        int x = 20;

        //Calculating factorial with loop
        int results = 1;
        for (int i = x; i > 2; i--) {
            results = results * i;
        }
        System.out.println(results);

        //Use recursion
        System.out.println(factorial(10));

        //More recursion examples
        System.out.println(add_number_0(0));
        System.out.println(add_number_1(0));
    }

    //Calculating factorial with recursion
    public static int factorial(int number) {
        if (number == 1) return 1;
        return (number * factorial(number - 1));
    }

    //Find sum from 0 to number
    public static int add_number_0(int number) {
        if (number < 6) return number + add_number_0(number + 1);
        return 0;
    }

    //Find sum from 0 to number
    public static int add_number_1(int number) {
        if (number > 5) return 0;
        return number + add_number_1(number + 1);
    }

}
