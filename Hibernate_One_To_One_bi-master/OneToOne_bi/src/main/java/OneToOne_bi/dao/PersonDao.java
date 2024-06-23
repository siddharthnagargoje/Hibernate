package OneToOne_bi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import OneToOne_bi.dto.AadharCard;
import OneToOne_bi.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// AadharCard aadharCard = person.getAadharCard();

		entityTransaction.begin();
		// entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(int id, Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person receivedperson = entityManager.find(Person.class, id);
		if (receivedperson != null) {
			person.setId(id);
			// AadharCard aadharCard = person.getAadharCard();

			entityTransaction.begin();
			// entityManager.merge(aadharCard);
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
		// AadharCard aadharCard = person.getAadharCard();

		entityTransaction.begin();
		// entityManager.remove(aadharCard);
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
