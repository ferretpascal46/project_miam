package fr.ldnr.groupe3.DAO;

import javax.persistence.EntityManagerFactory;

public class DAOFactory {
	
	
	public static UtilisateurDAO getUtilisateurDAO(EntityManagerFactory emf) {
		return new UtilisateurDAO(emf);
	}

	public static ClientDAO getClientDAO(EntityManagerFactory emf) {
		return new ClientDAO(emf);
	}
}
