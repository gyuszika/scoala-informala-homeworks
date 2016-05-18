package siit.java.homeworks.bankaccounts;

import java.util.Calendar;
import java.util.Date;

/**
 * This SavingAccount class extends BankAccount.
 * <p>
 * <b>The class is a simple savings account where founds can be added and
 * withdrawn.</b>
 * <p>
 * The account has a monthly fee and also adds an interest to balance once a year.
 * @author Gyuszika
 */
public class SavingsAccount extends BankAccount {
	private float commission;
	private float interest;

	/**
	 * The method created a saving account by inheriting methods from parent
	 * class plus it has a commission fee for withdrawals and interest/year.
	 * 
	 * @param accountCreationDate
	 *            holds date of the account creation
	 * @param monthlyFee
	 *            holds value of the monthly fee
	 * @param commission
	 *            holds value for withdrawal commission
	 * @param interest
	 *            holds value for interest/year
	 */
	public SavingsAccount(Date accountCreationDate, float monthlyFee, float commission, float interest) {
		super(accountCreationDate, monthlyFee);
		this.commission = commission;
		this.interest = interest;
	}

	/**
	 * This method withdraws amount form the balance with the declared
	 * commission.
	 */
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		super.withdrawFunds(amount + (amount * commission));
	}

	/**
	 * This method adds funds to the account.
	 */
	public void addFunds(float amount) {
		super.addFunds(amount);
	}

	/**
	 * Method calculates balance with interest included for a given period(1
	 * year is the minimum).
	 * 
	 * @param balanceDate
	 *            holds value for the desired period
	 * @return returns balance with interest included
	 */
	public float calculateInterest(Date balanceDate) {

		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(getAccountCreationDate());
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(balanceDate);
		int yearDiff = (balanceTime.get(Calendar.YEAR) - accountCreationTime.get(Calendar.YEAR));

		balance = getBalance(balanceDate) + (getBalance(balanceDate) * (interest * yearDiff));
		return balance;
	}

}
