package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

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
		List<Utilisateur> employees = this.daoManager.getEmployeeDAO().list();
		if (employees.isEmpty()) {
			System.out.println(" - No users in Database");
		} else {
			System.out.println(" - List of users:");
			for (Utilisateur employee : employees) {
				System.out.println(employee.getAdresseMail());
			}
		}
		
		this.daoManager.stop();

	}
}
