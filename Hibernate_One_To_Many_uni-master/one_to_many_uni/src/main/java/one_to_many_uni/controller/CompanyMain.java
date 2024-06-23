package one_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_uni.dao.CompanyDao;
import one_to_many_uni.dto.Company;
import one_to_many_uni.dto.Employee;

public class CompanyMain {

	public static void main(String[] args) {

		// 1st
//		Employee e1 = new Employee();
//		e1.setName("Raj");
//		e1.setAddress("Banglore");
//		e1.setPhone(819456252);
//
//		Employee e2 = new Employee();
//		e2.setName("Suresh");
//		e2.setAddress("Chennai");
//		e2.setPhone(878764361);
//
//		Employee e3 = new Employee();
//		e3.setName("Raju");
//		e3.setAddress("Mumbai");
//		e3.setPhone(789456123);
//
//		Company company = new Company();
//		company.setName("TY");
//		company.setGst("XYZ123");
//
//		List<Employee> list = new ArrayList<Employee>();
//		list.add(e1);
//		list.add(e2);
//		list.add(e3);
//
//		company.setList(list);
//
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		entityTransaction.begin();
//		entityManager.persist(e1);
//		entityManager.persist(e2);
//		entityManager.persist(e3);
//		entityManager.persist(company);
//		entityTransaction.commit();

		// 2nd
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//		Company company = entityManager.find(Company.class, 1);
//		System.out.println(company);

		// 3rd
//		CompanyDao dao = new CompanyDao();
//
//		Company company = new Company();
//		company.setName("TestYantra PVT LTD");
//		company.setGst("XYZ1234");
//
//		dao.updateCompany(2, company);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		entityManager.find(Company.class, 1);
		entityManager.find(Company.class, 1);
		entityManager2.find(Company.class, 1);
		entityManager2.find(Company.class, 1);
	}

}
