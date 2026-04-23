package com.bank;

import java.time.LocalDateTime;

public class Transaction {

	private double amount;
	private String type;
	private LocalDateTime dateTime;
	private double balanceAfterTransaction;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}
	public void setBalanceAfterTransaction(double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}
	
	public static Transaction createTransactionsDetails(double depOrWithdrawlAmount, String typeoftrans, LocalDateTime datetimetrans, double blanceOfTrans) {
		Transaction transaction = new Transaction();
		transaction.setAmount(depOrWithdrawlAmount);
		transaction.setType(typeoftrans);
		transaction.setDateTime(datetimetrans);
		transaction.setBalanceAfterTransaction(blanceOfTrans);
		return transaction;
	}

}
