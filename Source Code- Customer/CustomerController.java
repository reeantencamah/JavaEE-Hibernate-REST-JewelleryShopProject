package org.jewellery3;

import java.util.List;

/*import java.sql.SQLException;
import java.util.ArrayList;*/
import javax.annotation.ManagedBean;


@ManagedBean
public class CustomerController {
	static CustomerClient cm = new CustomerClient();
	 private List<Customer> customers;
	 private Customer cust;
	
	public String PostCustomer(Customer client) {
		CustomerClient.addCustomer(client);
		return "viewAllCustomer.xhtml";

	}

 
	public List<Customer> getCustomers() {
		this.customers=CustomerClient.GetListCustomers();
		return customers ;
	}
public String deleteCustomer(int id) {
	CustomerClient.DeleteCustomer(id);
	return "viewAllCustomer.xhtml";
}


public String updateCustomer(Customer cus) {
	CustomerClient.PutCustomer(cus);
	return "viewAllCustomer.xhtml";
	
}
public String editCustomer(Customer cus) {
	this.cust=cus;
	return "editCustomer.xhtml";
}

/**
 * @return the cust
 */
public Customer getCust() {
	return cust;
}


/**
 * @param cust the cust to set
 */
public void setCust(Customer cust) {
	this.cust = cust;
}


}
