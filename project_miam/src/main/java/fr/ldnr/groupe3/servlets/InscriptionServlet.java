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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

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
		// recupération des données du formulaire
		String nomUser = request.getParameter("nomUser");
		String prenom = request.getParameter("prenomUser");
		int numRue = Integer.parseInt(request.getParameter("numRue"));
		String rue = request.getParameter("rue");
		String complementAdresse = request.getParameter("complementAdresse");
		int codePostale = Integer.parseInt(request.getParameter("codePostale"));
		String Ville = request.getParameter("Ville");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String formSoumis = request.getParameter("SIGNUP");
		
		if (formSoumis != null) {
			System.out.println("formSoumis != null" + nomUser);

			int newIdUtiliateur = 0;
			//obligé de passer par un try/catch à cause de la méthode de hash qui peut lancer une exception
			try {
				Utilisateur newUser = new Utilisateur(email, HashForm.hash(email, password), Role.CLIENT);
				newIdUtiliateur = this.daoManager.getUtilisateurDAO().create(newUser);
			} catch (NoSuchAlgorithmException e) {
				System.out.println("Probleme lors du hash : " + e);
			}

			//test si il y a eu un problème lors de la création de l'utilisateur
			if (newIdUtiliateur != 0) {
				Client newClient = new Client();

				newClient.setIdUtilisateur(newIdUtiliateur);
				newClient.setNom(nomUser);
				newClient.setPrenom(prenom);
				newClient.setNumeroRue(numRue);
				newClient.setRue(rue);
				newClient.setComplement(complementAdresse);
				newClient.setCodePostal(codePostale);
				newClient.setVille(Ville);
				newClient.setTelephone(tel);

				this.daoManager.getClientDAO().create(newClient);
			} else {
				System.out.println("Problème lors de la création du compte utilisateur");
			}
			
		}
		this.daoManager.stop();
		doGet(request, response);
	}
}
