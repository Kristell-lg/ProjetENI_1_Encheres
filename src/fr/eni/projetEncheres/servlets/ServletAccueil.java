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

import fr.eni.projetEncheres.bll.ArticlesManager;
import fr.eni.projetEncheres.bo.Articles;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/Accueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response )
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil/pageAccueil.jsp");
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
		
		if (request.getParameter("categorie")!= null | request.getParameter("recherche") !=null) {
			
		
		
		int categorie = Integer.valueOf(request.getParameter("categorie"));
		String recherche = request.getParameter("recherche");

		if (categorie == 0) {
			if (!recherche.equals(null)) {
				request.setAttribute("titre", "Articles - Recherche : "+recherche);
				RequestDispatcher succesConnexion = request
						.getRequestDispatcher("/WEB-INF/jsp/pageAccueil/pageAccueil.jsp");
				// SELECTION DE TOUS LES ARTICLES
				try {
					ArticlesManager articlesManager = new ArticlesManager();
					List<Articles> articlesListe = articlesManager.selectionner();

					List<Articles> articlesListeRecherche = new ArrayList<Articles>();
					for (Articles articles : articlesListe) {
						if (articles.getNom_article().toLowerCase().contains(recherche.toLowerCase())) {
							articlesListeRecherche.add(articles);
						}
					}

					request.setAttribute("articlesListe", articlesListeRecherche);
					succesConnexion.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				// AUCUNE SAISIE DE RECHERCHE
				RequestDispatcher erreurCatalogue = request
						.getRequestDispatcher("/WEB-INF/jsp/pageAccueil/pageAccueil.jsp");
				request.setAttribute("erreur", "Aucune categorie n'a été selectionnée");
				erreurCatalogue.forward(request, response);
			}

		} else {
			if (!recherche.equals(null)) {
				
				String categorieString = null;
				switch (categorie) {
				case 1:
					categorieString = "Informatique";
					break;
				case 2:
					categorieString = "Ameublement";
					break;
				case 3:
					categorieString = "Vêtement";
					break;
				case 4:
					categorieString = "Sport et Loisirs";
					break;

				default:
					break;
				}

				// Attribut pour affichage de la catégorie
				request.setAttribute("titre", "Articles - Catégorie : " + categorieString+" - Recherche : "+recherche);

				RequestDispatcher succesConnexion = request
						.getRequestDispatcher("/WEB-INF/jsp/pageAccueil/pageAccueil.jsp");
				// SELECTION DES ARTICLES EN FONCTION DE LA CATEGORIE
				try {
					ArticlesManager articlesManager = new ArticlesManager();
					List<Articles> articlesListe = articlesManager.selectionnerCategorie(categorie);
					
					List<Articles> articlesListeRecherche = new ArrayList<Articles>();
					for (Articles articles : articlesListe) {
						if (articles.getNom_article().toLowerCase().contains(recherche.toLowerCase())) {
							articlesListeRecherche.add(articles);
						}
					}

					
					request.setAttribute("articlesListe", articlesListeRecherche);
					succesConnexion.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {

				String categorieString = null;
				switch (categorie) {
				case 1:
					categorieString = "Informatique";
					break;
				case 2:
					categorieString = "Ameublement";
					break;
				case 3:
					categorieString = "Vêtement";
					break;
				case 4:
					categorieString = "Sport et Loisirs";
					break;

				default:
					break;
				}

				// Attribut pour affichage de la catégorie
				request.setAttribute("titre", "Articles - Catégorie : " + categorieString);

				RequestDispatcher succesConnexion = request
						.getRequestDispatcher("/WEB-INF/jsp/pageAccueil/pageAccueil.jsp");
				// SELECTION DES ARTICLES EN FONCTION DE LA CATEGORIE
				try {
					ArticlesManager articlesManager = new ArticlesManager();
					List<Articles> articlesListe = articlesManager.selectionnerCategorie(categorie);
					request.setAttribute("articlesListe", articlesListe);
					succesConnexion.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		}
		else {
			RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil/pageAccueil.jsp");
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

	}

}
