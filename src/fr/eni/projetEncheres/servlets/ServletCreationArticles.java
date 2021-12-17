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
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.bll.ArticlesManager;
import fr.eni.projetEncheres.bll.RetraitsManager;
import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Categories;
import fr.eni.projetEncheres.bo.Retraits;
import fr.eni.projetEncheres.bo.Utilisateurs;



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
		request.setAttribute("now", LocalDate.now());
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//CREATION D'ARTICLE
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String nom_article = request.getParameter("nom_article");
		String description = request.getParameter("description");
		LocalDate date_debut_encheres = LocalDate.parse(request.getParameter("date_debut_encheres"), formatter);
		LocalDate date_fin_encheres = LocalDate.parse(request.getParameter("date_fin_encheres"), formatter);
		int prix_initial = Integer.parseInt(request.getParameter("prix_initial")); 
		
		int categorieSaisie = Integer.valueOf(request.getParameter("categorie"));
		
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		
		Categories categorie = new Categories(categorieSaisie);
		HttpSession session = request.getSession();
		
		Utilisateurs utilisateur = null;
		if (session!=null) {
			utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
		}
		else {
			request.setAttribute("erreur", "Utilisateur inconnu");
		}
		
		ArticlesManager articlesManager = new ArticlesManager();
		RetraitsManager retraitsManager = new RetraitsManager();
		
		try {
			Articles a = new Articles(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, utilisateur, categorie);
			articlesManager.AjouterArticle(a);
			
			Retraits r = new Retraits(a, rue, code_postal, ville);
			retraitsManager.ajouter(r);
			
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
