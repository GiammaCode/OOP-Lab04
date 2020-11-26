package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {
	
	private static final double TRANSACTION_FEE = 0.1;
	private int nTransactions;
	private double balance;
	
	public ExtendedStrictBankAccount(int usrID, double balance) {
		super(usrID, balance);
		this.nTransactions = 0;
	}
	
	
	    public void computeManagementFees(final int usrID) {
	        final double feeAmount = MANAGEMENT_FEE + (nTransactions * TRANSACTION_FEE);
	        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
	            balance -= feeAmount;
	            nTransactions = 0;
	        }
	    }

	  
	    private boolean isWithdrawAllowed(final double amount) {
	        return balance > amount;
	    }

	    private void transactionOp(final int usrID, final double amount) {
	        if (checkUser(usrID)) {
	            this.balance += amount;
	            this.incTransactions();
	        }
	    }

	    public void withdraw(final int usrID, final double amount) {
	        if (isWithdrawAllowed(amount)) {
	            this.transactionOp(usrID, -amount);
	        }
	    }

	    public void withdrawFromATM(final int usrID, final double amount) {
	        this.withdraw(usrID, amount + ATM_TRANSACTION_FEE);
	    }
	
	
	
}
