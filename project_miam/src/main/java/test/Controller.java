package test;

import java.sql.Date;
import java.util.List;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.beans.Client;
import fr.ldnr.groupe3.beans.Utilisateur;
import fr.ldnr.groupe3.pourlesEnum.Role;



public class Controller {
	
	private DAOManager daoManager;
		
	public Controller(DAOManager daoManager) {
		this.daoManager = daoManager;		
	}
	
	public void start() {
		System.out.println("## WELCOME");

		this.daoManager.start();		
		
		//creation users
		System.out.println("Creation de l'utilisateur pj@mail.fr");
		int idUser1 = this.daoManager.getUtilisateurDAO().create("pj@mail.fr", "motDePasse", Role.CLIENT);
		System.out.println("Creation de l'utilisateur pj2@mail.fr");
		int idUser2 = this.daoManager.getUtilisateurDAO().create("pj2@mail.fr", "motDePasse", Role.CLIENT);
		
		//update user
		boolean result = this.daoManager.getUtilisateurDAO().update(idUser1, "pj4@mail.fr", "motDePasse2", Role.GERANT);
		if (result) {
			System.out.println(" - User updated");
		} else {
			System.out.println(" - Invalid Id");
		}
				
		//delete user
		Utilisateur result2 = this.daoManager.getUtilisateurDAO().delete(3);
		if (result2 != null) {
			System.out.println(" - User Deleted");
		} else {
			System.out.println(" - Invalid Id");
		}		
		
		//display user
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
		
		//DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date(1000);
		
		//creation client
		System.out.println("Creation du user 1");
		int idClient1 = this.daoManager.getUtilisateurDAO().create("pj@mail.fr", "motDePasse", Role.CLIENT);
		this.daoManager.getClientDAO().create(idClient1, "Seguy", "pj", 10, "coin-coin", "", 46000, 
				"Cahors", "0659985610", today);	
		
		System.out.println("Creation du user 2");
		int idClient2 = this.daoManager.getUtilisateurDAO().create("pj2@mail.fr", "motDePasse", Role.GERANT);	
		this.daoManager.getClientDAO().create(idClient2, "Seguy", "pj", 10, "coin-coin", "", 46000, 
				"Cahors", "0659985610", today);
		
		//update client
		boolean client = this.daoManager.getClientDAO().update(idClient1,"Bettini", "Sarah", 0, "", "", 0, "",
				"", today);
		if (client) {
			System.out.println(" - User updated");
		} else {
			System.out.println(" - Invalid Id");
		}
		
		//delete client
		Utilisateur result3 = this.daoManager.getUtilisateurDAO().delete(idClient2);
		if (result3 != null) {
			System.out.println(" - Client Deleted");
		} else {
			System.out.println(" - Invalid Id");
		}
				
		//read client
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
						System.out.println("email = " + listUser.get(j).getAdresseMail() 
								+ "\tnom = " + listClient.get(j).getPrenom());
						break;
					}
				}
			}
		}		
		this.daoManager.stop();
	}
}
