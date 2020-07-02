package fr.ldnr.groupe3.DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import fr.ldnr.groupe3.beans.Client;

public class ClientDAO {
	private EntityManagerFactory emf;	

	public ClientDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
			
	public void create(int id, String nom, String prenom, int numeroRue, String rue, String complement,
			int codePostal, String ville, String telephone, Date dateCreation ) {		
		
		Client client = new Client(id, nom, prenom, numeroRue, rue, complement, codePostal, ville, 
				telephone, dateCreation);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
		em.close();		
	}
	
	public boolean update(int id, String nom, String prenom, int numeroRue, String rue, String complement, int codePostal, 
			String ville, String telephone, Date dateCreation ) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Client user = em.find(Client.class, id);
		if (user != null) {
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setNumeroRue(numeroRue);
			user.setRue(rue);
			user.setComplement(complement);
			user.setVille(ville);
			user.setTelephone(telephone);
			user.setDateCreation(dateCreation);
		} 
		em.getTransaction().commit();
		em.close();
		return (user != null);
	}
	
	/*
	public Client delete(int idUtilisateur) {
		
		EntityManager em = emf.createEntityManager();		
		em.getTransaction().begin();
		
		Utilisateur user = em.find(Utilisateur.class, idUtilisateur);		
		if (user != null) {
			em.remove(user);
		}
		
		em.getTransaction().commit();
		em.close();		
		return user;	
	}*/

	
	public List<Client> list() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<Client> query = em.createQuery("SELECT  c FROM Client c  ", Client.class);
		List<Client> result = query.getResultList();

		em.close();
		return result;
	}

}
