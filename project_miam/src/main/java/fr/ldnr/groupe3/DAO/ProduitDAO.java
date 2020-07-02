package fr.ldnr.groupe3.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.ldnr.groupe3.Enum.TypeProduit;
import fr.ldnr.groupe3.beans.Produit;

public class ProduitDAO {
	private EntityManagerFactory emf;

	public ProduitDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void create(String nomProduit, TypeProduit type, Double prix) {

		Produit produit = new Produit(nomProduit, type, prix);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produit);
		em.getTransaction().commit();
		em.close();
	}

	public boolean update(int id, String nomProduit, TypeProduit type, Double prix) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Produit produit = em.find(Produit.class, id);
		if (produit != null) {
			produit.setNomProduit(nomProduit);
			produit.setTypeProduit(type);
			produit.setPrix(prix);
		}
		em.getTransaction().commit();
		em.close();
		return (produit != null);
	}

	
	public Produit delete(int id) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Produit user = em.find(Produit.class, id);
		if (user != null) {
			em.remove(user);
		}
		em.getTransaction().commit();
		em.close();
		return user;
	}

	
	public List<Produit> list() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Produit> query = em.createQuery("SELECT p FROM Produit p", Produit.class);
		List<Produit> result = query.getResultList();

		em.close();
		return result;
	}
}
