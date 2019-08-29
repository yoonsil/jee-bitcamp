package com.bitcamp.domains;

public class AdminBean extends MemberBean{
	private static final long serialVersionUID = 1L;
	private String employnumber;
	public String getEmploynumber() {
		return employnumber;
	}

	public void setEmploynumber(String employnumber) {
		this.employnumber = employnumber;
	}
	public String toString() {
		return "사원정보 "
				+ "[id=" + getId()
				+ ", pw=" + getPw()
				+ ", name=" + getName()
				+ ", ssn=" + getSsn() 
				+ ", employNumber =" + employnumber +"]";
	}
}
