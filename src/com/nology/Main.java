package com.nology;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ATM atm = new ATM();
        atm.addAtmUsers(new Account("Ebrima",2468,1000));
        atm.addAtmUsers(new Account("Andy",2666,2000));


        // creating a scanner to take user input
        Scanner s = new Scanner(System.in);

        atm.system(s);

    }
}
