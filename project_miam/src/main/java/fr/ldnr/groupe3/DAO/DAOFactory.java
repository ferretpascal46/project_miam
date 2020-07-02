package fr.ldnr.groupe3.DAO;

import javax.persistence.EntityManagerFactory;

public class DAOFactory {
	
	
	public static UtilisateurDAO getUtilisateurDAO(EntityManagerFactory emf) {
		return new UtilisateurDAO(emf);
	}

	public static ClientDAO getClientDAO(EntityManagerFactory emf) {
		return new ClientDAO(emf);
	}
	
	public static CommandeDAO getCommandeDAO(EntityManagerFactory emf) {
		return new CommandeDAO(emf);
	}
	
	public static ProduitDAO getProduitDAO(EntityManagerFactory emf) {
		return new ProduitDAO(emf);
	}
	
	public static LigneCommandeDAO getLignCommandeDAO(EntityManagerFactory emf) {
		return new LigneCommandeDAO(emf);
	}
	
}
