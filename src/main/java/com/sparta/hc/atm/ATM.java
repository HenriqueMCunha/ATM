package com.sparta.hc.atm;

import java.util.Scanner;

public class ATM {
    //Move all these perhaps into balance and then have ATM with main method
    private static int note50;
    private static int note20;
    private static int note10;
    private static int note5;
    private static int note2;
    private static int note1;

    //Constructor
    public ATM(int note50, int note20, int note10, int note5, int note2, int note1) {
        this.note50 = note50;
        this.note20 = note20;
        this.note10 = note10;
        this.note5 = note5;
        this.note2 = note2;
        this.note1 = note1;
    }

    //Getters and Setters
    public static int getNote50() {
        return note50;
    }

    public int setNote50(int note50){
        this.note50 = note50;
        return note50;
    }

    public static int getNote20() {
        return note20;
    }

    public void setNote20 ( int note20){
        this.note20 = note20;
    }

    public static int getNote10() {
        return note10;
    }

    public void setNote10 ( int note10){
        this.note10 = note10;
    }

    public static int getNote5() {
        return note5;
    }

    public void setNote5 ( int note5){
        this.note5 = note5;
    }

    public static int getNote2() {
        return note2;
    }

    public void setNote2 ( int note2){
        this.note2 = note2;
    }

    public static int getNote1() {
        return note1;
    }

    public void setNote1 ( int note1){
        this.note1 = note1;
    }

    //Move into another class Balance
    //Method to calculate total balance
    public static int calculateTotalBalance() {
        int totalBalance = note1 + (note2 * 2) + (note5 * 5) + (note10 * 10) + (note20 * 20)  + (note50 * 50);
        return totalBalance;
    }

    //Move into another class called Transactions
    //Method to withdraw money followed by method to display balance
    public static void withdrawCash(int amount) {
        int totalBalance = calculateTotalBalance();
        while (amount != 0) {
            if (amount > totalBalance) {
                System.out.println("This ATM does not have enough to satisfy your needs.");
                System.out.println("Currently this ATM only has " + totalBalance + " available.");
                break;
            } else if (amount - 50 >= 0 && note50 > 0) {
                note50 = getNote50() - 1;
                amount -= 50;
            } else if (amount - 20 >= 0 && note20 >0) {
                note20 = getNote20() - 1;
                amount -= 20;
            } else if (amount - 10 >= 0 && note10 > 0) {
                note10 = getNote10() - 1;
                amount -= 10;
            } else if (amount - 5 >= 0 && note5 > 0) {
                note5 = getNote5() - 1;
                amount -= 5;
            } else if (amount - 2 >= 0 && note2 > 0) {
                note2 = getNote2() - 1;
                amount -= 2;
            } else if (amount - 1 >= 0 && note1 > 0) {
                note1 = getNote1() - 1;
                amount -= 1;
            } else {
                break;
            }
        } displayBalance();
    }
    //Move into another class balance operations
    //Method to display balance
    public static void displayBalance() {
        System.out.println("Balance: " + calculateTotalBalance());
        System.out.println("Value | Quantity of Units");
        System.out.println("50    | " + getNote50());
        System.out.println("20    | " + getNote20());
        System.out.println("10    | " + getNote10());
        System.out.println("5     | " + getNote5());
        System.out.println("2     | " + getNote2());
        System.out.println("1     | " + getNote1());
    }

    //This will stay in this class
    //ATM menu - method can be improved by using switch instead of if/else; include options to display balance, withdraw money and exit
    public static void displayMenu() {
        Scanner input = new Scanner((System.in));
        while (true) {
            System.out.println("Welcome to our Tech242 ATM!");
            displayBalance();
            System.out.println("Please enter how much you would like to withdraw: ");
            int amount = input.nextInt();
            if (amount == 0) {
                System.out.println("Thank you for using our Tech242 ATM. Have a good day!");
                break;
            } else {
                withdrawCash(amount);
            }
        }
    }


}