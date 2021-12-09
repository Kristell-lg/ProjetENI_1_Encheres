package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
@WebServlet("/ServletCreationArticles")
public class ServletCreationArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPCreationArticles.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String nom_article = request.getParameter("nom_article");
		String description = request.getParameter("description");
		LocalDate date_debut_encheres = LocalDate.parse(request.getParameter("date_debut_encheres"), formatter);
		LocalDate date_fin_encheres = LocalDate.parse(request.getParameter("date_fin_encheres"), formatter);
		int prix_initial = Integer.parseInt(request.getParameter("prix_initial"));
		//int no_utilisateur = Integer.parseInt(request.getParameter("no_utilisateur")); 
		//int no_categorie = Integer.parseInt(request.getParameter("no_categorie"));
		
		
		ArticlesManager articlesManager = new ArticlesManager();
		
		try {
			//TODO Changer utilisateurs et catégories
			Articles a = new Articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, 1, 1);
			
			articlesManager.AjouterArticle(a);
			request.setAttribute("retour", "insertion de l'article à réussi");
			List<Articles> articlesListe = articlesManager.selectionner();
			request.setAttribute("articlesListe", articlesListe);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPAffichageArticles.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			request.setAttribute("retour", "insertion d'article à échoué");	
	}

}
}
