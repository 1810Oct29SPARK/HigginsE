package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Members;
import com.revature.repositories.MembersDAO;


public class MembersService {
	
	private MembersDAO ud;
	
	public void setMembersDAO(MembersDAO ud) {
		this.ud = ud;
	}
	
	public Members saveUser(Members user) {
		Members u = null;
		return u;
	}
	
	public List<Members> getMembers(){
		return ud.findAll();
	}
	
	public Members getMember(int id) {
		return ud.getById(id);
	}
}
