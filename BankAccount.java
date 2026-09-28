public class BankAccount {

    // Private fields (nobody outside the class can touch them directly)
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor: runs when we create a new account
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;

        // Validation: balance can never start negative
        if (initialBalance < 0) {
            this.balance = 0.0;
            System.out.println("Warning: Initial balance cannot be negative. Balance set to 0.0");
        } else {
            this.balance = initialBalance;
        }
    }

    // ---------- Getters (read one value at a time) ----------
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // ---------- Setter (only the name can be changed) ----------
    // No setter for accountNumber or balance, so they are read-only
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // ---------- Behaviour methods ----------
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Loan is calculated from the current balance
    public double calculateLoan() {
        if (balance < 10000) {
            return balance * 0.10;   // 10%
        } else if (balance <= 60000) {
            return balance * 0.25;   // 25% (10,000 to 60,000)
        } else {
            return balance * 0.30;   // 30% (above 60,000)
        }
    }

    // Show all account details
    public void displayAccountDetails() {
        System.out.println("--------------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : $" + balance);
        System.out.println("Loan Allowed   : $" + calculateLoan());
        System.out.println("--------------------------------");
    }
}