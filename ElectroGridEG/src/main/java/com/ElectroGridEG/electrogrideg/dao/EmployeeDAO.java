package com.ElectroGridEG.electrogrideg.dao;

import java.sql.*;
public class EmployeeDAO
	{    //A common method to connect to the DB
	     private Connection connect()
       {
			 Connection con = null;
			 try
			 {
			 Class.forName("com.mysql.jdbc.Driver");
			
			 //Provide the correct details: DBServer/DBName, username, password
			 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid", "root", "");
			 }
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
	 }
	public String insertItem(String no, String name, String position, String email, int phone)
	 {
		 String output = "";
		 try
		 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for inserting."; }
				 // create a prepared statement
				 String query = " insert into employee (`id`,`empNo`,`empName`,`position`,`email`,`phone`)"
				 + " values (?, ?, ?, ?, ?)";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setInt(1, 0);
				 preparedStmt.setString(2, no);
				 preparedStmt.setString(3, name);
				 preparedStmt.setString(2, position);
				 preparedStmt.setString(4, email);
				 preparedStmt.setInt(5, phone);
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
				 output = "Inserted successfully";
				 }
				 catch (Exception e)
				 {
				 output = "Error while inserting the employee.";
				 System.err.println(e.getMessage());
				 }
				 return output;
   }
	public String readItems()
   {
		 String output = "";
		 try
		 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for reading."; }
				 // Prepare the html table to be displayed
				 output = "<table border='1'><tr><th>Emp No</th><th>Emp Name</th>" +
				 "<th>Emp position</th>" +
				 "<th>Email</th>" +
				 "<th>Phone</th>" +
				 "<th>Update</th><th>Remove</th></tr>";
				
				 String query = "select * from employee";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 // iterate through the rows in the result set
				 while (rs.next())
				 {
				 String id = Integer.toString(rs.getInt("id"));
				 String empNo = rs.getString("empNo");
				 String empName = rs.getString("empName");
				 String position =rs.getString("position");
				 String email = rs.getString("email");
				 int phone = rs.getInt("phone");
				 // Add into the html table
				 output += "<tr><td>" + empNo + "</td>";
				 output += "<td>" + empName + "</td>";
				 output += "<td>" + position + "</td>";
				 output += "<td>" + email + "</td>";
				 output += "<td>" + phone + "</td>";
				 // buttons
				 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
				 + "<td><form method='post' action='items.jsp'>"
				 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
				 + "<input name='id' type='hidden' value='" + id
				 + "'>" + "</form></td></tr>";
			 }
			 con.close();
			 // Complete the html table
			 output += "</table>";
		 }
		 catch (Exception e)
		 {
		 output = "Error while reading the items.";
		 System.err.println(e.getMessage());
		 }
	 return output;
 }
public String updateItem(String ID,String no, String name, String position, String email, int phone)
 
  {
		 String output = "";
		 try
		 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for updating."; }
				 // create a prepared statement
				 String query = "UPDATE employee SET itemCode=?,itemName=?,itemPrice=?,itemDesc=? WHERE itemID=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setString(2, no);
				 preparedStmt.setString(3, name);
				 preparedStmt.setString(2, position);
				 preparedStmt.setString(4, email);
				 preparedStmt.setInt(5, phone);
				 preparedStmt.setInt(5, Integer.parseInt(ID));
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
				 output = "Updated successfully";
				 }
				 catch (Exception e)
				 {
				 output = "Error while updating the employee.";
				 System.err.println(e.getMessage());
				 }
					 return output;
	 }
	public String deleteItem(String id)
	 {
		 String output = "";
		 try
		 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for deleting."; }
				 // create a prepared statement
				 String query = "delete from employee where id=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(id));
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
				 output = "Deleted successfully";
				 }
				 catch (Exception e)
				 {
				 output = "Error while deleting the employee.";
				 System.err.println(e.getMessage());
				 }
				 return output;
        }
} 