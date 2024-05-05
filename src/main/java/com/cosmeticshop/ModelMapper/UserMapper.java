package com.cosmeticshop.ModelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.cosmeticshop.model.User;

public class UserMapper implements RowMapper<User>  {
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setCity(rs.getString("city"));
		user.setEmailid(rs.getString("emailid"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setMobileno(rs.getString("mobileno"));
		user.setPassword(rs.getString("password"));
		user.setPincode(rs.getString("pincode"));
		user.setStreet(rs.getString("street"));
		user.setUsertype(rs.getString("usertype"));
		return user;
		
	}

}
