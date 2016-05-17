package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class SavingsAccountTest {

	@Test
	public void addFundsCase() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 10f, 0.002f, 0.06f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		savingsAccount.addFunds(1000);
		assertEquals(960, savingsAccount.getBalance(balanceInterogationTime), 0);
	}
	
	@Test
	public void withdrawalCase() throws InsufficientFundsException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 10f, 0.002f, 0.06f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		savingsAccount.addFunds(1000);
		savingsAccount.withdrawFunds(500);
		assertEquals(459, savingsAccount.getBalance(balanceInterogationTime), 0);
	}
	
	@Test
	public void interestPerYearCase(){
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		SavingsAccount savingsAccount = new SavingsAccount(accountCreationTime, 10f, 0.002f, 0.06f);
		savingsAccount.addFunds(10000);
		Date balanceInterogationTime = TestUtils.getDate(2017, 5, 1);
		assertEquals(10430.4f, savingsAccount.calculateInterest(balanceInterogationTime), 0);
	}
}
