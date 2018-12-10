package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException
	{
		String url="jdbc:oracle:thin:@jonathansniderdb.cv4hgm4augm0.us-east-2.rds.amazonaws.com:1521:orcl";
		String user="JonathanSnider";
		String pass="billychicken";
		return DriverManager.getConnection(url,user,pass);
	}
	
	public static Connection getConnection(String filename) throws SQLException, IOException
	{
		Properties prop=new Properties();
		InputStream in=new FileInputStream(filename);
		prop.load(in);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),prop.getProperty("password"));
	}
}
