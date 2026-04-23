package com.bank;

public interface Account {

	public boolean deposit(double amount);
	
	public boolean withDraw(double amount);
	
	public double getBalance();
}
