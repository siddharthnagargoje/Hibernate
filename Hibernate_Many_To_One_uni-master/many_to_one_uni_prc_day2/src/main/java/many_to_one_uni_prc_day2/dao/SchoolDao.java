package many_to_one_uni_prc_day2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni_prc_day2.dto.School;

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
			entityTransaction.begin();
			entityManager.merge(school);
			entityTransaction.commit();
			System.out.println("Update Successful");
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
		System.out.println("Delete Successful");
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
