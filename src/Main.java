import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactionList =  new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Please give the number of transactions you would like to calculate: ");

        int numTransactions = sc.nextInt();

        int currentTransaction = 1;
        while (currentTransaction <= numTransactions) {
            System.out.print("Please give the merchant code for transaction "
                    + currentTransaction + ": ");
            String merchantCode = sc.next();
            System.out.print("Please give the amount in cents for transaction "
                    + currentTransaction + ": ");
            int cents = sc.nextInt();
            Transaction t = new Transaction(merchantCode, cents);
            transactionList.add(t);
            currentTransaction++;
        }

        PointRewards pointRewards = new PointRewards();

        System.out.println("The maximum number of points for the month is: "
                + pointRewards.getMaxPoints(transactionList));
    }
}