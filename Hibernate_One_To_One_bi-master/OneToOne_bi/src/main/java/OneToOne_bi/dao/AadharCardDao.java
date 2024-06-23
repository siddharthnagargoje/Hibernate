package OneToOne_bi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import OneToOne_bi.dto.AadharCard;
import OneToOne_bi.dto.Person;

public class AadharCardDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void saveAadhar(AadharCard aadharCard) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person = aadharCard.getPerson();

		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updateAadhar(int id, AadharCard aadharCard) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		AadharCard receivedaadhar = entityManager.find(AadharCard.class, id);
		if (receivedaadhar != null) {
			aadharCard.setId(id);
			Person person = aadharCard.getPerson();

			entityTransaction.begin();
			entityManager.merge(aadharCard);
			entityManager.merge(person);
			entityTransaction.commit();
		} else {
			System.out.println("AadharCard doesn't exists");
		}
	}

	public void deleteAadhar(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		AadharCard aadharCard = entityManager.find(AadharCard.class, id);
		Person person = aadharCard.getPerson();

		entityTransaction.begin();
		entityManager.remove(aadharCard);
		entityManager.remove(person);
		entityTransaction.commit();
	}

	public AadharCard getAadharById(int id) {
		EntityManager entityManager = getEntityManager();
		AadharCard aadharCard = entityManager.find(AadharCard.class, id);
		return aadharCard;
	}

	public List<AadharCard> getAllAadhar() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT a FROM AadharCard a");
		List<AadharCard> list = query.getResultList();
		return list;
	}

}
