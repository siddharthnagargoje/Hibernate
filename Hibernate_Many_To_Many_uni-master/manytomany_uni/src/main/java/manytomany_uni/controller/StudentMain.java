package manytomany_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_uni.dto.Course;
import manytomany_uni.dto.Student;

public class StudentMain {

	public static void main(String[] args) {

		Course c1 = new Course();
		c1.setId(1001);
		c1.setName("Java");
		c1.setFees(10000);
		c1.setDuration(2);

		Course c2 = new Course();
		c2.setId(1002);
		c2.setName("Adv Java");
		c2.setFees(10500);
		c2.setDuration(1);

		Course c3 = new Course();
		c3.setId(1003);
		c3.setName("SQL");
		c3.setFees(5000);
		c3.setDuration(1);

		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Vinod");
		s1.setAddress("BLR");
		s1.setPhone(8197);

		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Raj");
		s2.setAddress("BLR");
		s2.setPhone(9122);

		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Rakesh");
		s3.setAddress("CHN");
		s3.setPhone(9731);

		List<Course> list1 = new ArrayList<Course>();
		list1.add(c1);
		list1.add(c2);

		s1.setList(list1);

		List<Course> list2 = new ArrayList<Course>();
		list2.addAll(list1);
		list2.add(c3);

		s2.setList(list2);

		List<Course> list3 = new ArrayList<Course>();
		list3.add(c2);
		list3.add(c3);

		s3.setList(list3);

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
