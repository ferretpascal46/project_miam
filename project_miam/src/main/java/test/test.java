package test;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.DAO.UtilisateurDAO;
import fr.ldnr.groupe3.beans.Utilisateur;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAOManager daoManager = new DAOManager();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		UtilisateurDAO u = new UtilisateurDAO(emf);

		System.out.println();
		System.out.println("# List of Employees");
		List<Utilisateur> employees = daoManager.getEmployeeDAO().list();
		if (employees.isEmpty()) {
			System.out.println(" - No Employees in Database");
		} else {
			System.out.println(" - List of employees:");
			for (Utilisateur employee : employees) {
				employee.toString();
			}
		}
	}

}
