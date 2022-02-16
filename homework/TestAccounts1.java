package com.company.day3.homework;// TestAccounts1
// A simple program to test the numAccts method of the
// Account class.
//************************************************************
import java.util.Scanner;
public class TestAccounts1
{
	public static void main(String[] args)
	{
		Account testAcct = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("How many accounts would you like to create?"); int num =
				scan.nextInt();
		for (int i=1; i<=num; i++)
		{
			testAcct = new Account(100, "Name" + i);
			System.out.println("\nCreated account " + testAcct);
			// Your code here: call method to print out how many accounts have been created so far
		}
		System.out.println();
		Account account = new Account(100.0 , "Name-new 3");
		Account account2 = new Account(100.0 , "Name-new 3");
		System.out.println(Account.consolidate(account,account2));;
		System.out.println("------total Accounts----"+	Account.getNumAccounts());

	}
}