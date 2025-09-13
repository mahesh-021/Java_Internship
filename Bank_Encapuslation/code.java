class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String name, double initialBalance) {
        accountHolder = name;
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if(amount>0) {
            balance+=amount;
        }
    }

    public void withdraw(double amount) {
        if(amount>0 && amount<=balance) {
            balance -= amount;
        }
    }
    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class code {
    public static void main(String[] args) {
        BankAccount b = new BankAccount("mahesh", 1000.0);
        b.deposit(200);
        b.withdraw(500);
        System.out.println(b.getAccountHolder()+" "+b.getBalance());
    }
}