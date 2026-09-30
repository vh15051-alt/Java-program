import java.util.Scanner;

// Abstract class
abstract class BankAccount {
    int accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    void displayBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    abstract void withdraw(double amount);
    abstract double calculateInterest();
}

// Loan Service Interface
interface LoanService {
    void processLoan(double amount);
}

// Savings Account
class SavingsAccount extends BankAccount implements LoanService {
    double interestRate = 5.0;

    SavingsAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    double calculateInterest() {
        return balance * interestRate / 100;
    }

    @Override
    public void processLoan(double amount) {
        System.out.println("Savings Account Loan Processing");
        System.out.println("Loan Amount: Rs." + amount);
        System.out.println("Loan processed successfully.");
    }
}

// Current Account
class CurrentAccount extends BankAccount implements LoanService {
    double interestRate = 3.0;
    double overdraftLimit = 5000.0;

    CurrentAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    double calculateInterest() {
        return balance * interestRate / 100;
    }

    @Override
    public void processLoan(double amount) {
        System.out.println("Current Account Loan Processing");
        System.out.println("Loan Amount: Rs." + amount);
        System.out.println("Loan processed successfully.");
    }
}

// Main class
public class BankingApplication {
    public static void main(String[] args) {

        SavingsAccount savings =
            new SavingsAccount(101, "Aishwarya", 10000);

        CurrentAccount current =
            new CurrentAccount(102, "Rahul", 15000);

        System.out.println("===== SAVINGS ACCOUNT =====");
        System.out.println("Account Number: " + savings.accountNumber);
        System.out.println("Account Holder: " + savings.accountHolderName);

        savings.displayBalance();
        savings.deposit(2000);
        savings.displayBalance();
        savings.withdraw(3000);
        savings.displayBalance();

        double savingsInterest = savings.calculateInterest();
        System.out.println("Savings Interest: Rs." + savingsInterest);

        savings.processLoan(50000);

        System.out.println("\n===== CURRENT ACCOUNT =====");
        System.out.println("Account Number: " + current.accountNumber);
        System.out.println("Account Holder: " + current.accountHolderName);

        current.displayBalance();
        current.deposit(5000);
        current.displayBalance();
        current.withdraw(18000);
        current.displayBalance();

        double currentInterest = current.calculateInterest();
        System.out.println("Current Account Interest: Rs." + currentInterest);

        current.processLoan(100000);
    }
}