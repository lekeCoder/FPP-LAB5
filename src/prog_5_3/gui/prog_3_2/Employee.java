package prog_5_3.gui.prog_3_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Employee {
	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
		hireDate = LocalDate.of(yearOfHire,monthOfHire,dayOfHire);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the hireDate
	 */
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void createNewChecking(double startAmount) {
		checkingAcct = new Account(this, AccountType.CHECKINGS, startAmount);
	}
	public void createNewSavings(double startAmount) {
		savingsAcct = new Account(this, AccountType.SAVINGS, startAmount);
	}
	public void createNewRetirement(double startAmount) {
		retirementAcct = new Account(this, AccountType.DEPOSIT, startAmount);
	}
	public void deposit(AccountType acctType, double amt){
		switch(acctType) {
			case CHECKINGS:
				if(checkingAcct != null) {
					checkingAcct.makeDeposit(amt);
				}
				break;
			case DEPOSIT:
				if(retirementAcct != null) {
					retirementAcct.makeDeposit(amt);
				}
				break;
			case SAVINGS:
				if(savingsAcct != null) {
					savingsAcct.makeDeposit(amt);
				}
				break;
			default:
				break;
		}
	}
	public boolean withdraw(AccountType acctType, double amt){
		switch(acctType) {
			case CHECKINGS:
				if(checkingAcct != null) {
					return checkingAcct.makeWithdrawal(amt);
				}
				break;
			case DEPOSIT:
				if(retirementAcct != null) {
					return retirementAcct.makeWithdrawal(amt);
				}
				break;
			case SAVINGS:
				if(savingsAcct != null) {
					return savingsAcct.makeWithdrawal(amt);
				}
				break;
			default:
				break;
		}
		return false;
	
	}
	public String getFormattedAcctInfo() {
		
		StringBuilder sb = new StringBuilder(String.format("ACCOUNT INFO FOR %s:\n\n",getName()));
		
		if(checkingAcct != null) {
			sb.append(checkingAcct);
		}
		
		if(savingsAcct != null) {
			sb.append(savingsAcct);
		}
		
		if(retirementAcct != null) {
			sb.append(retirementAcct);
		}
		
		sb.append("\n");
		return sb.toString();
	}
	
}
