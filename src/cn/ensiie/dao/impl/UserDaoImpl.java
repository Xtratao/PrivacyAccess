package cn.ensiie.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.ensiie.domain.Tag;
import cn.ensiie.domain.User;
import cn.ensiie.util.DBCPUtil;
import cn.ensiie.util.TransactionUtil;

public class UserDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	
	
	public void addUser(User user){
		try {
			qr.update(TransactionUtil.getConnection(), "insert into User (name,pw) vaules (?,?)",user.getName(),user.getPw());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User findUser(String userName){
		try {
			User u =  qr.query(TransactionUtil.getConnection(), "select * from user where name=?", new BeanHandler<User>(User.class), userName);
			String sql = "select * from tag where id in (select tag_id from ruleusertag where user_id=?)";
			List<Tag> tags = qr.query(sql, new BeanListHandler<Tag>(Tag.class), u.getId());
			u.setTs(tags);
			return u;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void updateUserPasswordById(User user){
		try {
			qr.update(TransactionUtil.getConnection(), "update User set pw=? where id=?",user.getPw(),user.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateUserNameById(User user){
		try {
			qr.update(TransactionUtil.getConnection(), "update User set name=? where id=?",user.getName(),user.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<User> allUsers(){
		try {
			//List<Object[]> ul = qr.query(TransactionUtil.getConnection(), "select * from user", new ArrayListHandler());
			List<User> list = qr.query("select * from user", new BeanListHandler<User>(User.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}  
	}
	
	
	
}
