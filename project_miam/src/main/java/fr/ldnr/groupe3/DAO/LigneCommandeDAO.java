package fr.ldnr.groupe3.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.ldnr.groupe3.beans.LigneCommande;

public class LigneCommandeDAO {
	private EntityManagerFactory emf;

	public LigneCommandeDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	
	//prend en paramètres un objet LigneCommande pour le créer dans le BDD
	//necessite un LigneCommande avec les attributs int idCommande, int idProduit
	public void create(LigneCommande lc) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
		em.close();
	}

	//liste chaque lignes de commandes de la BDD
	//retourne une liste
	public List<LigneCommande> list() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<LigneCommande> query = em.createQuery("SELECT lc FROM Produit lc", LigneCommande.class);
		List<LigneCommande> result = query.getResultList();

		em.close();
		return result;
	}
}
