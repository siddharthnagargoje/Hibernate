package one_to_one_uni_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_dto.AadharCard;
import one_to_one_uni_dto.Person;

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
		AadharCard aadharCard = person.getAadharCard();
		entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		AadharCard aadharCard = person.getAadharCard();
		entityManager.merge(aadharCard);
		entityManager.merge(person);
		entityTransaction.commit();
	}

	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		AadharCard aadharCard=person.getAadharCard();
		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(aadharCard);
			entityManager.remove(person);
			entityTransaction.commit();
		}
	}

	public Person getPersonById(int id) {
		EntityManager entityManager = getEntityManager();
//		Person person = entityManager.find(Person.class, id);
//		return person;
		return entityManager.find(Person.class, id);
	}

	public List<Person> getAllPerson() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT p FROM Person p");
		List<Person> list = query.getResultList();
		return list;
	}

}
