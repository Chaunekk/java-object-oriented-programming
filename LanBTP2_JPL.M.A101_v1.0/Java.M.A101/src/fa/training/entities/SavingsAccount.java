package fa.training.entities;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    // Default constructor
    public SavingsAccount() {
        annualInterestRate = 0;
        savingsBalance = 0;
    }

    // Parameterized constructor
    public SavingsAccount(double intRate, double savBal) {
        annualInterestRate = intRate;
        savingsBalance = savBal;
    }

    // Getter and Setter for annualInterestRate
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double intRate) {
        annualInterestRate = intRate;
    }

    // Getter and Setter for savingsBalance
    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savBal) {
        savingsBalance = savBal;
    }

    // Calculate monthly interest
    public void calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;
    }
}
