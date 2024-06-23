package manytoone_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dto.School;
import manytoone_uni.dto.Student;

public class StudentMain {

	public static void main(String[] args) {

		School school = new School();
		school.setName("DPS");
		school.setFees(10000);
		school.setLocation("BLR");

		Student s1 = new Student();
		s1.setName("Dimple");
		s1.setAddress("BLR");
		s1.setSchool(school);

		Student s2 = new Student();
		s2.setName("Pinky");
		s2.setAddress("BLR");
		s2.setSchool(school);

		Student s3 = new Student();
		s3.setName("Ramu");
		s3.setAddress("BLR");
		s3.setSchool(school);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(school);
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);

		entityTransaction.commit();
	}

}
