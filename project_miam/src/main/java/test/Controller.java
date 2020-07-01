package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.beans.Utilisateur;



public class Controller {
	
	private DAOManager daoManager;
	private Scanner scanner;
	private DateFormat dateFormat;
	private static final String DATE_FORMAT = "dd-MM-yyyy";

	
	public Controller(DAOManager daoManager) {
		this.daoManager = daoManager;
		this.scanner = new Scanner(System.in);
		this.dateFormat = new SimpleDateFormat(DATE_FORMAT);
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
				employee.getAdresseMail();
			}
		}
		
		this.daoManager.stop();

	}
}
