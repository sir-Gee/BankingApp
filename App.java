package bankApp;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Checking> checkingAccounts = new ArrayList<>();
        ArrayList<Savings> savingsAccounts = new ArrayList<>();

        System.out.println("BANKING APPLICATION\n" +
                "-==== M A I N   M E N U ====-");

        System.out.println("1 - Open a checking account.\n2 - Open a savings account.\n" +
                "3 - Search in savings\n4 - Search in checking\n5 - Quit.");
        String option = scanner.nextLine();

        while (!option.equalsIgnoreCase("5")) {
            if (option.equalsIgnoreCase("1")) {
                checkingAccounts.add(new Checking());
            } else if (option.equalsIgnoreCase("2")) {
                savingsAccounts.add(new Savings());
            } else if (option.equalsIgnoreCase("3")) {

                System.out.println("1 - Search by customer's name\n2 - Back to main menu");
                String optionSaveAcc = scanner.nextLine();

                while (!optionSaveAcc.equalsIgnoreCase("2")) {
                    if (optionSaveAcc.equalsIgnoreCase("1")) {
                        System.out.println("Enter the name we are looking for:");
                        String optionName = scanner.nextLine();

                        for (int i = 0; i < savingsAccounts.size(); i++) {
                            if (savingsAccounts.get(i).getFirstName().equalsIgnoreCase(optionName)) {
                                System.out.println("--------\nCustomer found:\nFirst name: " +
                                        savingsAccounts.get(i).getFirstName() + "\nLast name: " +
                                        savingsAccounts.get(i).getLastName() + "\n---------");
                                System.out.println("1 - Deposit\n2 - Withdraw");
                                String optionDepositWithdraw = scanner.nextLine();

                                if (optionDepositWithdraw.equalsIgnoreCase("1")) {
                                    System.out.println("Enter the amount to deposit($) :");
                                    int amount = scanner.nextInt();
                                    scanner.nextLine();
                                    savingsAccounts.get(i).setInitBalance(savingsAccounts.get(i).getInitBalance() + amount);
                                    System.out.println("New balance: $" + savingsAccounts.get(i).getInitBalance());
                                    System.out.println("===========");
                                } else if (optionDepositWithdraw.equalsIgnoreCase("2")) {
                                    System.out.println("Enter the amount to withdraw($) :");
                                    int amount = scanner.nextInt();
                                    scanner.nextLine();

                                    if (savingsAccounts.get(i).getInitBalance() < amount) {

                                        System.out.println("Wrong amount\nYou can withdraw : $" + savingsAccounts.get(i).getInitBalance());
                                    } else {
//                                        savingsAccounts.get(i).setInitBalance(savingsAccounts.get(i).getInitBalance() - amount);
                                        savingsAccounts.get(i).setInitBalance(savingsAccounts.get(i).deposit(amount));
                                        System.out.println("New balance: $" + savingsAccounts.get(i).getInitBalance());
                                        System.out.println("===========");
                                    }
                                }
                            } else if (!savingsAccounts.get(i).getFirstName().equalsIgnoreCase(optionName) && i == savingsAccounts.size()) {
                                System.out.println("Customer not found");
                            }
                        }
                    }
                    System.out.println("--------------\n1 - Search and change balance\n2 - Back to main menu");
                    optionSaveAcc = scanner.nextLine();
                }
            } else if (option.equalsIgnoreCase("4")) {
                for (int i = 0; i < checkingAccounts.size(); i++) {
                    System.out.println("===========");
                    System.out.println("Account number: 19004" + i +
                            "\nFirst name: " + checkingAccounts.get(i).getFirstName() + "\nLast name: " +
                            checkingAccounts.get(i).getLastName() + "\nBalance: $" + checkingAccounts.get(i).getInitBalance());
                    System.out.println("===========");
                }

                System.out.println("B - Back to main menu");
                String optionCheckAcc = scanner.nextLine();
            }

            System.out.println("-==== M A I N   M E N U ====-\n");
            System.out.println("1 - Open a checking account.\n2 - Open a savings account.\n" +
                    "3 - Search in savings\n4 - search in checking\n5 - Quit.");
            option = scanner.nextLine();
        }
        System.out.println("App is closing..");

    }
}
