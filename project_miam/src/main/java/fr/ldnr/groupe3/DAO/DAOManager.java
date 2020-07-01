package fr.ldnr.groupe3.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAOManager {
	private EntityManagerFactory emf;
	private UtilisateurDAO utilisateurDAO;
	

	public void start() {
		this.emf = Persistence.createEntityManagerFactory("my-pu");
		this.utilisateurDAO = new UtilisateurDAO(this.emf);
	}

	public void stop() {
		this.emf.close();
	}
	
	public UtilisateurDAO getEmployeeDAO() {
		return this.utilisateurDAO;
	}
}
