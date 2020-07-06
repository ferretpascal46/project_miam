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
 * Servlet implementation class Commande
 */
@WebServlet(name="Commande",urlPatterns= {"/commande"})
public class Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE="/WEB-INF/client_commande.jsp";    
	DAOManager daoManager = new DAOManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("page", "commande");

		daoManager.start();
		List<Produit> produit = daoManager.getProduitDAO().list();
		
		/*HashMap<Client,String> hmUtilisateurs = new HashMap<Client, String>();
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getRole() == Role.CLIENT ) {
				for (Client client : clients) {
					if(client.getIdUtilisateur() == utilisateur.getIdUtilisateur()) {
						hmUtilisateurs.put(client, utilisateur.getAdresseMail());
					}
				}
			}			
		}
		*/
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
