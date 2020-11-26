package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;
import it.unibo.oop.lab04.bank.SimpleBankAccount;

/*public abstract class AbstractBankAccount implements BankAccount {
	
	public static final double ATM_TRANSACTION_FEE = 1;
	public static final double MANAGEMENT_FEE = 5;
	
    private final int usrID;
	private double balance;
	private int nTransactions;
	
	protected AbstractBankAccount(final int usrID, double balance) {
		this.usrID = usrID;
		this.balance = balance;
		this.nTransactions = 0;
	}
	
	//getter
	public int getUsrID() {
		return this.usrID;
	}
	
	public final double getBalance() {
		return this.balance;
	}
	
	public final  int getNTransaction() {
		return this.nTransactions;
	}
	
	 protected final void setBalance(final double amount) {
	        this.balance = amount;
	 }
	 
	//utility
	protected boolean checkUser(final int usr) {
		 return (this.usrID == usr);
	}
	
	protected final void incNTransactions() {
		this.nTransactions ++;
	}
	
	private void operation(final int usrID, final double amount) {
		if(checkUser(usrID)) {
			this.incNTransactions();
			this.balance += amount;
		}
	}
	
	//abstract method
	protected abstract boolean isWithDrawAllowed(double amount);
		
	protected abstract double computeFee();
		
	//public method 
	public void computeManagementFees(int usrID) {
		final double fee = computeFee();
		if (checkUser(usrID) && isWithDrawAllowed(fee)) {
            balance -= fee;
            nTransactions = 0;
        }
	 }
	
	public void deposit(final int usrID, double amount) {
		this.operation(usrID, amount);
	}
		
	public void withdraw(final int usrID, double amount) {
		if(isWithDrawAllowed(amount)) {
			this.operation(usrID, -amount);
		}
	}
	
	public void depositFromATM(int usrID, double amount) {
		this.deposit(usrID, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
	}
	
	public void withdrawFromATM(int usrID, double amount) {
		this.withdraw(usrID, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
	}
}*/

public abstract class AbstractBankAccount implements BankAccount {

    public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;

    private double balance;
    private int nTransactions;
    private final int usrID;

    protected AbstractBankAccount(final int usrID, final double balance) {
        this.usrID = usrID;
        this.balance = balance;
        this.nTransactions = 0;
    }

    protected boolean checkUser(final int id) {
        return this.usrID == id;
    }

    protected abstract double computeFees();

    public final void computeManagementFees(final int usrID) {
        final double feeAmount = computeFees();
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            balance -= feeAmount;
            resetTransactions();
        }
    }

    public final void deposit(final int usrID, final double amount) {
        this.transactionOp(usrID, amount);
    }

    public final void depositFromATM(final int usrID, final double amount) {
        this.deposit(usrID, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    public final double getBalance() {
        return this.balance;
    }

    public final int getNTransactions() {
        return this.nTransactions;
    }

    protected final void incTransactions() {
        this.nTransactions++;
    }

    protected abstract boolean isWithdrawAllowed(double amount);

    protected final void resetTransactions() {
        this.nTransactions = 0;
    }

    protected final void setBalance(final double amount) {
        this.balance = amount;
    }

    private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incTransactions();
        }
    }

    public final void withdraw(final int usrID, final double amount) {
        if (isWithdrawAllowed(amount)) {
            this.transactionOp(usrID, -amount);
        }
    }

    public final void withdrawFromATM(final int usrID, final double amount) {
        this.withdraw(usrID, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

}


