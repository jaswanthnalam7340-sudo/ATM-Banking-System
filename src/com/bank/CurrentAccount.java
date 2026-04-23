package com.bank;

import java.time.LocalDateTime;

public class CurrentAccount extends BaseAccount{
	
	private double overdraftLimit;
	
	public CurrentAccount(double overdraftamount) {
		this.overdraftLimit = overdraftamount;
	}
	
	@Override
	public boolean withDraw(double amount) {
		if (amount > 0) {
			if (amount > this.amount + overdraftLimit) {
				System.out.println("Insufficent Balance.");
				return false;
			} else {
				this.amount -= amount;
				LocalDateTime current = LocalDateTime.now();
				transcationRecords.add(Transaction.createTransactionsDetails(amount, "WithDraw", current, this.amount));
				return true;
			}
		} else {
			System.out.println("Invalid withdraw amount.");
			return false;
		}
	}
}
