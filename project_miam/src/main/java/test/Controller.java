package test;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.beans.Utilisateur;

public class Controller {

	private DAOManager daoManager;

	public Controller(DAOManager daoManager) {
		this.daoManager = daoManager;
	}

	public void start() {
		System.out.println("## WELCOME");
		this.daoManager.start();
		
		Utilisateur user = new Utilisateur();
		user = this.daoManager.getUtilisateurDAO().findUtilisateurByMail("p@mail.fr");		
		System.out.println("id = " + user.getIdUtilisateur());
		
		/*
		String email = "emailTest";
		String password = "passwordTest";

		
		int newIdUtiliateur = 0;
		try {
			Utilisateur newUser = new Utilisateur(email, HashForm.hash(email, password), Role.CLIENT);
			newIdUtiliateur = this.daoManager.getUtilisateurDAO().create(newUser);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Probleme lors du hash : " + e);
		}

		if (newIdUtiliateur != 0) {
			Client newClient = new Client();
			
			newClient.setIdUtilisateur(newIdUtiliateur);
			newClient.setNom("nomUser");
			newClient.setPrenom("prenom");
			newClient.setNumeroRue(10);
			newClient.setRue("rue");
			newClient.setComplement("complementAdresse");
			newClient.setCodePostal(75000);
			newClient.setVille("Ville");
			
			this.daoManager.getClientDAO().create(newClient);
		} else {
			System.out.println("Problème lors de la création du compte utilisateur");
		}
		

	     
	      /*
	       * @TODO  Voir avec PJ pourquoi on ne réussi pas à appeler l'Utilsareur DAO
	       */
	     
	      
		/*
		// creation users
		System.out.println("Creation de l'utilisateur pj@mail.fr");
		int idUser1 = this.daoManager.getUtilisateurDAO().create("pj@mail.fr", "motDePasse", Role.CLIENT);
		System.out.println("Creation de l'utilisateur pj2@mail.fr");
		this.daoManager.getUtilisateurDAO().create("pj2@mail.fr", "motDePasse", Role.CLIENT);

		// update user
		boolean result = this.daoManager.getUtilisateurDAO().update(idUser1, "pj4@mail.fr", "motDePasse2", Role.GERANT);
		if (result) {
			System.out.println(" - User updated");
		} else {
			System.out.println(" - Invalid Id");
		}

		// delete user
		Utilisateur result2 = this.daoManager.getUtilisateurDAO().delete(3);
		if (result2 != null) {
			System.out.println(" - User Deleted");
		} else {
			System.out.println(" - Invalid Id");
		}

		// display user
		System.out.println();
		System.out.println("# List of users");
		List<Utilisateur> employees = this.daoManager.getUtilisateurDAO().list();
		if (employees.isEmpty()) {
			System.out.println(" - No users in Database");
		} else {
			System.out.println(" - List of users:");
			for (Utilisateur employee : employees) {
				System.out.println(employee.getAdresseMail());
			}
		}

		// DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date(1000);

		// creation client
		System.out.println("Creation du user 1");
		int idClient1 = this.daoManager.getUtilisateurDAO().create("pj@mail.fr", "motDePasse", Role.CLIENT);
		this.daoManager.getClientDAO().create(idClient1, "Seguy", "pj", 10, "coin-coin", "", 46000, "Cahors",
				"0659985610", today);

		System.out.println("Creation du user 2");
		int idClient2 = this.daoManager.getUtilisateurDAO().create("pj2@mail.fr", "motDePasse", Role.GERANT);
		this.daoManager.getClientDAO().create(idClient2, "Seguy", "pj", 10, "coin-coin", "", 46000, "Cahors",
				"0659985610", today);

		// update client
		boolean client = this.daoManager.getClientDAO().update(idClient1, "Bettini", "Sarah", 0, "", "", 0, "", "",
				today);
		if (client) {
			System.out.println(" - User updated");
		} else {
			System.out.println(" - Invalid Id");
		}

		// delete client
		Utilisateur result3 = this.daoManager.getUtilisateurDAO().delete(idClient2);
		if (result3 != null) {
			System.out.println(" - Client Deleted");
		} else {
			System.out.println(" - Invalid Id");
		}

		// display client
		System.out.println();
		System.out.println("# List of users");
		List<Utilisateur> listUser = this.daoManager.getUtilisateurDAO().list();
		List<Client> listClient = this.daoManager.getClientDAO().list();
		if (listClient.isEmpty()) {
			System.out.println(" - No client in Database");
		} else {
			System.out.println(" - List of client:");
			for (int i = 0; i < listUser.size(); i++) {
				for (int j = 0; j < listClient.size(); j++) {
					if (listUser.get(i).getIdUtilisateur() == listClient.get(j).getIdUtilisateur()) {
						System.out.println("email = " + listUser.get(j).getAdresseMail() + "\tnom = "
								+ listClient.get(j).getPrenom());
						break;
					}
				}
			}
		}

		// create Product
		System.out.println("Creation du produit 1");
		this.daoManager.getProduitDAO().create("sushi", TypeProduit.PLAT, 10.12);
		System.out.println("Creation du produit 2");
		this.daoManager.getProduitDAO().create("Nioc Nioc", TypeProduit.PLAT, 15D);
		System.out.println("Creation du produit 3");
		this.daoManager.getProduitDAO().create("Mega Sushi", TypeProduit.PLAT, 15D);

		// update Product
		boolean product = this.daoManager.getProduitDAO().update(1, "maki", TypeProduit.PLAT, 8.1);
		if (product) {
			System.out.println(" - Product updated");
		} else {
			System.out.println(" - Invalid Id");
		}

		// delete Product
		Produit product2 = this.daoManager.getProduitDAO().delete(4);
		if (product2 != null) {
			System.out.println(" - Product Deleted");
		} else {
			System.out.println(" - Invalid Id");
		}

		// display Product
		System.out.println();
		System.out.println("# List of Products");
		List<Produit> products = this.daoManager.getProduitDAO().list();
		if (products.isEmpty()) {
			System.out.println(" - No users in Database");
		} else {
			System.out.println(" - List of users:");
			for (Produit productList : products) {
				System.out.println(productList.getNomProduit());
			}
		}

		// create Command
		System.out.println("Creation de la premire commande");
		int idCommande1 = this.daoManager.getCommandeDAO().create(18, StatusCommande.EN_PREPARARATION,
				TypeDeCommande.A_EMPORTER);
		System.out.println("Ajout de produits");
		this.daoManager.getLigneCommandeDAO().create(idCommande1, 1);
		this.daoManager.getLigneCommandeDAO().create(idCommande1, 3);

		System.out.println("Creation de la deuxième commande");
		int idCommande2 = this.daoManager.getCommandeDAO().create(18, StatusCommande.EN_PREPARARATION,
				TypeDeCommande.A_EMPORTER);
		System.out.println("Ajout de produits");
		this.daoManager.getLigneCommandeDAO().create(idCommande2, 4);
		this.daoManager.getLigneCommandeDAO().create(idCommande2, 5);

		// update Command
		boolean command = this.daoManager.getCommandeDAO().update(idCommande2, StatusCommande.PRET,
				TypeDeCommande.LIVRAISON);
		if (command) {
			System.out.println(" - Command updated");
		} else {
			System.out.println(" - Invalid Id");
		}

		// delete Command
		Commande command2 = this.daoManager.getCommandeDAO().delete(6);
		if (command2 != null) {
			System.out.println(" - Command Deleted");
		} else {
			System.out.println(" - Invalid Id");
		}
/*
		// display Command
		System.out.println();
		System.out.println("# List Of Commands");
		//à faire
		List<Utilisateur> listUser = this.daoManager.getUtilisateurDAO().list();
		List<Client> listClient = this.daoManager.getClientDAO().list();
		if (listClient.isEmpty()) {
			System.out.println(" - No client in Database");
		} else {
			System.out.println(" - List of client:");
			for (int i = 0; i < listUser.size(); i++) {
				for (int j = 0; j < listClient.size(); j++) {
					if (listUser.get(i).getIdUtilisateur() == listClient.get(j).getIdUtilisateur()) {
						System.out.println("email = " + listUser.get(j).getAdresseMail() + "\tnom = "
								+ listClient.get(j).getPrenom());
						break;
					}
				}
			}
		} */
		
		this.daoManager.stop();
	}
}
