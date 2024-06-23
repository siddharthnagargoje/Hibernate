package OneToOne_bi_task.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import OneToOne_bi_task.dto.PanCard;
import OneToOne_bi_task.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// PanCard panCard = person.getPanCard();

		entityTransaction.begin();
		// entityManager.persist(panCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person receivedperson = entityManager.find(Person.class, id);
		if (receivedperson != null) {
			person.setId(id);
			// PanCard panCard = person.getPanCard();

			entityTransaction.begin();
			// entityManager.merge(panCard);
			entityManager.merge(person);
			entityTransaction.commit();
		} else {
			System.out.println("Person doesn't exists");
		}
	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = entityManager.find(Person.class, id);
		// PanCard panCard = person.getPanCard();

		entityTransaction.begin();
		// entityManager.remove(panCard);
		entityManager.remove(person);
		entityTransaction.commit();
	}

	public Person getPersonById(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class, id);
		return person;
	}

	public List<Person> getAllPerson() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT p FROM Person p");
		List<Person> list = query.getResultList();
		return list;
	}

}
