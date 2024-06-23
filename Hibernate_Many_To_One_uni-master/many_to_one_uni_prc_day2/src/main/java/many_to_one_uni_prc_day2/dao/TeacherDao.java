package many_to_one_uni_prc_day2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni_prc_day2.dto.School;
import many_to_one_uni_prc_day2.dto.Teacher;

public class TeacherDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveTeacher(int id, Teacher teacher) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		School school = entityManager.find(School.class, id);
		teacher.setSchool(school);

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		System.out.println("Saved successful");
	}

	public void updateTeacher(int id, Teacher teacher) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher receivedteacher = entityManager.find(Teacher.class, id);
		if (receivedteacher != null) {
			teacher.setId(id);
			teacher.setSchool(receivedteacher.getSchool());
			entityTransaction.begin();
			entityManager.merge(teacher);
			entityTransaction.commit();
			System.out.println("Update Successful");
		} else {
			System.out.println("Teacher doesn't exists");
		}
	}

	public void deleteTeacher(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher teacher = entityManager.find(Teacher.class, id);

		entityTransaction.begin();
		entityManager.remove(teacher);
		entityTransaction.commit();
	}

	public Teacher getTeacherById(int id) {
		EntityManager entityManager = getEntityManager();
		Teacher teacher = entityManager.find(Teacher.class, id);
		return teacher;
	}

	public List<Teacher> getAllTeacher() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT t FROM Teacher t");
		List<Teacher> list = query.getResultList();
		return list;
	}

}
