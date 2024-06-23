package manytomany_uni_task.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_uni_task.dto.Language;
import manytomany_uni_task.dto.Person;

public class PersonMain {

	public static void main(String[] args) {

		Language l1 = new Language();
		l1.setId(101);
		l1.setName("Kannada");
		l1.setOrigin("Karnataka");
		l1.setCountry("India");

		Language l2 = new Language();
		l2.setId(102);
		l2.setName("English");
		l2.setOrigin("London");
		l2.setCountry("England");

		Language l3 = new Language();
		l3.setId(103);
		l3.setName("Persian");
		l3.setOrigin("Iran");
		l3.setCountry("Iran");

		Person p1 = new Person();
		p1.setId(1);
		p1.setName("Raj");
		p1.setAddress("BLR");
		p1.setPhone(9122);

		Person p2 = new Person();
		p2.setId(2);
		p2.setName("Ram");
		p2.setAddress("MYS");
		p2.setPhone(8197);

		Person p3 = new Person();
		p3.setId(3);
		p3.setName("Ravi");
		p3.setAddress("DVG");
		p3.setPhone(7314);

		List<Language> list1 = new ArrayList<Language>();
		list1.add(l1);
		list1.add(l2);

		p1.setList(list1);

		List<Language> list2 = new ArrayList<Language>();
		list2.addAll(list1);
		list2.add(l3);

		p2.setList(list2);

		List<Language> list3 = new ArrayList<Language>();
		list3.add(l2);
		list3.add(l3);

		p3.setList(list3);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(l1);
		entityManager.persist(l2);
		entityManager.persist(l3);
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		entityTransaction.commit();

	}

}
