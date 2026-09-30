package Part1;

import java.util.Scanner;

public class Part1Calculator {
    // scanner for all metods
    private static final Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {

        System.out.println("------------Welcome to calculator!------------");
        System.out.println("Input your first operand");
        double operand1 = scanner.nextDouble();  // input 1st operand

        boolean keepRunning = false;
        do  {
            System.out.println("Input your second operand");
            double operand2 = scanner.nextDouble();// input 2nd operand
            scanner.nextLine(); // clearing next line from double

            System.out.println("Input your operation(+;-;*;/)");
            String operation = scanner.nextLine();// operation input

            double result ;
            result = calculate(operation,operand1,operand2); // calling calculation method


                System.out.printf("Your result is: %.2f%n", result); // output the result rounded to 2 decimals


            keepRunning = askToContinue(result); // ask to continue method
            operand1 = result; //passing the result to 1st operand
        } while(keepRunning);
        System.out.println("Good Bye");
    }

    private static double calculate(String operation, double operand1, double operand2){ //calculation method
        switch (operation) { //defining the operation
            case "+" :
                return add(operand1, operand2); //operation method
            case "-" :
                return substract(operand1, operand2);
            case "*" :
                return multiply(operand1, operand2);
            case "/" : {
                if(operand2==0){
                    System.out.println("You cannot divide by zero");

                }
                return devide(operand1,operand2);

            }
            default: return 0;
        }
    }

    private static boolean askToContinue(double result) {
        while (true) {
            System.out.printf("Continue with %.2f as the first operand? (y - continue, q - quit): ", result);
            String answer = scanner.next().toLowerCase();
            if (answer.equals("y")) {
                return true;
            }
            if (answer.equals("q")) {
                return false;
            }
            System.out.println("Please enter 'y' or 'q'.");
        }
    }

    public static Double add(double a, double b){
        return a + b;
    }

    public static Double substract(double a, double b){
        return a - b;
    }

    public static Double multiply(double a, double b){
        return a * b;
    }

    public static Double devide(double a, double b){
        return a / b;
    }
}
