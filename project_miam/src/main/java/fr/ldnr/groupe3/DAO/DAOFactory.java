package fr.ldnr.groupe3.DAO;

import javax.persistence.EntityManagerFactory;

public class DAOFactory {
	
	
	public static UtilisateurDAO getUtilisateurDAO(EntityManagerFactory emf) {
		return new UtilisateurDAO(emf);
	}/*

	public static PostDAO getPostDAO() {
		return new PostDAO();
	}*/
}
