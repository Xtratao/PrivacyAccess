package cn.ensiie.service.impl;


import java.util.ArrayList;
import java.util.List;

import cn.ensiie.dao.impl.TagDaoImpl;
import cn.ensiie.dao.impl.UserDaoImpl;
import cn.ensiie.domain.File;
import cn.ensiie.domain.Tag;
import cn.ensiie.domain.User;

public class UserServiceImpl {
	private UserDaoImpl dao = new UserDaoImpl();
	private TagDaoImpl daoT = new TagDaoImpl();
	public boolean authentification(String name,String vpwd){
		User u = dao.findUser(name);
		if(u==null)
			return false;
		if(u.getPw().equals(vpwd)){
			return true;
		}
		return false;
	}
	
	public boolean who(String name){
		if("admin".equalsIgnoreCase(name)){
			return true;
		}
		return false;
	}
	
	public List<User> userListForAdmin(){
		return dao.allUsers();
	}
	
	public List<Tag> tagListForUserByName(String name){
		return dao.findUser(name).getTs();
	}
	
	public List<File> fileListForUserByName(String name){
		List<Tag> lt = dao.findUser(name).getTs();
		List<File> lf = new ArrayList<File>();
		
		for(Tag t:lt){
			List<File> fs = daoT.findTagById(t.getId()).getFs();
			for(File f:fs){
				lf.add(f);
			}
		}
		return lf;	
		
	}
	
//	public List<User> userListForFile(String name){
//		
//		
//	}
}
