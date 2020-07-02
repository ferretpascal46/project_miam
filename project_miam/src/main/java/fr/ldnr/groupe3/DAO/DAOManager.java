package fr.ldnr.groupe3.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAOManager {
	private EntityManagerFactory emf;
	private UtilisateurDAO utilisateurDAO;
	private ClientDAO clientDAO;
	private CommandeDAO commandeDAO;
	private ProduitDAO produitDAO;
	private LigneCommandeDAO ligneCommandeDAO;

	public void start() {
		this.emf = Persistence.createEntityManagerFactory("my-pu");
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO(this.emf);
		this.clientDAO = DAOFactory.getClientDAO(this.emf);
		this.commandeDAO = DAOFactory.getCommandeDAO(emf);
		this.produitDAO = DAOFactory.getProduitDAO(emf);
		this.ligneCommandeDAO = DAOFactory.getLignCommandeDAO(emf);
	}
	
	public UtilisateurDAO getUtilisateurDAO() {
		return this.utilisateurDAO;
	}
	
	public ClientDAO getClientDAO() {
		return this.clientDAO;
	}
	
	public CommandeDAO getCommandeDAO() {
		return this.commandeDAO;
	}
	
	public ProduitDAO getProduitDAO() {
		return this.produitDAO;
	}
	
	public LigneCommandeDAO getLigneCommandeDAO() {
		return this.ligneCommandeDAO;
	}
	
	public void stop() {
		this.emf.close();
	}
}

