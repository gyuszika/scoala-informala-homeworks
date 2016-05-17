package siit.java.homeworks.bankaccounts;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class RunningAccountTest {

	@Test
	public void addFundsCase() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime, 10f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		runningAccount.addFunds(1000);
		assertEquals(960, runningAccount.getBalance(balanceInterogationTime), 0);
	}

	@Test
	public void withdrawalCase() throws InsufficientFundsException {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime, 10f);
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		runningAccount.addFunds(1000);
		runningAccount.withdrawFunds(500);
		assertEquals(460, runningAccount.getBalance(balanceInterogationTime), 0);
	}

}
