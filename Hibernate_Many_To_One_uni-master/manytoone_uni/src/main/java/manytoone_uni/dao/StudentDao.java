package manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone_uni.dto.School;
import manytoone_uni.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		School school = student.getSchool();
		entityManager.persist(school);
		entityManager.persist(student);
		entityTransaction.commit();
	}

	public void updateStudent(int id, Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student receivedstudent = entityManager.find(Student.class, id);
		if (receivedstudent != null) {
			student.setId(id);
			student.setSchool(receivedstudent.getSchool());
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		} else {
			System.out.println("Student doesn't exist");
		}
	}

	public void deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);

		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
	}

	public Student getStudentById(int id) {
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	public List<Student> getAllStudent() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s");
		List<Student> list = query.getResultList();
		return list;
	}

}
