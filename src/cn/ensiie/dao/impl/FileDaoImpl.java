package cn.ensiie.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.ensiie.domain.File;
import cn.ensiie.domain.Tag;
import cn.ensiie.util.DBCPUtil;
import cn.ensiie.util.TransactionUtil;


public class FileDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	
	
	public void addFile(File file){
		try {
			System.out.println(file.getDescr());
			System.out.println(file.getUrl());
			System.out.println(file.getName());
			qr.update(TransactionUtil.getConnection(), "insert into File (name,url,descr) values (?,?,?)",file.getName(),file.getUrl(),file.getDescr());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteFileById(int id){
		try {
			qr.update(TransactionUtil.getConnection(), "delete from File where id=?", id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateFileDescrByID(File file){
		try {
			qr.update(TransactionUtil.getConnection(), "update File set descr=? where id=?", file.getDescr(),file.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public File findFileByName(String fileName){
		try {
			File file =  qr.query(TransactionUtil.getConnection(), "select * from file where name=?", new BeanHandler<File>(File.class), fileName);
			String sql = "select * from tag where id in (select tag_id from tagfile where file_id=?)";
			List<Tag> tags = qr.query(sql, new BeanListHandler<Tag>(Tag.class), file.getId());
			file.setTs(tags);
			return file;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public File findFileById(int id){
		try {
			File file = qr.query(TransactionUtil.getConnection(), "select * from file where id=?", new BeanHandler<File>(File.class), id);
			String sql = "select * from tag where id in (select tag_id from tagfile where file_id=?)";
			List<Tag> tags = qr.query(sql, new BeanListHandler<Tag>(Tag.class), file.getId());
			file.setTs(tags);
			return file;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
//	 List<Object[]> arraylist = queryRunner  
//             .query(conn, "select * from tab where rownum<=3",  
//                     new ArrayListHandler());  
//
//     for (Iterator<Object[]> itr = arraylist.iterator(); itr.hasNext();) {  
//         Object[] a = itr.next();  
//         System.out.println("--------------");  
//         for (int i = 0; i < a.length; i++) {  
//             System.out.println(a[i]);  
//
//         }  
//     }  
	
	
	
	public List<File> allFiles(){
		try {
			//List<Object[]> fl = qr.query(TransactionUtil.getConnection(), "select * from file", new ArrayListHandler());
			//List<File> list = qr.query("select * from file", new BeanListHandler<File>(File.class));
			List<File> list = qr.query("select * from file", new BeanListHandler<File>(File.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
}
