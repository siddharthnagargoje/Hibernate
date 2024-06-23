package OneToOne_bi_task.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import OneToOne_bi_task.dto.PanCard;
import OneToOne_bi_task.dto.Person;

public class PanCardDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void savePan(PanCard panCard) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		//Person person = panCard.getPerson();

		entityTransaction.begin();
		entityManager.persist(panCard);
		//entityManager.persist(person);
		entityTransaction.commit();
	}

	public void updatePan(int id, PanCard panCard) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PanCard receivedpan = entityManager.find(PanCard.class, id);
		if (receivedpan != null) {
			panCard.setId(id);
			Person person = panCard.getPerson();

			entityTransaction.begin();
			entityManager.merge(panCard);
			entityManager.merge(person);
			entityTransaction.commit();
		} else {
			System.out.println("PanCard doesn't exists");
		}
	}

	public void deletePan(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		PanCard panCard = entityManager.find(PanCard.class, id);
		Person person = panCard.getPerson();

		entityTransaction.begin();
		entityManager.remove(panCard);
		entityManager.remove(person);
		entityTransaction.commit();
	}

	public PanCard getPanById(int id) {
		EntityManager entityManager = getEntityManager();
		PanCard panCard = entityManager.find(PanCard.class, id);
		return panCard;
	}

	public List<PanCard> getAllPan() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT p FROM PanCard p");
		List<PanCard> list = query.getResultList();
		return list;
	}

}
