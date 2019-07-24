package com.onlineShopping.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineShopping.configue.DBConnect;
import com.onlineShopping.dao.UserDao;
import com.onlineShopping.pojo.User;

public class UserDaoImpl implements UserDao{

	Connection con=DBConnect.getConnect();
	public boolean addUser(User u) {
		String sql="insert into user(fname,lname,contact,emailId,address,pass) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getContact());
			ps.setString(4, u.getEmailId());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getPass());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User u) {
		String sql="update user set fname=?,lname=?,contact=?,emailId=?,address=?,pass=? where userId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getContact());
			ps.setString(4, u.getEmailId());
			ps.setString(5, u.getAddress());
			ps.setString(6, u.getPass());
			ps.setInt(7, u.getUserId());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int userId) {
		String sql="delete from user where userId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, userId);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		return false;
	}

	public User getUserUserById(int userId) {
		String sql="select * from user where userId=?";
		User u=new User();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				u.setUserId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setContact(rs.getString(4));
				u.setEmailId(rs.getString(5));
				u.setAddress(rs.getString(6));
				u.setPass(rs.getString(7));
				
			}
			return u;
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public User getUserByName(String userEmail) {
		String sql="select * from user where emailId=?";
		User u=new User();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userEmail);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				u.setUserId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setContact(rs.getString(4));
				u.setEmailId(rs.getString(5));
				u.setAddress(rs.getString(6));
				u.setPass(rs.getString(7));
				
			}
			return u;
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		return null;
	}

	public List<User> getAllUser() {
		String sql="select * from user";
		List<User> ul=new ArrayList<User>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				User u=new User();
				u.setUserId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setContact(rs.getString(4));
				u.setEmailId(rs.getString(5));
				u.setAddress(rs.getString(6));
				u.setPass(rs.getString(7));
				ul.add(u);
			}
			return ul;
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public User userLogin(String uname,String pass) {
		String sql="select emailId,pass from user where emailId=? and pass=?";
		User u=new User();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs!=null)
			while(rs.next()) {
				
				u.setEmailId(rs.getString(1));
				
				u.setPass(rs.getString(2));
			}
			
			return u;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
