package siit.java.homeworks.bankaccounts;

import java.util.Calendar;
import java.util.Date;

/**
 * This is the parent class, which allows the created of any account with a
 * balance, creation date and monthly fees.
 * 
 * @author Gyuszika
 *
 */
public abstract class BankAccount {

	protected float balance;
	private Date accountCreationDate;
	private float monthlyFee;

	/**
	 * The method sets the date and monthly fee for the account.
	 * 
	 * @param accountCreationDate
	 *            holds date of the account creation
	 * @param monthlyFee
	 *            holds value of the monthly fee
	 */
	public BankAccount(Date accountCreationDate, float monthlyFee) {
		super();
		this.accountCreationDate = accountCreationDate;
		this.monthlyFee = monthlyFee;
	}

	/**
	 * Following method adds funds to the account.
	 * 
	 * @param amount
	 *            holds value of the amount to be added to balance
	 */
	public void addFunds(float amount) {
		balance += amount;
	}

	/**
	 * This method withdraws amount form the balance.
	 * 
	 * @param amount
	 *            hold value for withdrawal amount
	 * @throws InsufficientFundsException
	 *             throws exception if withdraw amount is greater than balance
	 */
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException();
		}
		balance -= amount;
	}

	/**
	 * This method returns balance from account at a given date.
	 * 
	 * @param balanceDate
	 *            hold value of the required date
	 * @return returns value with monthly fees applied
	 */
	public float getBalance(Date balanceDate) {
		return getBalanceWithMonthlyFeesApplied(balanceDate);
	}

	/**
	 * Following methiod calculates monthly fees for a given period and returns
	 * balance minus fees.
	 * 
	 * @param balanceDate
	 *            holds value for the desired date, it's required to calculated
	 *            period
	 * @return returns balance minus fees
	 */
	private float getBalanceWithMonthlyFeesApplied(Date balanceDate) {
		// We assume that the account dates are always from the same year to not
		// overcomplicate the number of months
		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(accountCreationDate);
		// JANUARY is 0
		int accountCreationMonth = accountCreationTime.get(Calendar.MONTH);
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(balanceDate);
		int currentMonth = balanceTime.get(Calendar.MONTH);
		int passedYears = balanceTime.get(Calendar.YEAR) - accountCreationTime.get(Calendar.YEAR);
		return balance - monthlyFee * (currentMonth - accountCreationMonth + passedYears * 12);
	}

	public Date getAccountCreationDate() {
		return accountCreationDate;
	}

}
