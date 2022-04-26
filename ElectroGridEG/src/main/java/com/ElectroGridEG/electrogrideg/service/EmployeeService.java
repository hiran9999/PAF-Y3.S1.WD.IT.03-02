package com.ElectroGridEG.electrogrideg.service;


import com.ElectroGridEG.electrogrideg.dao.EmployeeDAO;
import com.ElectroGridEG.electrogrideg.model.Employee;
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
		public String readEmp()
   {
        return employeeObj.readEmp();
   }


		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertEmp(@FormParam("empNo") String empNo,
		 @FormParam("empName") String empName,
		 @FormParam("position") String position,
		 @FormParam("email") String email,
		 @FormParam("phone") int phone)
	{	
			
		Employee employee =  new Employee( empNo, empName, position, email, phone);
		String output = employeeObj.insertEmp (employee);
		return output;
    }  
		
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateEmp(String employeeData)
		{
		//Convert the input string to a JSON object
		 JsonObject employeeObject = new JsonParser().parse(employeeData).getAsJsonObject();
		//Read the values from the JSON object
		 int id = employeeObject.get("id").getAsInt();
		 String empNo = employeeObject.get("empNo").getAsString();
		 String empName = employeeObject.get("empName").getAsString();
		 String position = employeeObject.get("position").getAsString();
		 String email = employeeObject.get("email").getAsString();
		 int phone = employeeObject.get("phone").getAsInt();
		
		 Employee employee =  new Employee( id, empNo, empName, position, email, phone);
		 String output = employeeObj.updateEmp(employee);
		 return output;
	}
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteEmp(String employeeData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(employeeData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		 String id = doc.select("id").text();
		 String output = employeeObj.deleteEmp(id);
		return output;
		}


 }