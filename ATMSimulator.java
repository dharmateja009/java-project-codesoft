import java.util.Scanner;
class bankAcc {
    private double balance;
    public bankAcc(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBal() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew ₹" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}
class ATM {
    private bankAcc account;
    private Scanner scanner;
    public ATM(bankAcc account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println("\n ATM MENU ");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");  
            int choice = scanner.nextInt(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Your balance: ₹" + account.getBal());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
public class ATMSimulator {
    public static void main(String[] args) {
        bankAcc userAccount = new bankAcc(5000);  
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
