import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM() {
        userAccount = new BankAccount(1000); // Set an initial balance of 1000 for testing purposes
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public void withdraw(int amount) {
        if (userAccount.getBalance() >= amount) {
            userAccount.withdraw(amount);
            System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public void deposit(int amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Current balance: " + userAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Your account balance: " + userAccount.getBalance());
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
