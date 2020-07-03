package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.beans.Utilisateur;

/**
 * Servlet implementation class listeClient
 */
@WebServlet("/listeClient")
public class listeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE = "/WEB-INF/gerant_liste_clients.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listeClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("toto", "bvlalball");
		
		DAOManager daoManager = new DAOManager();
		daoManager.start();
		List<Utilisateur> utilisateurs = daoManager.getUtilisateurDAO().list();
		
		request.setAttribute("utilisateurs", "utilisateurs");
		daoManager.stop();
		request.setAttribute("toto", "bvlalball");

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// display user
		DAOManager daoManager = new DAOManager();
		List<Utilisateur> utilisateurs = daoManager.getUtilisateurDAO().list();
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
