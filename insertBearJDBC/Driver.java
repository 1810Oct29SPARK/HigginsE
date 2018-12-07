package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.BearDAO;
import com.revature.dao.BearDAOImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		// init();
		BearDAO bd = new BearDAOImpl();
		/*
		 * List<Bear> bears = bd.getBears(); for (Bear b : bears) {
		 * System.out.println(b); }
		 */
		// get single bear
		//System.out.println(bd.getBearById(1020));
		// feed bear
		//System.out.println(bd.feedBear(53, 2, 10));
		bd.insertBear(999, "Moby", "11-NOV-95", 200, 2, 2);
		//System.out.println(bd);
	}

	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}