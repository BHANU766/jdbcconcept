package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcoperation {

	public static void main(String[] args) {
		//database information
		
		String db_url="jdbc:mysql://localhost:3306/";
		String username="root";
		String password="1819";
		
		//establish the connection
		try {
		     Connection conn=DriverManager.getConnection(db_url, username, password);
			
			//validate connection is success
			if(conn!=null) {
				System.out.println(conn);
				System.out.println("the database connection is successful..");				
			}else {
				System.out.println("the database connection is nor successful..");
			}
			
			//create reference to statement ->create,insert
			Statement stmt=conn.createStatement();
			
			//create statement ->create,insert
			String createDB="create database jatjdbc";
			String use="use jatjdbc";
			String createtable="create table stdinfoo(stdcode int,name varchar(9),age int)";
			String insert="insert into stdinfoo values(111, 'chotu' ,1),"+ "(112,'junnu' ,2)";
			String select="select * from stdinfoo";
			
			stmt.execute(createDB);   //create the database
			stmt.execute(use);        //start using that database
		    stmt.execute(createtable);
		    stmt.execute(insert);
		    
		    //resultset
		    ResultSet rs=stmt.executeQuery(select);
		    
		    System.out.println("==================================");
		    
		    while(rs.next()) {
		    	System.out.println(rs.getInt("stdcode")+" "+rs.getString("name")+" "+rs.getInt("age"));
		    }
		    
		    //close the connection object
		    conn.close();
		    	
		
	    }catch (SQLException e) {
	    	e.printStackTrace();
	    }
	    	
	}
	
}    


