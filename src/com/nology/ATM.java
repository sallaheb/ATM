package com.nology;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {


    public ATM() {


        // creating a user account for the ATM
        Account atmUser = new Account("Ebrima",2468,1000);
        Account atmUser2 = new Account("Naib",2668,1000);

        List<Account> ListOfUsers = new ArrayList<>();
        ListOfUsers.add(atmUser);
        ListOfUsers.add(atmUser2);

        // creating a scanner to take user input
        Scanner s = new Scanner(System.in);
        System.out.println("Enter password");

        // Get password
        int userPassword = s.nextInt();

        // Check whether password matches atm user
        for (Account user: ListOfUsers) {


            while (user.getPassword() == userPassword) {

                boolean IsAuthenticated = true;

                do {
                    System.out.println("select menu option " + user.getName());

                    // Menu Case 1) check balance 2) withdraw 3) deposit & case 4) exit
                    System.out.println("\n To Check Balance type 1" + "\n To withdraw type 2" + "\n To deposit Type 3" + "\n To exit type 4");
                    int option = s.nextInt();

                    // Case 4 need a way to break out of the loop : maybe do Loop  boolean systemIsRunning = false;

                    switch (option) {
                        case 1:
                            System.out.println(user.getName() + " " + user.getBalance());
                            break;
                        case 2:
                            // Take user amount
                            System.out.println("Enter withdraw amount");
                            double amountToWithdraw = s.nextInt();
                            System.out.println(" ");

                            // Withdraw the money and check balance
                            System.out.println(user.getName() + " " + user.withdraw(amountToWithdraw) +
                                    " \n Remaining Balance is: " + user.getBalance());
                            break;
                        case 3:
                            // Take user amount
                            System.out.println("Enter Deposit amount");
                            double amountToDeposit = s.nextInt();
                            System.out.println(" ");

                            // Deposit the money and check balance
                            System.out.println(user.getName() + " " + user.deposit(amountToDeposit)+
                                    " \n Remaining Balance is: " + user.getBalance());
                            break;
                        case 4:
                            IsAuthenticated = false;

                    }

                } while (IsAuthenticated);


             break;
            }
         }





    }
}
