package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.Enum.TypeProduit;
import fr.ldnr.groupe3.beans.Produit;

/**
 * Servlet implementation class Modification_carte
 */
@WebServlet(name = "Modification_carte", urlPatterns = { "/modification_carte" })
public class Modification_carte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/gerant_modification_carte.jsp";
	DAOManager daoManager = new DAOManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modification_carte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setAttribute("page", "modificationCarte");

		daoManager.start();
		String supprimer = request.getParameter("supprimer");
		String modifier = request.getParameter("modifier");
		System.out.println(supprimer);
		
		
		if(supprimer != null &&supprimer != "") {
			System.out.println(Integer.parseInt(request.getParameter("idLigne")));
			this.daoManager.getProduitDAO().delete(Integer.parseInt(request.getParameter("idLigne")));

		}
		
		List<Produit> produits = this.daoManager.getProduitDAO().list();

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

		if (request.getParameter("nomProduit") != null && request.getParameter("nomProduit") != "" 
				&& request.getParameter("prixProduit") != null && request.getParameter("prixProduit") != "") {
			String nomProduit = request.getParameter("nomProduit");
			Double prixProduit = Double.parseDouble(request.getParameter("prixProduit"));

			this.daoManager.start();
			Produit newPdt = new Produit(nomProduit, TypeProduit.PLAT, prixProduit);
			this.daoManager.getProduitDAO().create(newPdt);
			this.daoManager.stop();

		}
		if (request.getParameter("nomBoisson") != null && request.getParameter("nomBoisson") != ""
				&& request.getParameter("prixBoisson") != null && request.getParameter("prixBoisson") != "") {
			String nomBoisson = request.getParameter("nomBoisson");
			Double prixBoisson = Double.parseDouble(request.getParameter("prixBoisson"));

			this.daoManager.start();
			Produit newBoisson = new Produit(nomBoisson, TypeProduit.BOISSON, prixBoisson);
			this.daoManager.getProduitDAO().create(newBoisson);
			this.daoManager.stop();
		}
		
		

		doGet(request, response);
	}
}
