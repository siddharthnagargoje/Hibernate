package many_to_one_uni_prc_day2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni_prc_day2.dto.School;
import many_to_one_uni_prc_day2.dto.Student;

public class StudentDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveStudent(int id, Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		School school = entityManager.find(School.class, id);
		student.setSchool(school);

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("Saved successful");
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
			System.out.println("Update successful");
		} else {
			System.out.println("Student doesn't exists");
		}
	}

	public void deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);

		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		System.out.println("Delete successful");
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
