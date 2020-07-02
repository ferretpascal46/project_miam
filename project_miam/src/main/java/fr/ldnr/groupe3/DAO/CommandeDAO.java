package fr.ldnr.groupe3.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.ldnr.groupe3.Enum.StatusCommande;
import fr.ldnr.groupe3.Enum.TypeDeCommande;
import fr.ldnr.groupe3.beans.Commande;



public class CommandeDAO {
	private EntityManagerFactory emf;

	public CommandeDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public int create(int FK_idClient, StatusCommande status, TypeDeCommande type) {
		Commande commande = new Commande(FK_idClient, status, type);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(commande);
		em.getTransaction().commit();
		em.close();
		return commande.getIdCommande();
	}

	public boolean update(int idCommande, StatusCommande statusCommande, TypeDeCommande typeCommande) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Commande commande = em.find(Commande.class, idCommande);
		if (commande != null) {
			commande.setStatusCommande(statusCommande);
			commande.setTypeCommande(typeCommande);
		}
		em.getTransaction().commit();
		em.close();
		return (commande != null);
	}

	public Commande delete(int idCommande) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Commande user = em.find(Commande.class, idCommande);
		if (user != null) {
			em.remove(user);
		}
		em.getTransaction().commit();
		em.close();
		return user;
	}

	
	public List<Commande> list() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c", Commande.class);
		List<Commande> result = query.getResultList();
		em.close();
		return result;
	}

}
