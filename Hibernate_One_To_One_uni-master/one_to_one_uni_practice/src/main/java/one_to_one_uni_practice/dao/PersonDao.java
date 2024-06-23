package one_to_one_uni_practice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_practice.dto.PanCard;
import one_to_one_uni_practice.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		return entityManager;
		return entityManagerFactory.createEntityManager();
	}

	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		PanCard panCard = person.getPanCard();
		entityManager.persist(panCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		PanCard panCard = person.getPanCard();
		entityManager.merge(panCard);
		entityManager.merge(person);
		entityTransaction.commit();
	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		PanCard panCard = person.getPanCard();
		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(panCard);
			entityManager.remove(person);
			entityTransaction.commit();
		}
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
