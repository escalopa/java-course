public class Basics {

    static int x;

    public static void main(String[] args) {

        //Naming vars
        final int CONSTANT = 2;
        int car_id = 4;
        int carId = 5;

        //Function calling
        int number = 7;
        System.out.println(power_function(number,3));
    }

    //Polymorphism
    public static double power_function(int number,int power){
       return Math.pow(number,power);
    }

    //Another method with the same name but a diff parameters
    public static void power_function(){}

    //Method with the same name & parameters are not allowed
    //public static void power_function(int number,int power){}
}
