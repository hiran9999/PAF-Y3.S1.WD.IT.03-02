package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Bill;
//service
@Path("/Bill")
public class BillService {
	
	
		Bill Obj = new Bill();

		@GET
	    @Path("/")
	    @Produces(MediaType.TEXT_HTML)
		public String readBill(){
	 
			return Obj.readBill();
	 
		}
		
		@POST
		@Path("/") 
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertBill(@FormParam("BillId") String BillId,@FormParam("CustomerName") String CustomerName,@FormParam("MobileNumber") String MobileNumber,@FormParam("Amount") String Amount,@FormParam("PaymentMethod") String PaymentMethod) {
			String output = Obj.insertBill(BillId, CustomerName, MobileNumber, Amount, PaymentMethod);
			return output;
		}
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateBill(String PaymentData)
		{
		//Convert the input string to a JSON object
		 JsonObject Object = new JsonParser().parse(BillData).getAsJsonObject();
		//Read the values from the JSON object
		//ID BillId CustomerName MobileNumber Amount PaymentMethod
		 String ID = Object.get("ID").getAsString();
		 String BillId = Object.get("BillId").getAsString();
		 String CustomerName = Object.get("CustomerName").getAsString();
		 String MobileNumber = Object.get("MobileNumber").getAsString();
		 String Amount = Object.get("Amount").getAsString();
		 String PaymentMethod = Object.get("PaymentMethod").getAsString();
		 String output = Obj.updateBill(ID, BillId, CustomerName, MobileNumber, Amount, PaymentMethod);
		
		 return output;
		}
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteBill(String BillData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(PaymentData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		 String ID = doc.select("ID").text();
		 String output = Obj.deleteBill(ID);
		return output;
		}


}