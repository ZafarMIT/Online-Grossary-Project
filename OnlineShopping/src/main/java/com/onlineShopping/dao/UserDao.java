package com.onlineShopping.dao;

import java.util.List;

import com.onlineShopping.pojo.User;

public interface UserDao {

	boolean addUser(User u);
	boolean updateUser(User u);
	boolean deleteUser(int userId);
	User getUserUserById(int userId);
	User getUserByName(String userEmail);
	List<User>  getAllUser();
}
