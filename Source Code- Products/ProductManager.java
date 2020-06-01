package product;

import java.util.ArrayList;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductManager {
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("deprecation")
	public ProductManager() throws Exception{
		sessionFactory = new Configuration()
				.configure()
				.buildSessionFactory();
	}
	public int addProduct(int productCode, String productName, String type,int quantity, String salesPerson, double weight, double price) {
		Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
				Product myProduct = new Product();
					myProduct.setProductCode(productCode);
					myProduct.setProductName(productName);
					myProduct.setType(type);
					myProduct.setQuantity(quantity);
					myProduct.setSalesPerson(salesPerson);
					myProduct.setWeight(weight);
					myProduct.setPrice(price);
				int productID = (Integer)session.save(myProduct);
		tx.commit();
	session.close();
	return productID;
					
	}
	public void updateProduct(int productCode, String productName, String type,int quantity, String salesPerson, double weight, double price) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
			Product myProduct = new Product();
				myProduct.setProductCode(productCode);
				myProduct.setProductName(productName);
				myProduct.setType(type);
				myProduct.setQuantity(quantity);
				myProduct.setSalesPerson(salesPerson);
				myProduct.setWeight(weight);
				myProduct.setPrice(price);
			session.update(myProduct);
	tx.commit();
session.close();
	}
public Product findProduct(int productCode) {
	Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
			
				Product myProduct = (Product)session.get(Product.class, productCode);
				tx.commit();
				session.close();
				return myProduct;
			
			
}
public void deleteProduct(int productCode) {
	Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "delete from Product where productCode = :productCode" ;
		Query query = session.createSQLQuery(sql);
		query.setInteger("productCode", productCode);
		query.executeUpdate();
		tx.commit();
	session.close();
}

@SuppressWarnings("unchecked")
public ArrayList<Product> getAllProducts(){
	Session session= sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
			ArrayList<Product> allProducts = (ArrayList<Product>) session.createQuery("from Product").list();
		tx.commit();
	session.close();
	return allProducts;
}

public Product getProducts(int productCode) {
	Product p = null;
	Session session= sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
			String hql = "from Product where productCode = :productCode" ;
			Query query = session.createQuery(hql);
			query.setInteger("productCode", productCode);
			p = (Product) query.uniqueResult();

				
		tx.commit();
	session.close();
	return p;
	
}
}
