package com.shop.utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc工具类
 * @author Administrator
 *
 * 1、 获取到链接
 * 
 * 2、关闭资源
 */
public class JDBCTools {
	/**  数据库驱动名称*/
	private   static String drivername = null; 
	/**
	 * 数据链接地址
	 */
	private  static String url = null;
	/**
	 * 数据库的用户名称
	 */
	private  static String  username  = null;
	/**
	 * 数据库的密码
	 */
	private  static String password = null;
	
	
	 static{
		//创建properties对象
		Properties  prop = new Properties();
		
		//将配置文件 以流的形式 读取进来
		InputStream  is = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(is);
			drivername = prop.getProperty("jdbcdrivername");
			url = prop.getProperty("jdbcaddressname");
			username = prop.getProperty("dbusername");
			password = prop.getProperty("dbpassword");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			Class.forName(drivername).newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	 }
	
	/**
	 * 获取链接
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 关闭资源
	 * @param rs    ResultSet 
	 * @param stmt  Statement
	 * @param conn  Connection
	 */
	public static void close(ResultSet rs, Statement  stmt, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
			rs=null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn =null;
		}
	}
}
