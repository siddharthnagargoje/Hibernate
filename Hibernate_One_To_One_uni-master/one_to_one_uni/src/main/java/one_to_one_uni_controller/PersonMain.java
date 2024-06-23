package one_to_one_uni_controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_uni_dto.AadharCard;
import one_to_one_uni_dto.Person;

public class PersonMain {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		AadharCard aadharCard = new AadharCard();
		aadharCard.setAid(101);
		aadharCard.setName("Dimple");
		aadharCard.setAddress("Banglore");

		Person person = new Person();
		person.setId(1);
		person.setName("Dimple.S");
		person.setPhone(9546566612l);
		person.setAddress("India");
		person.setAadharCard(aadharCard);

		entityTransaction.begin();

//		entityManager.persist(aadharCard);
//		entityManager.persist(person);
		AadharCard aadharCard1=entityManager.find(AadharCard.class, 102);
		entityManager.remove(aadharCard1);
		entityTransaction.commit();

	}

}
