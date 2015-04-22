package cn.ensiie.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	private int id;
	private String name;
	private String pw;
	private List<Tag> ts = new ArrayList<Tag>();
	
	
	public List<Tag> getTs() {
		return ts;
	}
	public void setTs(List<Tag> ts) {
		this.ts = ts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
