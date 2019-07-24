package com.onlineShopping.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineShopping.configue.DBConnect;
import com.onlineShopping.dao.ProductDao;
import com.onlineShopping.pojo.Product;

public class ProductDaoImpl implements ProductDao {
	Connection con=DBConnect.getConnect();

	public boolean addProduct(Product p) {
		String sql="insert into product(pname,price,pdescription,category) value(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, p.getPname());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getpDescription());
			ps.setString(4, p.getCategory());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProduct(Product p) {
		String sql="update  product pname=?,price=?,pdescription=?,category=? where pid=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, p.getPname());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getpDescription());
			ps.setString(4, p.getCategory());
			ps.setInt(5, p.getPid());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteProduct(int pid) {
		String sql="delete from  product where pid=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, pid);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Product getProductById(int pid) {
		
		String sql="select * from product where pid=?";
		Product p=new Product();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setpDescription(rs.getString(4));
				p.setCategory(rs.getString(5));
				
				
			}
			
			return p;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getProductList() {
		
		String sql="select * from product";
		List<Product> pl=new ArrayList<Product>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setpDescription(rs.getString(4));
				p.setCategory(rs.getString(5));
				
				pl.add(p);
			}
			
			return pl;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Product> getProductByCategory(String category) {
		String sql="select * from product where category=?";
		List<Product> pl=new ArrayList<Product>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setpDescription(rs.getString(4));
				p.setCategory(rs.getString(5));
				
				pl.add(p);
			}
			
			return pl;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> searchProductList(String pname) {
		String sql="select * from product where pname like '%"+pname+"%'";
		List<Product> pl=new ArrayList<Product>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setpDescription(rs.getString(4));
				p.setCategory(rs.getString(5));
				
				pl.add(p);
			}
			
			return pl;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
