package prog_5_3.gui.prog_3_2;

/**
 * Program to refactor the Account class so that the three account types CHECKING, SAVINGS, RETIREMENT
 *  are the three instances of an enumerated type called AccountType
 * @author Adeola Adeleke (STUDENT ID: #610516)
 */

class Account {

	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountType acctType;
	private Employee employee;

	Account(Employee emp, AccountType acctType, double balance) {
		this.employee = emp;
		this.acctType = acctType;
		this.balance = balance;
	}

	Account(Employee emp, AccountType acctType) {
		this(emp, acctType, DEFAULT_BALANCE);
	}
	
	
	@Override
	public String toString() {
		//fixed alignment too
		return String.format("Account type: %s%nCurrent bal:  %-1.1f%n",acctType.toString().toLowerCase(),balance);
	}

	/**
	 * update the balance by making deposit either for loans or savings
	 * @param deposit
	 */
	public void makeDeposit(double deposit) {
		// implement
		this.balance += deposit;
	}

	public boolean makeWithdrawal(double amount) {
		if(this.balance >= amount ) {
			this.balance -= amount;
			return true;
		}
		return false;
	}
	
	/**
	 * I added these codes
	 */
	
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * @return the acctType
	 */
	public AccountType getAcctType() {
		return acctType;
	}


	
}
