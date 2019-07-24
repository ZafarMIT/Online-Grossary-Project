package com.onlineShopping.dao;

import java.util.List;

import com.onlineShopping.pojo.Product;

public interface ProductDao {

	
	boolean addProduct(Product p);
	boolean updateProduct(Product p);
	boolean deleteProduct(int pid);
	Product getProductById(int pid);
	List<Product> getProductList();
	
	List<Product> searchProductList(String pname);
	
	List<Product> getProductByCategory(String category);
	
	
}
