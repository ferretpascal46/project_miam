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

	//prend en paramètres un objet utilisateur pour le créer dans le BDD
	//retourne l'idUtilisateur créé pour être réutilisé lors de la création du client
	//necessite un Utilisateur avec les attributs adressMail, motDePasse et role remplis
	public int create(Utilisateur user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		return user.getIdUtilisateur();
	}

	// retourne un boolean donnant le résutat si (user != null)
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

	// retourne un boolean donnant le résutat si user != null
	public boolean delete(int idUtilisateur) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Utilisateur user = em.find(Utilisateur.class, idUtilisateur);
		if (user != null) {
			em.remove(user);
		}

		em.getTransaction().commit();
		em.close();
		return (user != null);
	}

	//liste les utilisateurs
	//retourne une liste
	//e.lastName= :lastName
	public List<Utilisateur> list() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
		List<Utilisateur> result = query.getResultList();

		em.close();
		return result;
	}
	
	public Utilisateur findIdUtilisateur(String adresseMail) {
		EntityManager em = emf.createEntityManager();		
		//e.lastName= :lastName
		TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.adresseMail = :adresseMail", Utilisateur.class);
		query.setParameter("adresseMail", adresseMail);
		List<Utilisateur> result = query.getResultList();
					
		em.close();		
		return result.get(0);
	}

}
