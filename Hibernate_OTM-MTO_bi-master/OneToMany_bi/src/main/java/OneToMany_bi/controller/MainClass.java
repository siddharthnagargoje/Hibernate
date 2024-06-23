package OneToMany_bi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OneToMany_bi.dto.Company;
import OneToMany_bi.dto.Employee;

public class MainClass {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("Ram");
		e1.setPhone(731);

		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("Rahul");
		e2.setPhone(891);

		Employee e3 = new Employee();
		e3.setId(3);
		e3.setName("Shyam");
		e3.setPhone(9246);

		Company company = new Company();
		company.setId(1001);
		company.setName("TY");
		company.setGst("XYZ123");

		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		company.setList(list);

		e1.setCompany(company);
		e2.setCompany(company);
		e3.setCompany(company);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(company);
		entityManager.persist(e1);
		entityManager.persist(e2);
		entityManager.persist(e3);
		entityTransaction.commit();
	}

}
