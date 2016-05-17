package siit.java.homeworks.bankaccounts;

import java.util.Calendar;
import java.util.Date;

public class SavingsAccount extends BankAccount {
	private float commission;
	private float interest;

	public SavingsAccount(Date accountCreationDate, float monthlyFee, float commission, float interest) {
		super(accountCreationDate, monthlyFee);
		this.commission = commission;
		this.interest = interest;
	}

	public void withdrawFunds(float amount) throws InsufficientFundsException {
		super.withdrawFunds(amount + (amount * commission));
	}

	public void addFunds(float amount) {
		super.addFunds(amount);
	}

	public float calculateInterest(Date balanceDate){
		
		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(getAccountCreationDate());
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(balanceDate);
		int yearDiff = (balanceTime.get(Calendar.YEAR) - accountCreationTime.get(Calendar.YEAR));
		
		balance = getBalance(balanceDate) + (getBalance(balanceDate) *(interest * yearDiff));
		return balance;
	}
	
}
