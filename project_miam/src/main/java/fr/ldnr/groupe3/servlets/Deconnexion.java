package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Deconnexion", urlPatterns = { "/deconnexion" })
public class Deconnexion extends HttpServlet {

	private static final String URL_REDIRECTION = "/index";

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		/* Redirection vers le formulaire de connexion */
		response.sendRedirect(getServletContext().getContextPath() + URL_REDIRECTION);
	}
}
