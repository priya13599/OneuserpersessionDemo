package com.nucleus.dao;

import java.sql.SQLException;

import com.nucleus.entity.User;

public interface UserDao {

	
	public User checkdetails(User user) throws SQLException;
	public void updatedetails(User user) throws SQLException;
	public void logoutdetails(String userid) throws SQLException;
}
