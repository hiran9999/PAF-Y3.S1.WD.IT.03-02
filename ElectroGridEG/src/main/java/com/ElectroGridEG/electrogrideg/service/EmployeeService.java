package com.ElectroGridEG.electrogrideg.service;


import com.ElectroGridEG.electrogrideg.dao.EmployeeDAO;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@Path("Employee")
public class EmployeeService
{
EmployeeDAO employeeObj = new EmployeeDAO();
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readItems()
   {
        return employeeObj.readItems();
   }


		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertItem(@FormParam("no") String no,
		 @FormParam("name") String name,
		 @FormParam("position") String position,
		 @FormParam("email") String email,
		 @FormParam("phone") int phone)
	{	
		 String output = employeeObj.insertItem(no, name, position, email,phone);
		return output;
    }  
		
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateItem(String employeeData)
		{
		//Convert the input string to a JSON object
		 JsonObject employeeObject = new JsonParser().parse(employeeData).getAsJsonObject();
		//Read the values from the JSON object
		 String Empid = employeeObject.get("id").getAsString();
		 String Empno = employeeObject.get("no").getAsString();
		 String Empname = employeeObject.get("name").getAsString();
		 String position = employeeObject.get("position").getAsString();
		 String email = employeeObject.get("email").getAsString();
		 String phone = employeeObject.get("phone").getAsString();
		 
		 String output = employeeObj.updateItem(Empid, Empno, Empname, position, email, phone);
		return output;
		}

 }