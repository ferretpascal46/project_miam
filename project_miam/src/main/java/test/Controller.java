package test;

import java.util.List;

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
		
		System.out.println("Creation de l'utilisateur pj@mail.fr");
		this.daoManager.getUtilisateurDAO().create("pj@mail.fr", "motDePasse", 1);
		System.out.println("Creation de l'utilisateur pj2@mail.fr");
		this.daoManager.getUtilisateurDAO().create("pj2@mail.fr", "motDePasse", 1);
		
		
		boolean result = this.daoManager.getUtilisateurDAO().update(4, "pj4@mail.fr", "motDePasse2",2);
		if (result) {
			System.out.println(" - User updated");
		} else {
			System.out.println(" - Invalid Id");
		}
		
		Utilisateur result2 = this.daoManager.getUtilisateurDAO().delete(3);
		if (result2 != null) {
			System.out.println(" - User Deleted");
		} else {
			System.out.println(" - Invalid Id");
		}
		
		this.daoManager.stop();

	}
}
