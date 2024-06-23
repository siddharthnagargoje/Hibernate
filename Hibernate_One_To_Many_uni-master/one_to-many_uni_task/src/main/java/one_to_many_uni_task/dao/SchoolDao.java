package one_to_many_uni_task.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_uni_task.dto.School;
import one_to_many_uni_task.dto.Student;

public class SchoolDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveSchool(School school) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		List<Student> list = school.getList();
		for (Student student : list) {
			entityManager.persist(student);
		}
		entityManager.persist(school);
		entityTransaction.commit();
		System.out.println("Saved successful");
	}

	public void updateSchool(int id, School school) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		School receivedschool = entityManager.find(School.class, id);
		if (receivedschool != null) {
			school.setId(id);
			school.setList(receivedschool.getList());
			entityTransaction.begin();
			entityManager.merge(school);
			entityTransaction.commit();
		} else {
			System.out.println("School doesn't exists");
		}
	}

	public void deleteSchool(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		School school = entityManager.find(School.class, id);

		entityTransaction.begin();
		entityManager.remove(school);
		entityTransaction.commit();
		System.out.println("Deleted Successful");
	}

	public School getSchoolById(int id) {
		EntityManager entityManager = getEntityManager();
		School school = entityManager.find(School.class, id);
		return school;
	}

	public List<School> getAllSchool() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM School s");
		List<School> list = query.getResultList();
		return list;
	}

}
