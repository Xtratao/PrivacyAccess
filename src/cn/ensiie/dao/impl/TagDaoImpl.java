package cn.ensiie.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.ensiie.domain.File;
import cn.ensiie.domain.Tag;
import cn.ensiie.util.DBCPUtil;
import cn.ensiie.util.TransactionUtil;

public class TagDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void addTag(Tag tag){
		try {
			qr.update(TransactionUtil.getConnection(), "insert into Tag (tag_name,descr) values (?,?)",tag.getTag_name(),tag.getDescr());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteTagById(int id){
		try {
			qr.update(TransactionUtil.getConnection(), "delete from Tag where id=?", id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateTagDescrByID(Tag tag){
		try {
			qr.update(TransactionUtil.getConnection(), "update Tag set descr=? where id=?", tag.getDescr(),tag.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public Tag findTagByName(String tagName){
		try {
			Tag t =  qr.query(TransactionUtil.getConnection(), "select * from Tag where tag_name=?", new BeanHandler<Tag>(Tag.class), tagName);
			String sql = "select * from file where id in (select file_id from tagfile where tag_id=?)";
			List<File> files = qr.query(sql, new BeanListHandler<File>(File.class), t.getId());
			t.setFs(files);
			return t;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Tag findTagById(int id){
		try {
			Tag t = qr.query(TransactionUtil.getConnection(), "select * from Tag where id=?", new BeanHandler<Tag>(Tag.class), id);
			String sql = "select * from file where id in (select file_id from tagfile where tag_id=?)";
			List<File> files = qr.query(sql, new BeanListHandler<File>(File.class), t.getId());
			t.setFs(files);
			return t;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
}
