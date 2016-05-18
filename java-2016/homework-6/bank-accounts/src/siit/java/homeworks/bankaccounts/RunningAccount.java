package siit.java.homeworks.bankaccounts;

import java.util.Date;

/**
 * This SavingAccount class extends BankAccount.
 * <p>
 * <b>The class is a simple savings account where founds can be added and
 * withdrawn.</b>
 * 
 * @author Gyuszika
 *
 */
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
