package cn.ensiie.service.impl;

import java.util.List;

import cn.ensiie.dao.impl.FileDaoImpl;
import cn.ensiie.domain.File;
import cn.ensiie.domain.Tag;

public class FileServicImpl {
	private FileDaoImpl dao = new FileDaoImpl();
	
	public List<Tag> tagListForFileByName(String name){
		return dao.findFileByName(name).getTs();
	}
	
	public List<Tag> tagListForFileById(int id){
		return dao.findFileById(id).getTs();
	}
	
	public List<File> allFileForAdmin(){
		return dao.allFiles();
	}
}
