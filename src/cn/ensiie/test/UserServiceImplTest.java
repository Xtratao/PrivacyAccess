package cn.ensiie.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.ensiie.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	
	UserServiceImpl us = new UserServiceImpl();

	@Test
	public void testAuthentification() {
		boolean res = us.authentification("Paul","123457" );
		System.out.println(res);
	}

	@Test
	public void testWho() {
		boolean res = us.who("admoN");
		System.out.println(res);
	}

}
