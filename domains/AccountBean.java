package com.bitcamp.domains;

public class AccountBean extends MemberBean{
	private String accountNum, regDate, money;
	private static final long serialVersionUID = 1L;
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "AccountBean "
				+ "[accountNum=" + accountNum 
				+ ", regDate=" + regDate 
				+ ", money=" + money + "]";
	}
	
	
}
