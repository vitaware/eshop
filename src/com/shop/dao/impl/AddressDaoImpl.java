package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.domain.Address;
import com.shop.dao.AddressDao;
import com.shop.utils.JDBCTools;

public class AddressDaoImpl implements AddressDao{
	
	public List<Address> getAllAddress(String parentid){
		Connection conn = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		List<Address> list = new ArrayList<Address>();
		Address adr = null;
		try {
			conn = JDBCTools.getConn();
			String sql = "select * from areas where 1=1 and parentid=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, parentid);
			rs = stmt.executeQuery();
			while(rs.next()){
			//	System.out.println( rs.getString("id"));
			//	System.out.println(rs.getString("name"));
				adr = new Address();
				adr.setId(rs.getString("id"));
				adr.setName(rs.getString("name"));
				adr.setParentid(rs.getString("parentid")); 
				adr.setOrderfield(rs.getString("orderfield"));
				list.add(adr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.close( rs, stmt,conn);
		}
		return list;
	}
}
