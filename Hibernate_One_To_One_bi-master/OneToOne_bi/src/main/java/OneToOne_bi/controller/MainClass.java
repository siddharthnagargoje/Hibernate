package OneToOne_bi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import OneToOne_bi.dto.AadharCard;
import OneToOne_bi.dto.Person;

public class MainClass {

	public static void main(String[] args) {

//		Person person = new Person();
//		person.setId(1);
//		person.setName("Dimple");
//		person.setAddress("DL");
//		person.setPhone(789456123);
//
//		AadharCard aadharCard = new AadharCard();
//		aadharCard.setId(101);
//		aadharCard.setName("Dimple.S");
//		aadharCard.setAddress("Delhi");
//
//		person.setAadharCard(aadharCard);
//		aadharCard.setPerson(person);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

//		entityTransaction.begin();
//		entityManager.persist(person);
//		entityManager.persist(aadharCard);
//		entityTransaction.commit();

//		Person person = entityManager.find(Person.class, 1);
//		System.out.println(person);
		
		AadharCard aadharCard=entityManager.find(AadharCard.class, 101);
		System.out.println(aadharCard);

	}

}
