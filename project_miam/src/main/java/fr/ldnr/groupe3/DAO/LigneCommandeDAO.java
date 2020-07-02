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

	public void create(int idCommande, int idProduit) {
		LigneCommande lc = new LigneCommande(idCommande, idProduit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
		em.close();
	}

	public List<LigneCommande> list() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<LigneCommande> query = em.createQuery("SELECT lc FROM Produit lc", LigneCommande.class);
		List<LigneCommande> result = query.getResultList();

		em.close();
		return result;
	}
}
