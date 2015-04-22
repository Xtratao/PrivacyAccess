package cn.ensiie.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.ensiie.domain.TagFile;
import cn.ensiie.util.TransactionUtil;

public class TagFileDaoImpl {
	private QueryRunner qr = new QueryRunner();
	public void addTagFile(TagFile tagFile){
		try {
			qr.update(TransactionUtil.getConnection(), "insert into TagFile (tag_id,file_id) vaules (?,?)",tagFile.getTag_id(),tagFile.getFile_id());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteTagFile(TagFile tagFile){
		try {
			qr.update(TransactionUtil.getConnection(), "delete from TagFile where id=?",tagFile.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public TagFile findTagFileByTagFile(int tagId,int fileId){
		try {
			return qr.query(TransactionUtil.getConnection(), "select * from TagFile where tag_id=? and file_id = ?", new BeanHandler<TagFile>(TagFile.class), tagId,fileId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Integer> findTagFromTagFileByFileId(int fileId){
		//String sql = "select tag_id from TagFile where file_id = ?";
		ArrayList<Integer> tagList= new ArrayList<Integer>(); 
		try {
			List<Map<String,Object>> list= qr.query(TransactionUtil.getConnection(),"select tag_id from TagFile where file_id = ?", new MapListHandler(),fileId);
			for(Map<String,Object> map:list){
				for(Map.Entry<String, Object> me:map.entrySet()){
					//System.out.println(me.getKey()+"="+me.getValue());
					tagList.add((Integer)me.getValue());
				}
			}
			
			return tagList;
			//return qr.query(TransactionUtil.getConnection(), sql, new BeanHandler<TagFile>(TagFile.class),fileId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
