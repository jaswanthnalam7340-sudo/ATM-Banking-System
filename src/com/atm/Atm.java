package com.atm;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bank.Account;
import com.bank.CurrentAccount;
import com.bank.SavingsAccount;

public class Atm {

	void process(Account type, int Option, double amount) {
		boolean status = false;
		switch (Option) {
		case 1:
			status = type.withDraw(amount);
			if (status) {
				System.out.println("Withdraw is successful");
				System.out.println("Remaining balance is :" + type.getBalance());
			} else {
				System.out.println("Withdraw Failed");
			}
			break;
		case 2:
			status = type.deposit(amount);
			if (status) {
				System.out.println("Deposit is successful");
				System.out.println("After deposit balance is :" + type.getBalance());
			} else {
				System.out.println("Deposit Failed");
			}
			break;
		case 3:
			System.out.println("Balance in the account is :" + type.getBalance());
			break;
		default:
			System.out.println("Please select the proper option");
		}
	}

	public static void main(String[] args) {
		int accounttype = 0;
		int typeof = 0;
		double amount = 0;
		Account type;
		Atm atm = new Atm();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select Account Type:\n1.Savings\n2.Current");
		accounttype = scanner.nextInt();

		if (accounttype == 1) {
			type = new SavingsAccount();
		} else if (accounttype == 2) {
			type = new CurrentAccount(2000);
		} else {
			System.out.println("Invalid account type");
			return;
		}

		while (true) {
			try {
				System.out.println("Please enter\n1.Withdraw\n2.Deposit\n3.Display Balance\n4.Exit");
				typeof = scanner.nextInt();
				if (typeof > 4 || typeof < 1) {
					throw new IllegalArgumentException("Invalid Option. Please select Correct option");
				}
				if (typeof == 1 || typeof == 2) {
					System.out.println("Please enter the amount");
					try {
						amount = scanner.nextDouble();
					} catch (InputMismatchException e) {
						System.out.println("Invalid input: Please enter a numeric value for amount.");
						return; // stop execution safely
					}
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return;
			}
			if (typeof == 4) {
				break;
			}
			atm.process(type, typeof, amount);
		}
	}
}
