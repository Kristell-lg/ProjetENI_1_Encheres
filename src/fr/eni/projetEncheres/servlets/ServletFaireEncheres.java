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
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/JSPFaireEncheres.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		ArticlesManager articlesManager = new ArticlesManager();
		Utilisateurs utilisateur = null;
		Articles article = null;

		if (session != null) {
			utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
			article = (Articles) request.getAttribute("article");

			try {
				article = articlesManager.selectArticle(article.getNo_article());
				request.setAttribute("article", article);

				int no_utilisateur = utilisateur.getNo_utilisateur();
				int no_article = article.getNo_article();
				LocalDate date_enchere = LocalDate.now();
				;
				int montant_enchere = Integer.valueOf(request.getParameter("ma_proposition"));

				EncheresManager EncheresManager = new EncheresManager();

				try {
					Encheres enchere = new Encheres(no_utilisateur, no_article, date_enchere, montant_enchere);

					EncheresManager.ajoutEnchere(enchere);

					if (utilisateur.getCredit() > enchere.getMontant_enchere()) {

						request.setAttribute("retour", "enchère envoyée");
						RequestDispatcher rd = request.getRequestDispatcher("/AfficherArticle");
						rd.forward(request, response);
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
					request.setAttribute("retour", "échec de l'enchere");

				}

				request.setAttribute("retour", "Solde insuffisant");

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else {
			request.setAttribute("erreur", "accès à l'article à échoué!");
		}
	}

}
