package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.shop.dao.UmShopCartsDao;
import com.shop.domain.UmShopCarts;
import com.shop.utils.JDBCTools;




public class UmShopCartsDaoImpl implements UmShopCartsDao{
	
	public boolean addUmShopCarts(UmShopCarts usc) {
		Connection  conn = null;
		PreparedStatement  stmt = null;
		ResultSet  rs = null;
		try {
			 conn = JDBCTools.getConn();
			 String sql = "insert into shopcarts  values(?,?,?,?,?,?,?)";
			 
			 stmt = conn.prepareStatement(sql);
			 stmt.setString(1, usc.getId());
			 stmt.setString(2, usc.getName());
			 stmt.setString(3, usc.getColour());
			 stmt.setString(4, usc.getCommoditytyp());
			 stmt.setString(5, usc.getGoodsname());
			 stmt.setDouble(6, usc.getPrice());
			 stmt.setInt(7, usc.getProductnum());
			 int num = stmt.executeUpdate();
			 if(num>0){
				 System.out.println("添加成功");
				 return true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			return false ;
		} finally{
			JDBCTools.close(rs, stmt, conn);
		}
		return false ;
	}

	public List<UmShopCarts> findAll() {
		Connection  conn = null;
		PreparedStatement  stmt = null;
		ResultSet  rs = null;
		UmShopCarts usc = null;
		List<UmShopCarts> list =  new ArrayList<UmShopCarts>();;
		try {
			conn = JDBCTools.getConn();
			String sql = "select * from shopcarts";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				usc = new UmShopCarts();
				
				usc.setId( rs.getString("id"));
				usc.setName(rs.getString("name"));
				usc.setGoodsname(rs.getString("goodsname"));
				usc.setColour(rs.getString("colour"));
				usc.setCommoditytyp( rs.getString("commoditytyp") );
				usc.setProductnum(rs.getInt("productnum"));
				usc.setPrice(rs.getDouble("price"));
				
				
				list.add(usc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.close(rs, stmt, conn);
		}
		return list;
	}

	public boolean delUmShopCarts(String id) {
		Connection  conn = null;
		PreparedStatement  stmt = null;
		ResultSet  rs = null;
		boolean bool = false;
		try {
			conn = JDBCTools.getConn();
			//System.out.println("name   "+name);
			String sql = "delete from shopcarts where id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			int num = stmt.executeUpdate();
			if(num>0){
				bool = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.close(rs, stmt, conn);
		}
		return bool;
	}

	public boolean UmShopCarts(UmShopCarts usc) {
		// TODO Auto-generated method stub
		return false;
	}

	public UmShopCarts  findUmShopCartsById(String id) {
		Connection  conn = null;
		PreparedStatement  stmt = null;
		ResultSet  rs = null;
		UmShopCarts user = null;
		try {
			conn = JDBCTools.getConn();
			String sql = "select * from shopcarts where id=?" ;
			stmt =conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				user = new UmShopCarts();
				user.setId( rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setColour(rs.getString("colour"));
				user.setCommoditytyp(rs.getString("commoditytyp"));
				user.setGoodsname(rs.getString("goodsname"));
				user.setPrice(rs.getDouble("price"));
				user.setProductnum(rs.getInt("productnum"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCTools.close(rs, stmt, conn);
		}
		return user;
		
	}

	public boolean updataUmShopCarts(UmShopCarts usc) {
		Connection  conn = null;
		PreparedStatement  stmt = null;
		ResultSet  rs = null;
		boolean bool = false;
		try {
			 conn = JDBCTools.getConn();
			 String sql = "update shopcarts set goodsname=?,colour=?,commoditytyp=?,productNum=? where id=?";
			 
			 stmt = conn.prepareStatement(sql);
			
			 stmt.setString(1, usc.getGoodsname());
			 stmt.setString(2, usc.getColour());
			
			 stmt.setString(3, usc.getCommoditytyp());
			 stmt.setInt(4, usc.getProductnum());
			 stmt.setString(5,usc.getId());
			 int num = stmt.executeUpdate();
			 if(num>0){
				 bool =  true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally{
			JDBCTools.close(rs, stmt, conn);
		}
		return bool;
		
	}
	


}
