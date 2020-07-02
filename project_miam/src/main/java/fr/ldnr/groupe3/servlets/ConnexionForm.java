package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ldnr.groupe3.DAO.UtilisateurDAO;
import fr.ldnr.groupe3.Enum.Role;
import fr.ldnr.groupe3.beans.Client;
import fr.ldnr.groupe3.beans.Utilisateur;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/connexionForm")
public class ConnexionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String VUE = "/WEB-INF/connexionFormContent.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// recupération des données du formulaire
        String nomUser = request.getParameter("nomUser");
        String prenom = request.getParameter("prenomUser");
      
       
        /*
         * @TODO Vérifier qule schamps ne sont pas vides
         * 
         * Appeler la métode find en parm user et mot de pass de la DAO puis verfier que l'user existe bien
         * 
         * Si oui  suivant*/
         
        /*  if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "connexionForm.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
         */
        
      
        }	  
      
         
      
         
       
	}

}
