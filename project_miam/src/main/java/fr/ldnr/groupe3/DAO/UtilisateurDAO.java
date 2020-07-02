package fr.ldnr.groupe3.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.ldnr.groupe3.Enum.Role;
import fr.ldnr.groupe3.beans.Utilisateur;

//public class UtilisateurDAO extends DAO<Utilisateur>{
public class UtilisateurDAO {

	private EntityManagerFactory emf;	
	
	public UtilisateurDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public int create(Utilisateur user) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		return user.getIdUtilisateur();
	}

	public boolean update(int idUtilisateur, String adresseMail, String motDePasse, Role role) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Utilisateur user = em.find(Utilisateur.class, idUtilisateur);
		if (user != null) {
			user.setAdresseMail(adresseMail);
			user.setMotDePasse(motDePasse);
			user.setRole(role);
		} 
		em.getTransaction().commit();
		em.close();
		return (user != null);
	}

	
	public Utilisateur delete(int idUtilisateur) {
		
		EntityManager em = emf.createEntityManager();		
		em.getTransaction().begin();
		
		Utilisateur user = em.find(Utilisateur.class, idUtilisateur);		
		if (user != null) {
			em.remove(user);
		}
		
		em.getTransaction().commit();
		em.close();		
		return user;	
	}

	
	public List<Utilisateur> list() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
		List<Utilisateur> result = query.getResultList();

		em.close();
		return result;
	}
	
}
