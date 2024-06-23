package manytoone_uni_task.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytoone_uni_task.dto.Bank;
import manytoone_uni_task.dto.Branch;

public class BranchDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveBranch(Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		Bank bank = branch.getBank();
		entityManager.persist(bank);
		entityManager.persist(branch);
		entityTransaction.commit();
	}

	public void updateBranch(int id, Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch receivedbranch = entityManager.find(Branch.class, id);
		if (receivedbranch != null) {
			branch.setId(id);
			branch.setBank(receivedbranch.getBank());
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		} else {
			System.out.println("Branch doesn't exsists");
		}
	}

	public void deleteBranch(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch = entityManager.find(Branch.class, id);

		entityTransaction.begin();
		entityManager.remove(branch);
		entityTransaction.commit();
	}

	public Branch getBranchById(int id) {
		EntityManager entityManager = getEntityManager();
		Branch branch = entityManager.find(Branch.class, id);
		return branch;
	}

	public List<Branch> getAllBranch() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("SELECT b FROM BRANCH b");
		List<Branch> list = query.getResultList();
		return list;
	}

}
