package org.xm.esper.context.banktxn;

public class BankTxn {

	
	
	public BankTxn(int custId, String account, int amount) {
		super();
		this.custId = custId;
		this.account = account;
		this.amount = amount;
	}

	private int custId;

	private String account;

	private int amount;

	public int getCustId() {
		return custId;
	}

	public String getAccount() {
		return account;
	}

	public int getAmount() {
		return amount;
	}

}
