package siit.java.homeworks.bankaccounts;

import java.util.Date;

public class LoanAccount extends BankAccount {

	private float interestPerLoan;
	private int installments;
	private float deadlinePenalty;
	private float loan;

	public LoanAccount(Date accountCreationDate, float monthlyFee, float interestPerLoan, int installments, float loan,
			float deadlinePenalty) {

		super(accountCreationDate, 0);
		this.interestPerLoan = interestPerLoan;
		this.installments = installments;
		this.loan = loan;
		balance = loan;
		this.deadlinePenalty = deadlinePenalty;
	}

	public void addFunds(float amount) {
		super.addFunds(amount + (amount * interestPerLoan));
	}

	public float monthlyPayment(){
		return (loan/installments)* interestPerLoan;
	}

	@Override
	public float getBalance(Date balanceDate) {
		// Ideally we should calculate the credit penalty for each and every
		// month, but for the sake of simplicity we will only compute it once.
		float balance = super.getBalance(balanceDate);
		return applyDeadlinePenalties(balance);
	}

	private float applyDeadlinePenalties(float balance) {
		if (loan <= balance) {
			return balance;
		} else {
			return balance - (loan - balance) * deadlinePenalty;
		}
	}

	@Deprecated
	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		throw new UnsupportedOperationException();
	}

}
