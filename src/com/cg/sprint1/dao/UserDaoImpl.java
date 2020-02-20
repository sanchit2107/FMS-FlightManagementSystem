package com.cg.sprint1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.sprint1.bean.User;
import com.cg.sprint1.util.MyDBConnection;

/**
 * 
 * @author Riya Upadhyaya
 *
 */
public class UserDaoImpl implements UserDao {

	List<User> userList = new ArrayList<>();
	Connection con = MyDBConnection.getConnection();

	@Override
	public User addUser(User user) {
		try {

			PreparedStatement ps = con.prepareStatement("insert into usertable values(?,?,?,?,?,?)");
			ps.setLong(1, user.getUserId());
			ps.setString(2, user.getUserType());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassword());
			ps.setLong(5, user.getUserPhone());
			ps.setString(6, user.getUserEmail());
			int a = ps.executeUpdate();
			if (a > 0) {
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public User viewUser(long userId) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from usertable where userId=?");
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserType(rs.getString(1));
				user.setUserId(rs.getLong(2));
				user.setUserName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setUserPhone(rs.getLong(5));
				user.setUserEmail(rs.getString(6));

			}
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<User> viewUser() {
		// TODO Auto-generated method stub
		User user = null;
		List<User> list = new ArrayList<User>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from usertable");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserType(rs.getString(1));
				user.setUserId(rs.getLong(2));
				user.setUserName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setUserPhone(rs.getLong(5));
				user.setUserEmail(rs.getString(6));
				list.add(user);

			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public User updateUser(User user) {
		try {
			user.getUserId();
			PreparedStatement ps = con.prepareStatement(
					"update user set usertype=?,username=?,userpassword=?,userphone=?,useremail=? where userId=?");
			ps.setString(1, user.getUserType());
			ps.setLong(2, user.getUserId());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassword());
			ps.setLong(5, user.getUserPhone());
			ps.setString(6, user.getUserEmail());
			int a = ps.executeUpdate();
			if (a > 0) {
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

	}

	@Override
	public User validateUser(User user) {
		// TODO Auto-generated method stub
		User u = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from usertable where userId=? and userPassword=?");
			ps.setLong(1, user.getUserId());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				u = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5),
						rs.getString(6));
				return u;
			} else {
				return u;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			return u;
		}
	}

	@Override
	public void deleteUser(long userID) {
		
		try {
			PreparedStatement ps = con.prepareStatement
					("delete from usertable where flightid=?");
			ps.setLong(1, userID);
				int rowsAffected = ps.executeUpdate();
				System.out.println(String.format("Row affected %d", rowsAffected));
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
