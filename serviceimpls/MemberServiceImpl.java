package com.bitcamp.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.domains.AdminBean;
import com.bitcamp.domains.CustomerBean;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;

public class MemberServiceImpl implements MemberService{

	private List<CustomerBean> customers;
	private List<AdminBean> admins;
	
	public MemberServiceImpl() {
		customers = new ArrayList<>();
		admins = new ArrayList<>();		
	}//storage
	public void join(CustomerBean param) {
		customers.add(param);
	}
	public void register(AdminBean param) {
		admins.add(param);
	}
	public List<CustomerBean> findAllCustomers() {
		return customers;
	}
	public List<AdminBean> findAllAdmins() {
		return admins;
	}
	public List<MemberBean> findbyName(String name) {
		List<MemberBean> m = new ArrayList<>();
		int count =0;
		for(CustomerBean c: customers) { //:(in)
			if(name.equals(c.getName())) {
				count ++;
			}
		}
		for(AdminBean a:admins) {
			if(name.equals(a.getName())) {
				count ++;
			}
		}
		//--------------------------
		int j =0;
		for(CustomerBean c: customers) { //:(in)
			if(name.equals(c.getName())) {
				m.add(c);
				j++;
				if(count == j) {
					return m;
				}
			}
		}
		for(AdminBean a:admins) {
			if(name.equals(a.getName())) {
				m.add(a);
				j++;
				if(count == j) {
					return m;
				}
			}
		}
		return m;
	}

	public MemberBean findbyId(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c: customers) {
			if(id.equals(c.getId())) {
				m = c;
				return m;
			}
		}
		for(AdminBean e: admins) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
			
		}
		return m;
	}
	public boolean login(MemberBean param) {
		boolean flag = false;
		MemberBean m = findbyId(param.getId());
		for(CustomerBean c: customers) {
			if(m.equals(c.getId())) {
				flag = true;
				break;
			}
		}
		for(AdminBean e: admins) {
			if(m.equals(e.getId())) {
				flag = true;
				break;
			}
			
		}
		return flag;
	}
	public int countCustomers() {
		return customers.size();
	}
	public int countAdmins() {
		return admins.size();
	}
	public boolean existId(String id) {
		MemberBean m = findbyId(id);
		return (customers.contains(m)||admins.contains(m));
	}
	public void updatePw(MemberBean param) {
		String id = param.getId();
		String oldpw = param.getPw().split(",")[0];
		String newpw = param.getPw().split(",")[1];
		MemberBean m = findbyId(id);
		if(m.getPw().equals(oldpw)) {
		int idx = (admins.contains(m))?
				admins.indexOf(m):
					customers.indexOf(m);
		if(admins.contains(m)) {
			admins.get(idx).setPw(newpw);
		}else {
			customers.get(idx).setPw(newpw);
			}
		}
		
	}
	public boolean deleteMember(MemberBean param) {
		MemberBean m = findbyId(param.getId());
		return (admins.contains(m))
			?	admins.remove(m)
					:customers.remove(m);
	}
}
