package fr.ldnr.groupe3.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.ldnr.groupe3.beans.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur>{

	private EntityManagerFactory emf;

	public UtilisateurDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Utilisateur create(Utilisateur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilisateur> list() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
		List<Utilisateur> result = query.getResultList();

		em.close();

		return result;
	}

}
