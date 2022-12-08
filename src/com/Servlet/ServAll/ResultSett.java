package com.Servlet.ServAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class ResultSett {

	public void driver() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {

			System.out.println(e);

		}
	}

	public void resources() {

		Connection c = null;
		Statement st = null;
		java.sql.ResultSet rs = null;

		try {

			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##venky", "venky428");

			st = c.createStatement();

			rs = st.executeQuery("select * from dept ");

			System.out.println("DEPTNO________DNAME____________LOC");
			System.out.println("________________________________");

			while (rs.next()) {

				System.out.print(" "+rs.getInt(1));
				System.out.print("      " +rs.getString(2) );
				System.out.print("      "+rs.getString(3) );

				System.out.println();

				
			}
		} catch (Exception e) {

			System.out.println(e);
		}

		finally {

			try {
				c.close();
				st.close();
				rs.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ResultSett t = new ResultSett();
		t.driver();
		t.resources();

	}

}
