package codesoft;


    import java.util.Scanner;


    class BankAccount {
        private double balance;


        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }


        public double getBalance() {
            return balance;
        }


        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited: $" + amount);
            } else {
                System.out.println("Deposit amount must be positive!");
            }
        }


        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew: $" + amount);
                return true;
            } else if (amount > balance) {
                System.out.println("Insufficient balance for this transaction.");
                return false;
            } else {
                System.out.println("Withdrawal amount must be positive!");
                return false;
            }
        }
    }


    class ATM {
        private BankAccount account;
        private Scanner scanner;


        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }


        public void showMenu() {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }


        public void start() {
            boolean running = true;

            while (running) {
                showMenu();
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }


        private void checkBalance() {
            System.out.println("Your current balance is: $" + account.getBalance());
        }


        private void deposit() {
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }


        private void withdraw() {
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
    }


    public class ATMSystem {
        public static void main(String[] args) {

            BankAccount userAccount = new BankAccount(1000.00); // Initial balance: $1000


            ATM atm = new ATM(userAccount);


            atm.start();
        }
    }


