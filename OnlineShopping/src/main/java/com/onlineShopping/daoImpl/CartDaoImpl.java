package com.onlineShopping.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineShopping.configue.DBConnect;
import com.onlineShopping.dao.CartDao;
import com.onlineShopping.pojo.Cart;

public class CartDaoImpl implements CartDao{

	Connection con=DBConnect.getConnect();
	public boolean addToCart(int pid,String userEmail) {

		String sql="insert into cart(pid,userName) values(?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, userEmail);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Cart> getCartList(String userEmail) {
		String sql=" select pname,pdescription,price from product p inner join cart c on p.pid=c.pid where userName=?";
		List<Cart> cl=new ArrayList<Cart>();
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userEmail );
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Cart c=new Cart();
				c.setPname(rs.getString(1));
				c.setPdescription(rs.getString(2));
				c.setPrice(rs.getDouble(3));
				cl.add(c);
			}
			return cl;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteCart(int cartId) {

		String sql="delete from cart where cartId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, cartId);

			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean clearCart(String userName) {
		String sql="delete from cart where userName=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);

			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
}
