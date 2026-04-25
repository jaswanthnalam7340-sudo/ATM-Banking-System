package com.bank;

import java.time.LocalDateTime;
import java.util.List;

public class SavingsAccount extends BaseAccount {

	private int interestPercent = 3;

	public int getInterestPercent() {
		return interestPercent;
	}

	public void setInterestPercent(int interestPercent) {
		if (interestPercent <= 0 || interestPercent > 100) {
			throw new IllegalArgumentException("Please enter proper intrest percent");
		}
		this.interestPercent = interestPercent;
	}
	
	

	@Override
	public boolean withDraw(double amount) {
		if (amount > 0) {
			if (amount > this.amount) {
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

	public double calculateDailyInterest() {
		double balance = getBalance();
		double interest = (balance * getInterestPercent())/365;
		return interest;
	}

	public List<Transaction> getTransactionHistory() {
		return super.getTransactionHistory();
	}
}
