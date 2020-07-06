package fr.ldnr.groupe3.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.ldnr.groupe3.Enum.TypeProduit;
import fr.ldnr.groupe3.beans.Produit;
import fr.ldnr.groupe3.beans.Utilisateur;

public class ProduitDAO {
	private EntityManagerFactory emf;

	public ProduitDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	
	//prend en paramètres un objet produit pour le créer dans le BDD
	//necessite un Produit avec les attributs String nomProduit, TypeProduit type, Double prix
	public void create(Produit produit) {		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produit);
		em.getTransaction().commit();
		em.close();
	}

	// retourne un boolean donnant le résutat si (user != null)
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

	
	// retourne un boolean donnant le résutat si (user != null)
	public boolean delete(int id) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Produit produit = em.find(Produit.class, id);
		if (produit != null) {
			em.remove(produit);
		}
		em.getTransaction().commit();
		em.close();
		return (produit != null);
	}

	//liste les Produit
	//retourne une liste
	public List<Produit> list() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Produit> query = em.createQuery("SELECT p FROM Produit p", Produit.class);
		List<Produit> result = query.getResultList();

		em.close();
		return result;
	}
	
	public Produit findProduitById(int id) {
		EntityManager em = emf.createEntityManager();		

		Produit produit = em.find(Produit.class, id);			
		
		return produit;
	}
}
