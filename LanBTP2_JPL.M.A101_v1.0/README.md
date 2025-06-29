# Java.M.A101 - OOP SavingsAccount Example

This project demonstrates basic Object-Oriented Programming (OOP) concepts in Java by implementing a `SavingsAccount` class and a test class `SavingsAccountTest`.

## Structure
- `fa.training.entities.SavingsAccount`: Represents a savings account with static interest rate and balance.
- `fa.training.main.SavingsAccountTest`: Tests the functionality of the `SavingsAccount` class.

## How to Compile and Run
1. Open a terminal in the project root.
2. Compile:
   ```sh
   javac -d . Java.M.A101/src/fa/training/entities/SavingsAccount.java Java.M.A101/src/fa/training/main/SavingsAccountTest.java
   ```
3. Run:
   ```sh
   java fa.training.main.SavingsAccountTest
   ```

## Features
- Set and get annual interest rate (static for all accounts)
- Set and get savings balance
- Calculate and add monthly interest

## Example Output
```
Saver1 balance after 4% interest: $2066.67
Saver2 balance after 4% interest: $3100.00
Saver1 balance after 5% interest: $2152.78
Saver2 balance after 5% interest: $3229.17
```
