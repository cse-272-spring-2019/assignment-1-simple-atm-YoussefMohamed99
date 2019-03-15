package assignment1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author YOUSSEF
 */
public class Transactions {

    static double balance = 0;
    static String history[] = new String[500];
    static int counter = -1;
    //int i;

    void historyUpdate(int category, double amount) { //category: Balance Inquiry=0, Deposit=1, Withdrawal=2.

        /*for (i = 0; i < 5; i++) {

            history[i] = "0";
        }*/

        switch (category) {
            case 0:
                history[counter] = String.format("Balance Inquiry $" + amount); //Balance Inquiry
                break;
            case 1:
                history[counter] = String.format("Deposit $" + amount); //Deposit
                break;
            case 2:
                history[counter] = String.format("Withdrawal $" + amount); //Withdrawal
                break;
            default:
                break;
        }
    }

    boolean withdraw(double amount) {
        boolean valid = false;
        if (balance >= amount) {
            balance -= amount;
            valid = true;
        } else {

            valid = false;
        }
        return valid;
    }

    double balanceInquiry() {
        return balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

}
