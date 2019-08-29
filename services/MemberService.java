package com.bitcamp.services;

import java.util.List;

import com.bitcamp.domains.*;

public interface MemberService {
	public void join(CustomerBean param);
	public void register(AdminBean param);
	public List<CustomerBean> findAllCustomers();
	public List<AdminBean> findAllAdmins();
	public List<MemberBean> findbyName(String name);
	public MemberBean findbyId(String id);
	public boolean login(MemberBean param);
	public int countCustomers();
	public int countAdmins();
	public boolean existId(String id);
	public void updatePw(MemberBean param);
	public boolean deleteMember(MemberBean param);
}
