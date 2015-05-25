package cc.juris.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cc.juris.model.Customer;

public class CustomerDao {

	private EntityManager entityManager;

	public CustomerDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void add(Customer customer){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
			entityManager.getTransaction().commit();	
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public Customer findById(Long id){
		return entityManager.find(Customer.class, id);
	}
	
	public boolean delete(Long id){
		Customer customerFound = new Customer();
		customerFound.setId(id);
		entityManager.remove(customerFound);
		return true;
	}
	
	public Customer update(Customer customer){
		entityManager.merge(customer);
		return customer;
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findAllActive(){
		Query query = entityManager.createQuery("from cc.juris.model.Customer as c where c.active = :active");
		query.setParameter("active", true);

		List<Customer> customers = query.getResultList();
		return customers;
	}
	
	public List<Customer> findCustomersWithActiveProcess(){
		Query query = entityManager.createQuery("select c from cc.juris.model.Customer as c JOIN c.processList as p where p.active = :active");
		query.setParameter("active", true);

		List<Customer> customers = query.getResultList();
		return customers;
	}
}
