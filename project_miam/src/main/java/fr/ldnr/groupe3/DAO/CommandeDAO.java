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

	//prend en paramètres un objet Commande pour le créer dans le BDD
	//retourne l'idCommande créé pour être réutilisé lors de la création des LigneCommande
	//necessite un Commande avec les attributs int FK_idClient, StatusCommande status, TypeDeCommande type
	public int create(Commande commande) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(commande);
		em.getTransaction().commit();
		em.close();
		return commande.getIdCommande();
	}

	// retourne un boolean donnant le résutat si (user != null)
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

	// retourne un boolean donnant le résutat si (user != null)
	public boolean delete(int idCommande) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Commande commande = em.find(Commande.class, idCommande);
		if (commande != null) {
			em.remove(commande);
		}
		em.getTransaction().commit();
		em.close();
		return (commande != null);
	}

	
	//liste les Commandes
	//retourne une liste
	public List<Commande> list() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Commande> query = em.createQuery("SELECT c FROM Commande c", Commande.class);
		List<Commande> result = query.getResultList();
		em.close();
		return result;
	}

}
