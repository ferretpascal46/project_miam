package fr.ldnr.groupe3.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAOManager {
	private EntityManagerFactory emf;
	private UtilisateurDAO utilisateurDAO;
	

	public void start() {
		this.emf = Persistence.createEntityManagerFactory("my-pu");
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO(this.emf);
	}

	public void stop() {
		this.emf.close();
	}
	
	public UtilisateurDAO getUtilisateurDAO() {
		return this.utilisateurDAO;
	}
}
