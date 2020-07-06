package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.Enum.Role;
import fr.ldnr.groupe3.beans.Client;
import fr.ldnr.groupe3.beans.Utilisateur;

/**
 * Servlet implementation class listeClient
 */
@WebServlet("/listeClient")
public class listeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE = "/WEB-INF/gerant_liste_clients.jsp";
	DAOManager daoManager = new DAOManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listeClient() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("page", "listeClient");

		daoManager.start();
		List<Utilisateur> utilisateurs = daoManager.getUtilisateurDAO().list();
		List<Client> clients = daoManager.getClientDAO().list();
		HashMap<Client,String> hmUtilisateurs = new HashMap<Client, String>();
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getRole() == Role.CLIENT ) {
				for (Client client : clients) {
					if(client.getIdUtilisateur() == utilisateur.getIdUtilisateur()) {
						hmUtilisateurs.put(client, utilisateur.getAdresseMail());
					}
				}
			}			
		}
		
		request.setAttribute("utilisateurs", hmUtilisateurs);

		daoManager.stop();

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// display user

		request.setAttribute("toto", "bvlalball");

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
