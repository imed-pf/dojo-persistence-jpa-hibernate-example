package cc.juris.schema;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cc.juris.dao.CustomerDao;
import cc.juris.model.Customer;

public class GenerateSchema {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpademo");
		
		EntityManager entityManager = factory.createEntityManager();
		
		CustomerDao customerDao = new CustomerDao(entityManager);
		Customer customerFound = customerDao.findById(1L);
		System.out.println(customerFound.getName());
		
		List<Customer> customers = customerDao.findCustomersWithActiveProcess();
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		
		factory.close();
	}
}
