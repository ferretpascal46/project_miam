package fr.ldnr.groupe3.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.ldnr.groupe3.DAO.DAOManager;
import fr.ldnr.groupe3.DAO.UtilisateurDAO;
import fr.ldnr.groupe3.Enum.Role;
import fr.ldnr.groupe3.beans.Client;
import fr.ldnr.groupe3.beans.Utilisateur;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String VUE = "/WEB-INF/connexionForm.jsp";
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
         
       
		this.daoManager.start();
        Utilisateur user = new Utilisateur();
        user = daoManager.getUtilisateurDAO().findIdUtilisateur(request.getParameter("email"));
     
        		if (user != null) {
    	      if(request.getParameter("password").equals(user.getMotDePasse())) {}
                HttpSession session = request.getSession();
                System.out.println("Connecté");
                session.setAttribute("user", user);
               this.daoManager.stop();
                doGet(request, response);
                
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
                doGet(request, response);
            }
             
         
         
        
        }	  
    }


