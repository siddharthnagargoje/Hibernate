package one_to_one_uni_practice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_practice.dto.PanCard;

public class PanCardDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	
	public void savePancard(PanCard panCard) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
	
		entityManager.persist(panCard);		
	
		entityTransaction.commit();
	}
	
	public void updatePancard(PanCard panCard) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		
		entityManager.merge(panCard);		
		
		entityTransaction.commit();
	}
	
	public void deletePancard(int pid) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		PanCard panCard=entityManager.find(PanCard.class, pid);
		if(panCard!=null) {
			entityTransaction.begin();
			entityManager.remove(panCard);		
			entityTransaction.commit();
		}
	}
	
	public PanCard getPancardById(int pid) {
		EntityManager entityManager=getEntityManager();
		PanCard panCard=entityManager.find(PanCard.class, pid);
		return panCard;
	}
	
	public List<PanCard> getAllPancard(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("SELECT pc FROM PanCard pc");
		List<PanCard> list=query.getResultList();
		return list;
	}
	
}
