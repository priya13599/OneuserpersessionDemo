package com.nucleus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nucleus.connection.Connectionclass;
import com.nucleus.entity.User;

public class UserDaoRDBMSImpl implements UserDao {
	Connectionclass connectionclass = new Connectionclass(); //Object of Connectionclass
	Connection con = connectionclass.getDBConnection();
	@Override
	public User checkdetails(User user) throws SQLException {
		String flag ="";
		PreparedStatement psmt = con.prepareStatement("select * from session where userid =?");
		psmt.setString(1,user.getUserId());
		ResultSet rs = psmt.executeQuery();
		while(rs.next())
		{
			 flag = rs.getString(3);
			System.out.println("Login Successfully");
			
		}
		user.setFlag(flag);
		
		return user;
	}
	@Override
	public void updatedetails(User user) throws SQLException {
		PreparedStatement psmt = con.prepareStatement("Update session set flag = ? where userid =?");
		psmt.setString(1, "Active");
		psmt.setString(2, user.getUserId());
		int n = psmt.executeUpdate();
		if(n!=0)
		{
			System.out.println("Record Updated");
		}
		
	}
	@Override
	public void logoutdetails(String  userid) throws SQLException {
		
		PreparedStatement psmt = con.prepareStatement("Update session set flag = ? where userid =?");
		psmt.setString(1, null);
		psmt.setString(2, userid);
		int n = psmt.executeUpdate();
		if(n!=0)
		{
			System.out.println("Logout Updated");
		}
	}

}
