package com.cosmeticshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cosmeticshop.ModelMapper.UserMapper;
import com.cosmeticshop.model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createUserTable() {

		String query = "CREATE TABLE IF NOT EXISTS USER(id int primary key auto_increment,city varchar(255), emailid varchar(255), firstname varchar(255), lastname varchar(255), mobileno varchar(255), password varchar(255), pincode varchar(255),street varchar(255),usertype varchar(255))";
		this.jdbcTemplate.update(query);
		System.out.println("create table user query executed");
	}

	public int save(User user) {

		String query = "INSERT INTO USER (city, emailid, firstname, lastname, mobileno, password, pincode,street,usertype) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

		int update = this.jdbcTemplate.update(query,
				new Object[] { user.getCity(), user.getEmailid(), user.getFirstname(), user.getLastname(),
						user.getMobileno(), user.getPassword(), user.getPincode(), user.getStreet(), "user" });
		return update;
	}
	
	
	public boolean getUserByEmailId(String emailid)
	{
		
		String query="select count(*) from user where emailid="+emailid;
		int update=this.jdbcTemplate.update(query,emailid);
		if(update==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public User getUserByEmailIdAndPassword(String emailid, String password) {

		String query = "select * from User where emailid='" + emailid + "' and password='" + password + "'";
		List<User> users = this.jdbcTemplate.query(query, new UserMapper());
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}

public User getUserByEmailIdAndPhone(String emailid, String phoneNo) {

String query = "select * from User where emailid='"+emailid+"' and mobileno='"+phoneNo+"'";
List<User> users = new ArrayList<>();
users = this.jdbcTemplate.query(query, new UserMapper());
if(users.isEmpty()) {
return null;
}

else {
return users.get(0);
}
}

	public List<User> getAllUser() {

		String query = "select * from User";
		List<User> users = new ArrayList<>();
		users = this.jdbcTemplate.query(query, new UserMapper());
		return users;
	}

	public User getUserById(int userId) {

		String query = "select * from User where Id=" + userId;
		List<User> users = new ArrayList<>();
		users = this.jdbcTemplate.query(query, new UserMapper());

		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}
	public int saveUpdate(String emailid, String phoneNo, String password) {

		String query = "UPDATE User SET password = ? WHERE emailid = ? AND mobileno = ?";

		return jdbcTemplate.update(query, password, emailid, phoneNo);

		}
	public boolean isEmailExists(String email) {

		String query = "SELECT COUNT(*) FROM user WHERE emailid = ?";


		int count = jdbcTemplate.queryForObject(query, Integer.class, email);



		return count > 0;

	}
}