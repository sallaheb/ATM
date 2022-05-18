package com.nology;

public class Account {
    private String name;
    private int password;
    private double balance;

    public Account(String name, int password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        balance +=amount;
        return balance;
    }

    public double withdraw(double amount) {
        if(amount>balance) {
            throw new IllegalArgumentException("The amount is greater balance and you do not have enough money");
        }
        balance -=amount;
        return balance;
    }

}
