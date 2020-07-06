package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.beans.Commande;
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
		List<Commande> commandes = daoManager.getCommandeDAO().list();
		List<Commande> commandes = daoManager.getCommandeDAO().list();

		daoManager.stop();
		List<Commande> listeCommandes= new ArrayList<Commande>();

		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		// parcours les commandes
		for (Commande commande : commandes) {
			// selectionne seulement les commandes correspondant à l'utilisateur connecté
			if(commande.getIdClient() == user.getIdUtilisateur()) {
				listeCommandes.add(commande);
			}
		}
		
		for (listeCommandes commande : listeCommandes) {
			
		}
		request.setAttribute("commandes", listeCommandes);

		
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
