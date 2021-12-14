package fr.eni.projetEncheres.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.projetEncheres.bll.ArticlesManager;
import fr.eni.projetEncheres.bll.EncheresManager;
import fr.eni.projetEncheres.bll.RetraitsManager;
import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Encheres;
import fr.eni.projetEncheres.bo.Retraits;


/**
 * Servlet implementation class ServletAfficherArticle
 */
@WebServlet("/AfficherArticle")
public class ServletAfficherDetailArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPAfficherDetailArticle.jsp");	
		succesConnexion.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPAfficherDetailArticle.jsp");	
		RequestDispatcher erreurConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPAfficherDetailArticle.jsp");

		
		ArticlesManager articlesManager = new ArticlesManager();
		RetraitsManager retraitsManager = new RetraitsManager();

		
		int idArticle = Integer.valueOf(request.getParameter("idArticle"));
		if (idArticle!=0) {
			try {
				Articles article = articlesManager.selectArticle(idArticle);
				Retraits retrait = retraitsManager.selectionnerArticleID(article);
				
				request.setAttribute("article", article);
				request.setAttribute("retrait", retrait);
				
				succesConnexion.forward(request, response);
				
			} catch (Exception e) {
				System.err.println(e.getMessage());	
			}
		}
		else {
			request.setAttribute("erreur", "accès au détail de l'article à échoué!");
			erreurConnexion.forward(request, response);
		}
		
	}
}
