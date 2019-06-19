package com.axelor.crud.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.axelor.crud.db.User;



public class Crud {

	public static void main(String[] args) {
		System.out.println("Start execution from crud main method::");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Crud");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		// Add,update and delete user;
//		addUser(entityManager);
//		updateUser(entityManager,1);
//		deleteUser(entityManager, 1);
		selectAllUser(entityManager);


		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

	private static void addUser(EntityManager entityManager) {
		System.out.println("Add user::");
		User user = new User();
		user.setName("bhumi");
		user.setEmail("bga.axelor@gmail.com");
		entityManager.persist(user);

		System.out.println("Record added successfully.");

	}

	private static void updateUser(EntityManager entityManager, int id) {

		User user = entityManager.find(User.class, id);
		if (user != null) {
			System.out.println("Before update");
			System.out.println("user name::" + user.getName());
			System.out.println("User email::" + user.getEmail());

			user.setName("testEdit");
			user.setEmail("testEdit@email.com");

			user = entityManager.find(User.class, 1);
			System.out.println("After update");
			System.out.println("user name::" + user.getName());
			System.out.println("User email::" + user.getEmail());
		} else {
			System.out.println("Record Not found.");
		}

	}

	private static void deleteUser(EntityManager entityManager, int id) {

		User user = entityManager.find(User.class, id);
		System.out.println("user::" + user);
		if (user != null) {
			entityManager.remove(user);
			System.out.println("Record deleted successfully.");
		} else {
			System.out.println("Record Not found.");
		}
	}

	public static void selectAllUser(EntityManager entityManager) {
//		List<User> listOfUser=entityManager.cre
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq=cb.createQuery(User.class);
		Root<User> root=cq.from(User.class);
		cq.select(root);
		TypedQuery<User> typeQuery =entityManager.createQuery(cq);
		List<User> listOfUser = typeQuery.getResultList();
		if(listOfUser !=null) {
			System.out.println("Total User::"+listOfUser.size());
			int cnt=1;
			System.out.println("Sr.No:          Name          Email    ");
			for(User user:listOfUser) {
				System.out.println(cnt    +"        "+user.getName() +  "  "+ user.getEmail());
			
				cnt++;
			}
		}else {
			System.out.println("No Records in table user.");
		}
	}
}
