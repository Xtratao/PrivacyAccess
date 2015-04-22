package cn.ensiie.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class File implements Serializable{
	private int id;
	private String name;
	private String url;
	private String descr;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
	
}
