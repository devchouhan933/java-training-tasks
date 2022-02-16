package com.company.day3.homework;

public class Account {
    private static int numAccounts = 0;
    private final String name;
    private final long acctNum;
    private double balance;


    //----------------------------------------------
    //Constructor -- initializes balance and owner; generates random
    //account number
    //----------------------------------------------
    public Account(double initBal, String owner) {
        numAccounts++;
        balance = initBal;
        name = owner;
        acctNum = (int) (Math.random() * Integer.MAX_VALUE);
    }

    //----------------------------------------------
    //Constructor -- initializes owner as given and balance to 0.
    //Generates random account number
    //----------------------------------------------
    public Account(String owner) {
        numAccounts++;
        balance = 0;
        name = owner;
        acctNum = (int) (Math.random() * Integer.MAX_VALUE);
    }

    // account cosolidate
    public static Account consolidate(Account account1, Account account2) {
        if (account1.name == account2.name && account1.getAcctNumber() != account2.getAcctNumber()) {
            double bal = account1.getBalance() + account2.getBalance();
            account1.close();
            account2.close();
            numAccounts = numAccounts - 2;
            return new Account(bal, account1.name);
        }
        return null;
    }

    //Returns total number of accounts
    public static int getNumAccounts() {
        return numAccounts;
    }

    //close the account
    public void close() {
        this.balance = 0;
        numAccounts--;
        System.out.println(this.name + " CLOSED");
    }


    //----------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    //----------------------------------------------
    public void withdraw(double amount) {
        if (balance >= amount) balance -= amount;
        else System.out.println("Insufficient funds");

    }

    //----------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    // Also deducts fee from account.
    //----------------------------------------------
    public void withdraw(double amount, double fee) {

        if (balance >= amount) {
            balance -= amount;
            balance -= fee;
        } else System.out.println("Insufficient funds");

    }

    //----------------------------------------------
    // Adds deposit amount to balance.
    //----------------------------------------------
    public void deposit(double amount) {
        balance += amount;
    }

    //----------------------------------------------
    // Returns balance.
    //----------------------------------------------
    public double getBalance() {
        return balance;
    }


    //----------------------------------------------
    // Returns account number
    //----------------------------------------------
    public double getAcctNumber() {
        return acctNum;
    }


    //----------------------------------------------
    // Returns a string containing the name, acct number, and balance.
    //----------------------------------------------
    public String toString() {
        return "Name: " + name + "\nAcct #: " + acctNum + "\nBalance: " + balance;
    }
}