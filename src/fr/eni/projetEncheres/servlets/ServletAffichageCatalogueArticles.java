package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEncheres.bll.ArticlesManager;
import fr.eni.projetEncheres.bo.Articles;

/**@author Clement
 * @update Kristell Servlet implementation class ServletConnexionUtilisateurs
 */

/**
 * Servlet implementation class ServletAffichageCatalogueArticles
 */
@WebServlet("/ServletAffichageCatalogueArticles")
public class ServletAffichageCatalogueArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAffichageCatalogueArticles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticlesManager articlesManager = new ArticlesManager();
		
		try {
			List<Articles> articlesListe = articlesManager.selectionner();
			request.setAttribute("articlesListe", articlesListe);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPAffichageArticles.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.setAttribute("retour", "insertion d'article à échoué!");	
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
