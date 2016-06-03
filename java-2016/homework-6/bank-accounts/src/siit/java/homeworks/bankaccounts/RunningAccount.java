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

	// TODO CODE REVIEW: you don't need to override methods in children classes if there is no added behavior. All visible methods from parents are inherited by default.
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		super.withdrawFunds(amount);
	}

	public void addFunds(float amount) {
		super.addFunds(amount);
	}
}
