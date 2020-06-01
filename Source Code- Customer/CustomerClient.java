package org.jewellery3;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CustomerClient {
	static Client client = ClientBuilder.newClient();
	static String URL="http://localhost:8080/Jewellery/webapi/customer/";
	
	
	public static Customer GetSingleCustomer(int id) {
		Customer cus = client
				.target(URL)
				.path("{customerID}")
				.resolveTemplate("customerID",id)
				.request(MediaType.APPLICATION_JSON)
				.get(Customer.class);
		System.out.println("Test get a single entity customer \n "+cus.getId()+ cus.getLname());
		return cus;
	}


	public static List<Customer> GetListCustomers() {
		List<Customer> cuss = client.target(URL)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Customer>>() {});
		return cuss;
	}
	
	public static void addCustomer(Customer cus) {
		Response response= client
				.target(URL)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(cus,MediaType.APPLICATION_JSON));
		System.out.println("\nTEST POST Customer \n"+ response);
		
	}
	public static void PutCustomer(Customer cus) {
		Response response= client
				.target(URL)
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(cus,MediaType.APPLICATION_JSON));
		System.out.println("\nTEST PuT Customer \n"+ response);
		
	}
	public static void DeleteCustomer(int id) {
		Response response= client
				.target(URL)
				.path("{customerID}")
				.resolveTemplate("customerID",id)
				.request(MediaType.APPLICATION_JSON)
				.delete();
		System.out.println("\nTEST Delete Customer \n"+ response);
		
	}

}
