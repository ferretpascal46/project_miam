package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.Enum.Role;
import fr.ldnr.groupe3.beans.Utilisateur;
import fr.ldnr.groupe3.forms.HashForm;
/**
 * Servlet implementation class Creation_new_gerant
 */
@WebServlet(name="Creation_new_gerant",urlPatterns={"/creation_gerant"})
public class Creation_new_gerant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE="/WEB-INF/gerant_creation_nouveau_gerant.jsp";
  
	private DAOManager daoManager = new DAOManager();
	    /**
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Creation_new_gerant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.daoManager.start();
		// recupération des données du formulaire
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		int newIdUtiliateur = 0;
		// obligé de passer par un try/catch à cause de la méthode de hash qui peut
		// lancer une exception
		try {
			Utilisateur newUser = new Utilisateur(email, HashForm.hash(email, password), Role.GERANT);
			newIdUtiliateur = this.daoManager.getUtilisateurDAO().create(newUser);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Probleme lors du hash : " + e);
		}
		
		this.daoManager.stop();
		doGet(request, response);
	}

}
