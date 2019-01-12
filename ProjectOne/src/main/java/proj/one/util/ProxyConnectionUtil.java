package proj.one.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ProxyConnectionUtil {
		
	/**
	 * Ok, so here, I would like to change from connecting to my DB using a connection.properties file
	 *  to connecting using the environment variables
	 *  
	 */
	
//	String filename = "connection.properties";
//	filename = getResource(String rsc);
//	
//	String url = System.getenv(DB_URL);
//	public static String getResource("connection.properties");
}
//	public static Connection getConnection() throws SQLException, IOException {
//		String url = System.getenv("DB_URL");
//		String username = System.getenv("DB_USERNAME");
//		String password = System.getenv("DB_PASSWORD");
//		String port = System.getenv("DB_PORT");
//		String database = System.getenv("DB_NAME");
//		
//		return DriverManager.getConnection(url, username, password);
		
//	public static Connection getConnection(String filename) throws SQLException, IOException {
//		filename = getResource(String rsc);
//		static String getResource(String rsc) {
//		    String val = "";
//
//		    try {
//		       Class cls = Class.forName("connection.properties");
//		       filename = rsc;
//
//		       // returns the ClassLoader object associated with this Class
//		       ClassLoader cLoader = cls.getClassLoader();
//		       
//		       // input stream
//		       InputStream i = cLoader.getResourceAsStream(rsc);
//		       BufferedReader r = new BufferedReader(new InputStreamReader(i));
//
//		       // reads each line
//		       String l;
//		       while((l = r.readLine()) != null) {
//		          val = val + l;
//		       } 
//		       i.close();
//		    } catch(Exception e) {
//		       System.out.println(e);
//		    }
//		    return val;

//		Properties prop = new Properties();
//		InputStream i = new FileInputStream(filename);
//		prop.load(i);
//		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
//	}
	
	//class object, replace the second half of the InputStream in line of code (line 15)
	//probably WEB-INF

//	public static String getResource(String rsc) {
//		String val = "";
//		
//		try {
//			Class c = Class.forName("ClassLoaderDemo");
//			ClassLoader cloader = c.getClassLoader();
//			InputStream in = cLoader.getResourceAsStream(rsc);
//			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
//			
//		}
//	}
	


//static String getResource(String rsc) {
//    String val = "";
//
//    try {
//       Class cls = Class.forName("ClassLoaderDemo");
//
//       // returns the ClassLoader object associated with this Class
//       ClassLoader cLoader = cls.getClassLoader();
//       
//       // input stream
//       InputStream i = cLoader.getResourceAsStream(rsc);
//       BufferedReader r = new BufferedReader(new InputStreamReader(i));
//
//       // reads each line
//       String l;
//       while((l = r.readLine()) != null) {
//          val = val + l;
//       } 
//       i.close();
//    } catch(Exception e) {
//       System.out.println(e);
//    }
//    return val;
// }
//  
// public static void main(String[] args) {
//
//   System.out.println("File1: " + getResource("file.txt"));
//   System.out.println("File2: " + getResource("test.txt"));                
// }
