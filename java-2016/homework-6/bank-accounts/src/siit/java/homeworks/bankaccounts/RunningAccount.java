package siit.java.homeworks.bankaccounts;

import java.util.Date;

public class RunningAccount extends BankAccount {

	public RunningAccount(Date accountCreationDate, float monthlyFee) {
		super(accountCreationDate, monthlyFee);
	}

	public void withdrawFunds(float amount) throws InsufficientFundsException {
		super.withdrawFunds(amount);
	}

	public void addFunds(float amount) {
		super.addFunds(amount);
	}
}
