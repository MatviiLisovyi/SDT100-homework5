package Part2;

import java.util.Scanner;

public class Part2AutomaticStockTrader {
    private final static Double TRANSACTION_FEE = 10.0;
    private static final Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {
        boolean keepRunning = false;

        printWelcome();
        do {
            System.out.println("Insert current_shares:");
            int current_shares = scanner.nextInt();
            System.out.println("Insert purchase_price:");
            double purchase_price = scanner.nextInt();
            System.out.println("Insert market_price:");
            double market_price = scanner.nextInt();
            System.out.println("Insert available_funds:");
            double available_funds = scanner.nextInt();

            System.out.println(decideTransaction(current_shares, purchase_price, market_price, available_funds));
            ;

            keepRunning =  askToContinue();
        } while (keepRunning);


    }

    private static String decideTransaction(int current_shares, double purchase_price, double market_price, double available_funds){

        if (purchase_price > market_price){
            if (decideBuy(current_shares, purchase_price, market_price, available_funds) > 0){
                return "Buy shares:" + decideBuy(current_shares, purchase_price, market_price, available_funds);
            }

        } else if (purchase_price < market_price) {
            return decideSell(current_shares, purchase_price, market_price, available_funds);
        }
//        else if (purchase_price == market_price){
//            return "Hold shares";
//        }
        return "Hold shares";
    }

    private static String decideSell(int current_shares, double purchase_price, double market_price, double available_funds){

        if (current_shares * market_price - TRANSACTION_FEE > purchase_price){
            return "Sell " + current_shares + " shares";
        } else {
            return "Hold shares";
        }
    }
    private static int decideBuy(int current_shares, double purchase_price, double market_price, double available_funds){
        double fundsAfterFee = available_funds - TRANSACTION_FEE;
        if ( fundsAfterFee <= 0){
            return 0;
        }else{
            return(int) (fundsAfterFee/market_price);
        }

    }


    private static boolean askToContinue() {
        while (true) {
            System.out.print("Continue or not? (y - continue, q - quit): ");
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

    private static void printWelcome() {
        System.out.println("------------ Automatic Stock Trader ------------");
        System.out.printf("Every transaction costs $%.2f%n", TRANSACTION_FEE);
        System.out.println("------------------------------------------------");
    }
}
