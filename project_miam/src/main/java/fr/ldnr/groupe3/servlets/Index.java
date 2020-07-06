package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.beans.Produit;

/**
 * Servlet implementation class index
 */
@WebServlet(name = "Connexion", urlPatterns = { "/index" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE = "/WEB-INF/index.jsp";
	DAOManager daoManager = new DAOManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("page", "index");

		daoManager.start();

		List<Produit> produits = daoManager.getProduitDAO().list();
		request.setAttribute("produits", produits);
		daoManager.stop();

			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
