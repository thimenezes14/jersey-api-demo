package br.edu.ifsp.adi.ativ01.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifsp.adi.ativ01.entities.User;

public class UserDAO {
	
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("userPU");
	protected EntityManager em = this.emf.createEntityManager();
	
	public User findUserById(UUID id) {
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findUserByName(String term) {
		return em.createQuery("FROM " + User.class.getName() + " WHERE name LIKE '%" + term + "%'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		return em.createQuery("FROM " + User.class.getName()).getResultList();
	}
	
	public void createUser(User u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public User updateUser(UUID id, User u) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		if (u.getName() != null) {
			user.setName(u.getName());
		}
		if (u.getEmail() != null) {
			user.setEmail(u.getEmail());
		}
		if (u.getTelephone() != null) {
			user.setTelephone(u.getTelephone());
		}
		em.merge(user);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return user;
	}
	
	public void deleteUser(UUID id) {
		em.getTransaction().begin();
		User u = em.find(User.class, id);
		em.remove(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
