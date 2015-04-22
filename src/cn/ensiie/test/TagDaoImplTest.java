package cn.ensiie.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.ensiie.dao.impl.TagDaoImpl;
import cn.ensiie.domain.File;
import cn.ensiie.domain.Tag;

public class TagDaoImplTest {

	TagDaoImpl td = new TagDaoImpl();
	@Test
	public void testAddTag() {
		Tag t = new Tag();
		t.setDescr("test tag");
		t.setTag_name("test");
		
		td.addTag(t);
		
	}

	@Test
	public void testDeleteTagById() {
		td.deleteTagById(6);
	}

	@Test
	public void testUpdateTagDescrByID() {
		Tag t = new Tag();
		t.setDescr("test");
		t.setTag_name("b");
		t.setId(2);
		
		td.updateTagDescrByID(t);
		
	}

	@Test
	public void testFindTagByName() {
		Tag t = td.findTagByName("b");
		List<File> l = t.getFs();
		for(File f:l){
			System.out.println(f.getName());
		}
	}

	@Test
	public void testFindTagById() {
		Tag t = td.findTagById(2);
		System.out.println(t.getTag_name());
		List<File> l = t.getFs();
		for(File f:l){
			System.out.println(f.getName());
		}
	}

}
