package com.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public  abstract class BaseAccount implements Account {

	protected double amount;
	protected List<Transaction> transcationRecords = new ArrayList<>();

	@Override
	public boolean deposit(double amount) {
		if(amount>0) {			
			this.amount += amount;
			LocalDateTime current = LocalDateTime.now();
			transcationRecords.add(Transaction.createTransactionsDetails(amount, "Deposit", current, this.amount));
			return true;
		} else {
			System.out.println("Invalid Deposit amount.");
			return false;
		}
	}

	@Override
	public abstract boolean withDraw(double amount);

	@Override
	public double getBalance() {
		return this.amount;
	}

	public List<Transaction> getTransactionHistory() {
		return this.transcationRecords;
	}
}
