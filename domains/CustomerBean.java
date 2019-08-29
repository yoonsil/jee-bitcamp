package com.bitcamp.domains;

public class CustomerBean extends MemberBean{
	private String credit;
	private static final long serialVersionUID = 1L;
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	public String toString() {
		return "회원정보 "
				+ "[id=" + getId()
				+ ", pw=" + getPw()
				+ ", name=" + getName()
				+ ", ssn=" + getSsn() 
				+ ", credit =" + credit +"]";
	}
}
