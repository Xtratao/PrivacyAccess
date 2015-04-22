package cn.ensiie.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.ensiie.dao.impl.UserDaoImpl;
import cn.ensiie.domain.Tag;
import cn.ensiie.domain.User;

public class UserDaoImplTest {
	private UserDaoImpl ud = new UserDaoImpl();
	@Test
	public void testAddUser() {
		User u = new User();
		u.setName("test");
		u.setPw("123456");
		
		
	}

	
	@Test
	public void testFindUser() {
		User u = ud.findUser("Paul");
		List<Tag> l = u.getTs();
		for(Tag t:l){
			System.out.println(t.getTag_name());
		}
		
	}

	@Test
	public void testUpdateUserPasswordById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUserNameById() {
		fail("Not yet implemented");
	}

}
