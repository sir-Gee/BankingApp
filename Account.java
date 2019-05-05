package bankApp;

import java.util.Scanner;

public abstract class Account {
    Scanner scanner = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private int initBalance;
    static int uniqueID = 1000;

    public Account() {
        System.out.println("Enter first name:");
        this.firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        this.lastName = scanner.nextLine();

        System.out.println("Enter the initial balance:");
        this.initBalance = scanner.nextInt();

        System.out.println(getClass().getSimpleName() + " has been created\n" + "Account number: " + accountNumber() +
                "\nFirst Name: " + this.firstName +
                "\nLast Name: " + this.lastName + "\nBalance: $" + this.initBalance + "\n--------------------");

        uniqueID++;
    }

    public int deposit(int amount) {
       return initBalance += amount;
    }

    public void withdraw(int amount) {
        initBalance -= amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getInitBalance() {
        return initBalance;
    }

    public void setInitBalance(int initBalance) {
        this.initBalance = initBalance;
    }

    private String accountNumber() {
        return String.valueOf((int) (Math.random() * 999 + 1) + "" + uniqueID);
    }
}
