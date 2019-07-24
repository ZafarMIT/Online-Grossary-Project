package com.onlineShopping.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineShopping.configue.DBConnect;
import com.onlineShopping.dao.OrderDao;
import com.onlineShopping.pojo.Order;

public class OrderDaoImpl  implements OrderDao
{
	Connection con=DBConnect.getConnect();

	public boolean addOrder(Order order) {
		String sql="insert into placeOrder (status,orderDate,totalBill,userName) values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, order.getStatus());
			ps.setString(2, order.getOrderDate());
			ps.setDouble(3, order.getTotalBill());
			ps.setString(4, order.getUserName());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Order> getAllOrder() {
		String sql="select * from placeOrder";
		List<Order> ol=new ArrayList<Order>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Order o=new Order();
				o.setOrderId(rs.getInt(1));
				o.setStatus(rs.getString(2));
				o.setOrderDate(rs.getString(3));
				o.setTotalBill(rs.getDouble(4));
				o.setUserName(rs.getString(5));
				
				ol.add(o);
			}
			return ol;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Order> getOrderByUser(String userName) {
		String sql="select * from placeOrder where userName=?";
		List<Order> ol=new ArrayList<Order>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Order o=new Order();
				o.setOrderId(rs.getInt(1));
				o.setStatus(rs.getString(2));
				o.setOrderDate(rs.getString(3));
				o.setTotalBill(rs.getDouble(4));
				o.setUserName(rs.getString(5));
				
				ol.add(o);
			}
			return ol;
		}catch (Exception e) {
			e.printStackTrace();
		}		return null;
	}

	public boolean deleteOrder(int orderId) {
		String sql="delete from placeOrder where orderId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
		
			ps.setInt(1, orderId);
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
