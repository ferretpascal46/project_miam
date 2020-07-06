package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.Enum.Role;
import fr.ldnr.groupe3.beans.Client;
import fr.ldnr.groupe3.beans.Utilisateur;
import fr.ldnr.groupe3.forms.HashForm;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAOManager daoManager = new DAOManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private static final String VUE = "/WEB-INF/inscription.jsp";
	private static final String URL_REDIRECTION = "/index";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("page", "inscription");

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.daoManager.start();
		Utilisateur newUser = new Utilisateur();
		// recupération des données du formulaire
		String nomUser = request.getParameter("nomUser");
		String prenom = request.getParameter("prenomUser");
		int numRue = Integer.parseInt(request.getParameter("numRue"));
		String rue = request.getParameter("rue");
		String complementAdresse = request.getParameter("complementAdresse");
		int codePostale = Integer.parseInt(request.getParameter("codePostale"));
		String Ville = request.getParameter("Ville");
		String tel = request.getParameter("Telephone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		String formSoumis = request.getParameter("formSoumis");
//		if (formSoumis != null) {
		String message = "";

		int newIdUtiliateur = 0;
		// obligé de passer par un try/catch à cause de la méthode de hash qui peut
		// lancer une exception
		try {
			newUser = new Utilisateur(email, HashForm.hash(email, password), Role.CLIENT);
			newIdUtiliateur = this.daoManager.getUtilisateurDAO().create(newUser);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Probleme lors du hash : " + e);
		}

		// test si il y a eu un problème lors de la création de l'utilisateur
		if (newIdUtiliateur != 0) {
			Client newClient = new Client();
			Date today = new Date(System.currentTimeMillis());

			newClient.setIdUtilisateur(newIdUtiliateur);
			newClient.setNom(nomUser);
			newClient.setPrenom(prenom);
			newClient.setNumeroRue(numRue);
			newClient.setRue(rue);
			newClient.setComplement(complementAdresse);
			newClient.setCodePostal(codePostale);
			newClient.setVille(Ville);
			newClient.setTelephone(tel);
			newClient.setDateCreation(today);	
			
			this.daoManager.getClientDAO().create(newClient);
			
			HttpSession session = request.getSession();
			System.out.println("Connecté");
			session.setAttribute("user", newUser);
			this.daoManager.stop();
			response.sendRedirect(getServletContext().getContextPath() + URL_REDIRECTION);					
			
		} else {
			System.out.println("Problème lors de la création du compte utilisateur");
			message = "Problème lors de la création du compte utilisateur";
			request.setAttribute("message", message);
			this.daoManager.stop();
			doGet(request, response);
		}

//		}
		
	}
}
