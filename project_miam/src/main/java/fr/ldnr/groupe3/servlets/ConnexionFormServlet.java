package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.Enum.Role;
import fr.ldnr.groupe3.beans.Utilisateur;
import fr.ldnr.groupe3.forms.HashForm;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/connexionForm")
public class ConnexionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOManager daoManager = new DAOManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private static final String VUE = "/WEB-INF/connexionForm.jsp";
	private static final String URL_REDIRECTION = "/index";

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
		Utilisateur user = new Utilisateur();
		String adresseMail = request.getParameter("email");
		String motDePasse = request.getParameter("password");
		String hashedPass = "";
		String message = "";
		

		try {
			hashedPass = HashForm.hash(adresseMail, motDePasse);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Probleme lors du hash : " + e);
		}

		user = daoManager.getUtilisateurDAO().findUtilisateurByMail(adresseMail);
		
		if ((user != null)&&(hashedPass.equals(user.getMotDePasse()))){			
			HttpSession session = request.getSession();
			System.out.println("Connecté");
			session.setAttribute("user", user);
			this.daoManager.stop();
			response.sendRedirect(getServletContext().getContextPath() + URL_REDIRECTION);
			
		} else {
			message = "Invalid email/password";
			System.out.println(message);
			request.setAttribute("message", message);
			this.daoManager.stop();
			doGet(request, response);
		}
		
	}
}
