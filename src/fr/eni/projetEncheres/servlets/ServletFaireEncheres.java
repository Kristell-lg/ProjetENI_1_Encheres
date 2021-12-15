/**
 * @author clementcorcuff
 * 
 */

package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.bll.ArticlesManager;
import fr.eni.projetEncheres.bll.EncheresManager;
import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Encheres;
import fr.eni.projetEncheres.bo.Utilisateurs;
import fr.eni.projetEncheres.dal.UtilisateursDAO;

/**
 * Servlet implementation class ServletFaireEncheres
 */
@WebServlet("/FaireEncheres")
public class ServletFaireEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/JSPAffichageArticles.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);
		
		ArticlesManager articlesManager = new ArticlesManager();
		Utilisateurs utilisateur = null;
		int articleId = 0;
		Articles article = null;

		if (session != null) {
			utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
			articleId = Integer.valueOf(request.getParameter("articleId"));

			try {
				article = articlesManager.selectArticle(articleId);
				request.setAttribute("article", article);

				int no_utilisateur = utilisateur.getNo_utilisateur();
				LocalDate date_enchere = LocalDate.now();
				
				int montant_enchere = Integer.valueOf(request.getParameter("enchere"));

				EncheresManager EncheresManager = new EncheresManager();

				Encheres enchere = new Encheres(no_utilisateur, articleId, date_enchere, montant_enchere);

				

				//PRIMARY KEY A GERER
				
				if (utilisateur.getCredit() >= enchere.getMontant_enchere()) {
					EncheresManager.ajoutEnchere(enchere);
					request.setAttribute("retour", "enchère envoyée");
					request.setAttribute("idArticle", articleId);
					RequestDispatcher succesEncheres = request.getRequestDispatcher("/AccueilLogIn");
					succesEncheres.forward(request, response);

				}
				else {
					request.setAttribute("idArticle", articleId);
					request.setAttribute("article", article);
					request.setAttribute("erreur", "Vous n'avez pas assez de crédit pour faire cette enchère");
					RequestDispatcher erreurEnchere = request.getRequestDispatcher("/AfficherArticle");
					erreurEnchere.forward(request, response);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				if (e.getMessage().contains("SQL")) {
					System.out.println("henlo1");
					request.setAttribute("idArticle", articleId);
					request.setAttribute("article", article);
					request.setAttribute("erreur", "Vous ne pouvez pas faire d'enchère sur l'article si vous êtes le dernier à avoir enchéri !");
					RequestDispatcher erreurEnchere = request.getRequestDispatcher("/AfficherArticle");
					erreurEnchere.forward(request, response);
					
				}
			}
		}
	}

}
