package fa.training.main;

import fa.training.entities.SavingsAccount;

public class SavingsAccountTest {
    public static void main(String[] args) {
        //Instantiate two SavingsAccount objects
        SavingsAccount saver1 = new SavingsAccount(0.04, 2000.00);
        SavingsAccount saver2 = new SavingsAccount(0.04, 3000.00);
        
        //Set annualInterestRate to 4%
        SavingsAccount.setAnnualInterestRate(0.04);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("Saver1 balance after 4%% interest: $%.2f\n", saver1.getSavingsBalance());
        System.out.printf("Saver2 balance after 4%% interest: $%.2f\n", saver2.getSavingsBalance());

        //Set annualInterestRate to 5%
        SavingsAccount.setAnnualInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("Saver1 balance after 5%% interest: $%.2f\n", saver1.getSavingsBalance());
        System.out.printf("Saver2 balance after 5%% interest: $%.2f\n", saver2.getSavingsBalance());
    }
}
