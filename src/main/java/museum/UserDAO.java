package museum;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static final String SELECT_USER_LOGIN = "SELECT * FROM users WHERE email = ?AND password = ?";
	//login
	public static User login(User user) throws SQLException, NoSuchAlgorithmException{
	//convert the password to MD5
	MessageDigest md = MessageDigest.getInstance("MD5");
	md.update(user.getPassword().getBytes());
	byte byteData[] = md.digest();
	//convert the byte to hex format
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < byteData.length; i++) {
	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100,
	
	16).substring(1));
	}
	try {
	//call getConnection() method
	con = ConnectionManager.getConnection();
	//3. create statement
	ps = con.prepareStatement(SELECT_USER_LOGIN);
	ps.setString(1, user.getEmail());
	ps.setString(2, sb.toString());
	//4. execute query
	rs = ps.executeQuery();
	//process ResultSet
	//if user exists set the isLoggedIn variable to true
	if (rs.next()) {
	user.setUserId(rs.getInt("userId"));
	user.setEmail(rs.getString("email"));
	user.setPassword(rs.getString("password"));
	user.setLoggedIn(true);
	}
	// if user does not exist set the isLoggedIn variable to false
	else{
	user.setLoggedIn(false);
	}
	//5. close connection
	con.close();
	}catch(SQLException e) {
	e.printStackTrace();
	}
	return user;
	}
}
