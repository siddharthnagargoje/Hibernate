package ManyToMany_bi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ManyToMany_bi.dto.Course;
import ManyToMany_bi.dto.Student;

public class MainClass {

	public static void main(String[] args) {

		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Raju");
		s1.setPhone(91236574);

		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Rajesh");
		s2.setPhone(741852963);

		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Ramu");
		s3.setPhone(852741963);

		Course c1 = new Course();
		c1.setId(101);
		c1.setName("JAVA");
		c1.setDuration("2");

		Course c2 = new Course();
		c2.setId(102);
		c2.setName("ADV JAVA");
		c2.setDuration("1.5");

		Course c3 = new Course();
		c3.setId(103);
		c3.setName("SQL");
		c3.setDuration("1");

		List<Course> cl1 = new ArrayList<Course>();
		cl1.add(c1);
		cl1.add(c2);

		List<Course> cl2 = new ArrayList<Course>();
		cl2.addAll(cl1);
		cl2.add(c3);

		List<Student> sl1 = new ArrayList<Student>();
		sl1.add(s1);
		sl1.add(s2);
		sl1.add(s3);

		List<Student> sl2 = new ArrayList<Student>();
		sl2.add(s3);

		c1.setList(sl1);
		c2.setList(sl1);
		c3.setList(sl2);

		s1.setList(cl1);
		s2.setList(cl1);
		s3.setList(cl2);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);

		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);

		entityTransaction.commit();

	}

}
