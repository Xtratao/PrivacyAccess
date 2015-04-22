package cn.ensiie.test;

import static org.junit.Assert.*;


import java.util.List;
import org.junit.Test;
import cn.ensiie.dao.impl.FileDaoImpl;
import cn.ensiie.domain.File;
import cn.ensiie.domain.Tag;

public class FileDaoImplTest {

	private FileDaoImpl fileDao = new FileDaoImpl();
	@Test
	public void testAddFile() {
		File f = new File();
		f.setUrl("C:\\test.pdf");
		f.setName("test2");
		f.setDescr("descr test");
		
		fileDao.addFile(f);
		
		
	}

	@Test
	public void testDeleteFileById() {
		fileDao.deleteFileById(15);
	}

	@Test
	public void testUpdateFileDescrByID() {
		File f = new File();
		f.setId(3);
		f.setUrl("C:\\test.pdf");
		f.setName("test");
		f.setDescr("descr test");
		
		fileDao.updateFileDescrByID(f);
		
	}

	@Test
	public void testFindFileByName() {
		File f = fileDao.findFileByName("Histoire3");
		System.out.println(f.getUrl());
		System.out.println(f.getTs().size());
		List<Tag> l = f.getTs();
		for(Tag t:l){
			System.out.println(t.getTag_name());
		}
	}

	@Test
	public void testFindFileById() {
		File f = fileDao.findFileById(2);
		System.out.println(f.getUrl());
		System.out.println(f.getUrl());
		System.out.println(f.getTs().size());
		List<Tag> l = f.getTs();
		for(Tag t:l){
			System.out.println(t.getTag_name());
		}
	}


	@Test
	public void testAllFiles(){
		List<File> list = fileDao.allFiles();
		for(File f:list){
			System.out.println("name is "+f.getName());
		}
	}
}
