/**
 * @author clementcorcuff
 * 
 */

package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

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

		RequestDispatcher erreurEnchere = request.getRequestDispatcher("/AfficherArticle");

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);

		ArticlesManager articlesManager = new ArticlesManager();
		Utilisateurs utilisateur = null;
		int articleId = 0;
		Articles article = null;

		Boolean ok = true;

		if (session != null) {
			utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
			articleId = Integer.valueOf(request.getParameter("articleId"));

			try {
				article = articlesManager.selectArticle(articleId);
				request.setAttribute("article", article);

				int no_utilisateur = utilisateur.getNo_utilisateur();
				LocalDateTime date_enchere = LocalDateTime.now();
				int montant_enchere = Integer.valueOf(request.getParameter("enchere"));

				EncheresManager EncheresManager = new EncheresManager();
				Encheres enchere = new Encheres(no_utilisateur, articleId, date_enchere, montant_enchere);

				Boolean dernierPrixOk = EncheresManager.VerfiEnchereArticle(articleId);
				Encheres dernierEncheres = null;
				int dernierPrix = 0;

				if (dernierPrixOk) {
					dernierEncheres = EncheresManager.selectionnerDernierEnchereArticle(articleId);
					System.out.println("dernierEnchere" + dernierEncheres);
					dernierPrix = dernierEncheres.getMontant_enchere();
				}

				List<Encheres> enchereliste = EncheresManager.selectionner();

				if (enchereliste.isEmpty()) {
					if (utilisateur.getCredit() >= enchere.getMontant_enchere()
							&& enchere.getMontant_enchere() > article.getPrix_initial()
							&& enchere.getMontant_enchere() > dernierPrix) {

						EncheresManager.ajoutEnchere(enchere);

						request.setAttribute("idArticle", articleId);
						request.setAttribute("dernierEncheresPrix", dernierPrix);

						RequestDispatcher succesEncheres = request.getRequestDispatcher("/AccueilLogIn");
						succesEncheres.forward(request, response);

					} else {
						request.setAttribute("idArticle", articleId);
						request.setAttribute("article", article);
						request.setAttribute("erreur",
								"La mise que vous avez entré n'est pas correcte ! (Rappel : vous devez avoir assez de crédits et le prix doit être supérieur à la dernière mise en vente )!");
					}
				} else {
					if (dernierEncheres.getNo_utilisateur() == no_utilisateur) {
						ok = false;
					}
				}

				// PRIMARY KEY A GERER
				if (ok) {
					System.out.println("pas d'enchère déjà");

					if (utilisateur.getCredit() >= enchere.getMontant_enchere()
							&& enchere.getMontant_enchere() > article.getPrix_initial()
							&& enchere.getMontant_enchere() > dernierPrix) {
						EncheresManager.ajoutEnchere(enchere);
						request.setAttribute("idArticle", articleId);

						request.setAttribute("dernierEncheresPrix", dernierPrix);
						RequestDispatcher succesEncheres = request.getRequestDispatcher("/AccueilLogIn");
						succesEncheres.forward(request, response);

					} else {
						request.setAttribute("idArticle", articleId);
						request.setAttribute("article", article);
						request.setAttribute("erreur",
								"La mise que vous avez entré n'est pas correcte ! (Rappel : vous devez avoir assez de crédits et le prix doit être supérieur à la dernière mise en vente )!");
					}

				} else {
					System.out.println("enchère déjà");
					request.setAttribute("idArticle", articleId);
					request.setAttribute("article", article);
					request.setAttribute("erreur",
							"Vous ne pouvez pas faire une enchère si vous êtes le dernier à avoir encheri");
				}

			} catch (Exception e) {
				System.err.println(e.getMessage());
				request.setAttribute("idArticle", articleId);
				request.setAttribute("article", article);
				request.setAttribute("erreur", "Erreur pendant la création de l'enchère est survenue");
			}

			if (request.getAttribute("erreur") != null) {
				erreurEnchere.forward(request, response);
			}
		}
	}

}
