package com.Servlet.ServAll;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatement1 {

	
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		BufferedReader buf = null;

		/*
		 * Date d1=new Date(); long time=d1.getTime(); java.sql.Date d2=new
		 * java.sql.Date(time); System.out.println(d2);
		 */

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##venky", "venky428");
			pt = con.prepareStatement("select * from   ");
			pt.setString(1, "driver");
			rs = pt.executeQuery();
			
			System.out.println("DeptNo_____DeptName_______Location");
			
		      while(rs.next()) {
		    	  
		    	     System.out.print(rs.getInt(1));
		    	     System.out.print("       "+rs.getString(2));
		    	     System.out.println("      "+rs.getString(3));
		    	  
		    	  
		      }
			
			System.out.println();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

			} catch (Exception e) {
				System.out.println(e);
			} finally {

			}

		}

	}

}
