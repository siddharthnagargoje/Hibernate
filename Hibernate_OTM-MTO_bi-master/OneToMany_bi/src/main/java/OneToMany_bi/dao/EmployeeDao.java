package OneToMany_bi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import OneToMany_bi.dto.Company;
import OneToMany_bi.dto.Employee;

public class EmployeeDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void saveEmployee(int id, Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Company company = entityManager.find(Company.class, id);
		employee.setCompany(company);

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}

	public void updateEmployee(int id, Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Employee receivedemployee = entityManager.find(Employee.class, id);
		if (receivedemployee != null) {
			employee.setId(id);

			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		} else {
			System.out.println("Employee doesn't exists");
		}
	}

	public void deleteEmployee(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Employee employee = entityManager.find(Employee.class, id);

		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
	}

	public Employee getEmployeeById(int id) {
		EntityManager entityManager = getEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	public List<Employee> getAllEmployee() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		List<Employee> list = query.getResultList();
		return list;
	}

}
