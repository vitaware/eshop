package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shop.dao.UMUserDao;
import com.shop.domain.User;
import com.shop.utils.JDBCTools;

/**
 * UserDao impliments
 * 
 * @author Administrator
 * 
 */
public class UMUserDaoImpl implements UMUserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shop.dao.impl.UserDao#findByName(java.lang.String)
	 */
	public User findByName(String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JDBCTools.getConn();
			String sql = "select * from um where name=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setBirthday(rs.getDate("birthday"));
				user.setGender(rs.getString("gender"));
				user.setAddress(rs.getString("address"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.close(rs, stmt, conn);
		}
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shop.dao.impl.UserDao#regiterUser(com.shop.domain.User)
	 */
	public boolean regiterUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCTools.getConn();
			String sql = "insert into UM values(?,?,?,?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPwd());
			stmt.setDate(4, new java.sql.Date(  user.getBirthday().getTime()));
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getAddress());
			int num = stmt.executeUpdate();
			if (num > 0) {
				System.out.println("鎭枩浣狅紝娉ㄥ唽鎴愬姛锛�");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCTools.close(rs, stmt, conn);
		}
		return false;
	}
	/**
	 * 鐧诲綍妯″潡
	 */

	public User loginUser(String name, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JDBCTools.getConn();
			String sql = "select * from um where name=? and pwd=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setBirthday(rs.getDate("birthday")); // util Date sql
															// Date鏄痷til鐨勫瓙绫�
				user.setGender(rs.getString("gender"));
				user.setAddress(rs.getString("address"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.close(rs, stmt, conn);
		}
		return user;
	}
	/**
	 * 鏇存柊鐢ㄦ埛淇℃伅
	 */
	public boolean updateUser(User user) {
		Connection  conn = null;
		PreparedStatement  stmt = null;
		ResultSet  rs = null;
		boolean bool=false;
		try {
			conn = JDBCTools.getConn();
			String sql = "update um set birthday=?,gender=? ,address=? where name=?" ;
			stmt =conn.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(user.getBirthday().getTime()));
			stmt.setString(2, user.getGender());
			stmt.setString(3,user.getAddress());   
			stmt.setString(4, user.getName());
			int num = stmt.executeUpdate();
			if(num>0){
				bool=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.close(rs, stmt, conn);
		}
		return bool;

	}

	public List<User> findAll() {
		Connection  conn = null;
		PreparedStatement  stmt = null;
		ResultSet  rs = null;
		User user = null;
		List<User> list=new ArrayList<User>();
		try {
			conn = JDBCTools.getConn();
			String sql = "select * from um" ;
			stmt =conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				user = new User();
				user.setId( rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setBirthday( rs.getDate("birthday")  ); //  util Date  sql Date鏄痷til鐨勫瓙绫�
				user.setGender(rs.getString("gender"));
				user.setAddress(rs.getString("address"));
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.close(rs, stmt, conn);
		}
		return list;
	}


	public User findUserById(String id) {
		Connection  conn = null;
		PreparedStatement  stmt = null;
		ResultSet  rs = null;
		User user = null;
		try {
			conn = JDBCTools.getConn();
			String sql = "select * from um where id=?" ;
			stmt =conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				user = new User();
				user.setId( rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setBirthday( rs.getDate("birthday")  ); //  util Date  sql Date鏄痷til鐨勫瓙绫�
				user.setGender(rs.getString("gender"));
				user.setAddress(rs.getString("address"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.close(rs, stmt, conn);
		}
		return user;
	}

}
