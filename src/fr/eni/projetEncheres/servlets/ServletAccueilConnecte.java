package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.bll.ArticlesManager;
import fr.eni.projetEncheres.bll.UtilisateursManager;
import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Utilisateurs;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/AccueilLogIn")
public class ServletAccueilConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPAffichageArticles.jsp");
		

		HttpSession session = request.getSession();
		
		if (session!=null) {
			UtilisateursManager manager = new UtilisateursManager();
			Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
			session.setAttribute("utilisateur", utilisateur); 
			succesConnexion.forward(request, response);
		}
		
		// SELECTION DE TOUS LES ARTICLES
		try {
			ArticlesManager articlesManager = new ArticlesManager();
			List<Articles> articlesListe = articlesManager.selectionner();
			System.out.println(articlesListe);
			request.setAttribute("articlesListe", articlesListe);
			succesConnexion.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
