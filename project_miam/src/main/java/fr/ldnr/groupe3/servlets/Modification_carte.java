package fr.ldnr.groupe3.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ldnr.groupe3.DAO.DAOManager;

/**
 * Servlet implementation class Modification_carte
 */
@WebServlet(name="Modification_carte",urlPatterns= {"/modification_carte"})
public class Modification_carte extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE="/WEB-INF/gerant_modification_carte.jsp";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modification_carte() {
        super();
        // TODO Auto-generated constructor stub
    }
    //Sarah j'ai ajouté ça par rapport au cours de Herbert je ne suis pas sûr que ça soit bon
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	DAOManager daoManager = new DAOManager();
/*		daoManager.start();
    
        // Créer une liste d'objets de type produit
        List<Produit> produit = new ArrayList<>();
        // Y ajouter 3 objets
       produit.add(new Produit("nomProduit", "typeProduit", "prix");

        // Appeler la vue
       
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/gerant_modification_carte_content.jsp")
                .forward(request, response);*/
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
