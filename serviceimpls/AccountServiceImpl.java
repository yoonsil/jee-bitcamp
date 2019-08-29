package com.bitcamp.serviceimpls;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bitcamp.domains.AccountBean;
import com.bitcamp.services.AccountServcice;

public class AccountServiceImpl implements AccountServcice{
	private List<AccountBean> accounts;
	public AccountServiceImpl() {
		accounts = new ArrayList<>();
	}
	public void createAccount(String money) {
		AccountBean ab = new AccountBean();
		ab.setMoney(money+"");
		ab.setAccountNum(createAccountNum());
		ab.setRegDate(findDate());
		accounts.add(ab);
		System.out.println(ab.toString());
	}

	public String createAccountNum() {
		String result ="";
		Random ran = new Random();
		String num = ran.nextInt(10)+"";
		for(int i=0; i<9; i++) {
			result += (i==4)?"-": ran.nextInt(10);
		}
		return result;
	}

	public List<AccountBean> findAll() {
		return accounts;
	}

	public AccountBean findByAccountNum(String accountNum) {
		AccountBean ac = new AccountBean();
		for(AccountBean c: accounts) {
			if(accountNum.equals(c.getAccountNum())) {
				ac = c;
				break;
			}
		}
		return ac;
	}

	public int countAccounts() {
		return accounts.size();
	}

	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		for(AccountBean c :accounts) {
			if(accountNum.equals(c.getAccountNum())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").
				format(new Date());
	}

	public void depositMoney(AccountBean param) {
		String saving = param.getMoney();
		int i =0;
		for(AccountBean a : accounts) {
			if(param.getAccountNum().equals(a.getAccountNum())) {
				break;
				}
				i++;
			}
			String acMoney = String.valueOf
					(Integer.parseInt(accounts.get(i).getMoney())+
					Integer.parseInt(saving));
			accounts.get(i).setMoney(acMoney);
		}

	public void withdrawMoney(AccountBean param) {
		String withdraw = param.getMoney();
		int i =0;
		for(AccountBean a : accounts) {
		if(param.getAccountNum().equals(a.getAccountNum())){
			break;
			}
		i++;
		}
		String money = String.valueOf 
				(Integer.parseInt(accounts.get(i).getMoney())
				-Integer.parseInt(withdraw));
		accounts.get(i).setMoney(money);
	}
	public void deleteAccountNum(String accountNum) {
		accounts.remove(findByAccountNum(accountNum));
			return;
	}
}