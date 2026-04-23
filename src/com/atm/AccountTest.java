package com.atm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bank.Account;
import com.bank.BaseAccount;
import com.bank.CurrentAccount;
import com.bank.SavingsAccount;

public class AccountTest {

	@Test
	void testValidDeposit() {
		Account s = new SavingsAccount();
		boolean status = s.deposit(2000);

		assertTrue(status);
		Assertions.assertEquals(2000, s.getBalance());
	}

	@Test
	void testInvalidDeposit() {
		Account s = new SavingsAccount();
		double currentBalance = s.getBalance();
		boolean invalidStatus = s.deposit(-500);
		assertFalse(invalidStatus);
		Assertions.assertEquals(currentBalance, s.getBalance());
	}

	@Test
	void savingAccountWithBalance() {
		Account s = new SavingsAccount();
		boolean status = s.deposit(20000);
		assertTrue(status);
		status = s.withDraw(3490);
		assertTrue(status);
		Assertions.assertEquals(16510, s.getBalance());
	}

	@Test
	void savingAccountExceedingBalance() {
		Account s = new SavingsAccount();
		boolean status = s.deposit(20000);
		assertTrue(status);
		status = s.withDraw(200000);
		assertFalse(status);
		Assertions.assertEquals(20000, s.getBalance());
	}

	@Test
	void currentAccountWithdrawWithinOverdraft() {
		Account curtacc = new CurrentAccount(2000);
		boolean status = curtacc.withDraw(200);
		assertTrue(status);
		Assertions.assertEquals(-200, curtacc.getBalance());
	}

	@Test
	void currentAccountWithdrawExceedingOverdraft() {
		Account curtacc = new CurrentAccount(2000);
		boolean status = curtacc.withDraw(20000);
		assertFalse(status);
		Assertions.assertEquals(0, curtacc.getBalance());
	}
	
	@Test
	void validateTranscationsInsertion() {
		SavingsAccount savetransaticon = new SavingsAccount();
		boolean status = savetransaticon.deposit(20000);
		assertTrue(status);
		status = savetransaticon.withDraw(300);
		assertTrue(status);
		status = savetransaticon.deposit(20);
		assertTrue(status);
		Assertions.assertEquals(3, savetransaticon.getTransactionHistory().size());
	}
}
