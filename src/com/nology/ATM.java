package com.nology;

import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private List<Account> atmUsers = new ArrayList<>();

    public ATM() {

    }


    public List<Account> getAtmUsers() {
        return atmUsers;
    }

    public void addAtmUsers (Account AtmUser) {
        atmUsers.add(AtmUser);
    }

    public void system (Scanner s) {
       // if statement to make sure
        if (getAtmUsers().size() == 0) {
            System.out.println("You will have to add users to the ATM");
        } else {

        System.out.println("Enter password");
        for (Account user: getAtmUsers()) {
            // Get password
            int userPassword = s.nextInt();
            int attempts = 0;
            while (attempts <4 ) {
                if (user.getPassword() != userPassword) {
                    System.out.println("wrong pass " + attempts);
                    attempts++;
                    userPassword =s.nextInt();
                    if(attempts == 4) {
                        System.out.println("you have exceeded no. attempts"); s.close();
                    }
                } else break;
            }
             // when password is correct
            if (user.getPassword() == userPassword) {

                boolean IsAuthenticated = true;
                // to break out of the ATM System
                do {
                    System.out.println("select menu option " + user.getName());

                    // Menu Case 1) check balance 2) withdraw 3) deposit & case 4) exit
                    System.out.println("\n To Check Balance type 1" + "\n To withdraw type 2" + "\n To deposit Type 3" + "\n To exit type 4");
                    int option = s.nextInt();

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
}
