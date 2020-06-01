package product;

import java.util.ArrayList;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ProductController {
	private int productCode;
	private String productName;
	private String type;
	private int quantity;
	private String salesPerson;
	private double weight;
	private double price;
	private String productCodeTest;
	
	public String getProductCodeTest() {
		return productCodeTest;
	}
	public void setProductCodeTest(String productCodeTest) {
		this.productCodeTest = productCodeTest;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String addProduct() throws Exception {
		
	try{
			ProductManager pMgr = new ProductManager();
		pMgr.addProduct(productCode, productName, type, quantity, salesPerson, weight, price);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
	}
	catch(Exception e) {
		System.out.println("Product not found");
		e.printStackTrace();
		
	}
		return "add";
	}
	public String updateProduct() throws Exception{
		try{
			ProductManager pMgr = new ProductManager();
			pMgr.updateProduct(productCode, productName, type, quantity, salesPerson, weight, price);
		}
		catch(Exception e) {
			System.out.println("Product not found");
			e.printStackTrace();
		}
		return "update";
	}
	public String deleteProduct() throws Exception{
		try{
		ProductManager pMgr = new ProductManager();
		pMgr.deleteProduct(productCode);
		}
		catch(Exception e) {
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Integer.toString(p.getProductCode()), redirect));
			
			System.out.println("Product not found");
			e.printStackTrace();
			
		}
		return "Delete product";
	}
	public String findProduct() throws Exception{
	try{
		ProductManager pMgr = new ProductManager();
		Product myProduct = pMgr.findProduct(productCode);
		productName = myProduct.getProductName();
		type = myProduct.getType();
		quantity = myProduct.getQuantity();
		salesPerson = myProduct.getSalesPerson();
		weight  = myProduct.getWeight();
		price = myProduct.getPrice();
	
	}
	catch(Exception e) {
		System.out.println("Product not found");
		e.printStackTrace();
		
	}	
	return "find";
	}
	public ArrayList<Product> getAllProducts() throws Exception{
		ProductManager pMgr = new ProductManager();
		return pMgr.getAllProducts();
	}
	public String getProduct() throws Exception{
	try{
		String redirect = "";
		
		ProductManager pMgr = new ProductManager();
		Product p = pMgr.getProducts(productCode);		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Integer.toString(p.getProductCode()), redirect));
		setProductCodeTest(Integer.toString(p.getProductCode()));	
		setProductName(p.getProductName());
		setSalesPerson(p.getSalesPerson());
		setType(p.getType());
		setWeight(p.getWeight());
		setPrice(p.getPrice());
		setQuantity(p.getQuantity());
	}
	catch(Exception e) {
		System.out.println("Product not found");
		e.printStackTrace();
		
	}
		return "getProduct";	
	}
	public void reset() throws Exception{
		setProductCode(0);
		setProductName(null);
		setSalesPerson(null);
		setType(null);
		setWeight(0);
		setPrice(0);
		setQuantity(0);
	}
//	@SuppressWarnings("unchecked")
//	public List<Product> getProducts() throws Exception{
//		ProductManager pMgr = new ProductManager();
//		List<Product> list = (List<Product>) pMgr.getProducts(productCode, productName);
//		return list;
//	}
}
