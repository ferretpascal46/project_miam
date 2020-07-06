package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.beans.Commande;
import fr.ldnr.groupe3.beans.LigneCommande;
import fr.ldnr.groupe3.beans.Produit;
import fr.ldnr.groupe3.beans.Utilisateur;

/**
 * Servlet implementation class Panier
 */
@WebServlet(name="Panier",urlPatterns= {"/panier"})
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE="/WEB-INF/client_panier.jsp";
	DAOManager daoManager = new DAOManager();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("page", "panier");

		daoManager.start();
		
		HttpSession session = request.getSession();
		LigneCommande lc = new LigneCommande();
		List<LigneCommande> panier = (ArrayList<LigneCommande>)session.getAttribute("panier");		
		List<Produit> produit = new ArrayList<>();
		
		for(LigneCommande commande : panier) {
			produit.add(daoManager.getProduitDAO().findProduitById(commande.getIdProduit()));
			System.out.println(produit.get(0).getNomProduit());
		}
		
		request.setAttribute("produits", produit);

		daoManager.stop();
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
