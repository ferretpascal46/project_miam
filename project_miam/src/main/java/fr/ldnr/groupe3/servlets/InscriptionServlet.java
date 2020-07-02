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
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String VUE = "/WEB-INF/inscription.jsp";
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
		// read form fields
        String nomUser = request.getParameter("nomUser");
        String prenom = request.getParameter("prenomUser");
        int numRue = Integer. parseInt(request. getParameter("numRue"));
        String rue = request.getParameter("rue");
        String complementAdresse = request.getParameter("complementAdresse");
        int codePostale = Integer.parseInt(request.getParameter("codePostale");
        String Ville = request.getParameter("Ville");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String formSoumis = request.getParameter("SIGNUP");
        
        if(formSoumis!= null) {
        	
       
        Utilisateur newUser = new Utilisateur(email, password, Role.CLIENT);
        	 
      Client newClient = new Client();
      newClient.setIdUtilisateur(newUser.getIdUtilisateur());
      newClient.setNom(nomUser);
      newClient.setPrenom(prenom);
      newClient.setNumeroRue(numRue);
      newClient.setRue(rue);
      newClient.setComplement(complementAdresse);
      newClient.setCodePostal(codePostale);
      newClient.setVille(Ville);
     
      /*
       * @TODO  Voir avec PJ pourquoi on ne réussi pas à appeler l'Utilsareur DAO
       */
      UtilisateurDAO.this.create(newUser);
      
        }	  
      
         
      
         
       
	}

}
