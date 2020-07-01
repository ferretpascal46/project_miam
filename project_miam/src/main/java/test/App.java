package test;

import fr.ldnr.groupe3.DAO.DAOManager;

public class App {
	public static void main(String[] args) {
		DAOManager daoManager = new DAOManager();
		Controller controller = new Controller(daoManager);
		controller.start();
	}
}
