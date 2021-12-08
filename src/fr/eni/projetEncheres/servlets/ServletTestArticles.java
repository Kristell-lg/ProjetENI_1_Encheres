package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEncheres.bll.ArticlesManager;
import fr.eni.projetEncheres.bo.Articles;



/**
 * Servlet implementation class ServletTestArticles
 */
@WebServlet("/ServletTestArticles")
public class ServletTestArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/testArticles.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no_article = Integer.parseInt(request.getParameter("no_article"));
		String nom_article = request.getParameter("nom_article");
		String description = request.getParameter("description");
		String date_debut_encheres = request.getParameter("date_debut_encheres");
		String date_fin_encheres = request.getParameter("date_fin_encheres");
		int prix_initial = Integer.parseInt(request.getParameter("prix_initial"));
		int no_utilisateur = Integer.parseInt(request.getParameter("no_utilisateur")); 
		int no_categorie = Integer.parseInt(request.getParameter("no_categorie"));
		 
		
		ArticlesManager ArticlesManager = new ArticlesManager();
		
		try {
			Articles a = new Articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie);
					
			ArticlesManager.AjouterArticle(a);
			request.setAttribute("retour", "insertion de l'article à réussi");
			request.setAttribute("Articles", a);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/testArticles.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.setAttribute("retour", "insertion d'article à échoué");	
	}

}
}
