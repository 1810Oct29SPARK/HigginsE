package proj.one.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import proj.one.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		//execute the methods here
		
		
	}
	
	public static void init() {
		
		//try catch(SQLException) catch(IOException) here
		//try will be for connecting to the DB
		//the catches are for just in case the connection fails
		try {
			Connection con = ConnectionUtil.getConnection("connections.properties");
			System.out.println(con);
		} catch(SQLException e){
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
