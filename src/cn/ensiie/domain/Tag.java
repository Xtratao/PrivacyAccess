package cn.ensiie.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tag implements Serializable {
	private int id;
	private String tag_name;
	private String descr;
	private List<File> fs = new ArrayList<File>();
	
	
	
	public List<File> getFs() {
		return fs;
	}
	public void setFs(List<File> fs) {
		this.fs = fs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
	
	
}
