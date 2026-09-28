public class BankAccount {

    
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;

        
        if (initialBalance < 0) {
            this.balance = 0.0;
            System.out.println("Warning: Initial balance cannot be negative. Balance set to 0.0");
        } else {
            this.balance = initialBalance;
        }
    }

    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    
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

    
    public double calculateLoan() {
        if (balance < 10000) {
            return balance * 0.10;
        } else if (balance <= 60000) {
            return balance * 0.25;   
        } else {
            return balance * 0.30;   
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