package com.Servlet.ServAll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable_In_Database {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String primarykey = "" ;
		int primarykeyCount=0;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##venky", "venky428");

		Statement s = c.createStatement();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Table Name :");
		String tablename = in.readLine();

		String query = "create table " + tablename + "(";

		while(true) {
			
			System.out.println("Enter columnName :");
			String colName= in.readLine();
			System.out.println("Enter columnType:");
			String colType=in.readLine();
			System.out.println("Enter columnSize");
			int columnSize=Integer.parseInt(in.readLine());
			
			query=query+  colName +" "+ colType+   "("+columnSize+")"  ;
			
			System.out.println("colName is PrimaryKey[Yes/No]");
			
			
		  String primaryKeyOption=in.readLine();
		  
		  if(primaryKeyOption.equalsIgnoreCase("yes")) {
			  
			  if(primarykeyCount==0) {
			  
			 primarykey=primarykey+colName;
			
			 primarykeyCount=primarykeyCount+1;
			 
			  }	  else {
				  
				  primarykey=primarykey+colName;	  
			  }
		  }
		  System.out.println("One More Column {YES?NO}");
		  
		  String columnOption=in.readLine();
		  
		  if(columnOption.equalsIgnoreCase("yes")) {
			  
			  
			  query=query+",";
			  continue;
		  }
        
		  else {
			  
			  
			  query=query+ " ," +  "primary key" +  "("+ primarykey+" ));";
			  System.out.println(query);
			  s.executeQuery(query);
			 // System.out.println(primarykey);
			  break;
		  }

		}
		
		
		
		
		
	}

}
