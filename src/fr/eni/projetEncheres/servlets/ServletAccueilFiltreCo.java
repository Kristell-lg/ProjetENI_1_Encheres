package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import fr.eni.projetEncheres.bll.EncheresManager;
import fr.eni.projetEncheres.bll.UtilisateursManager;
import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Encheres;
import fr.eni.projetEncheres.bo.Utilisateurs;

/**
 * Servlet implementation class ServletAccueilFiltreCo
 */
@WebServlet("/AccueilFiltre")
public class ServletAccueilFiltreCo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
		int id = utilisateur.getNo_utilisateur();

		int filtre = 0;
		int categorie = 0;
		String recherche = null;

		// RECUPERER LES PARAMETRES DE SELECTION
		if (request.getParameter("categorie") == null) {
			
			RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPAffichageArticles.jsp");
			filtre = Integer.valueOf(request.getParameter("filtre"));

			String filtreString = null;

			switch (filtre) {
			case 1:
				filtreString = "Enchères ouvertes";
				break;
			case 2:
				filtreString = "Mes enchères en cours";
				break;
			case 3:
				filtreString = "Mes enchères remportées";
				break;
			case 4:
				filtreString = "Mes vente en cours";
				break;
			case 5:
				filtreString = "Ventes non débutées";
				break;
			case 6:
				filtreString = "Mes ventes terminées";
				break;
			default:
				break;
			}

			if (filtre == 2) {
				try {
					request.setAttribute("titre", "Filtre" + filtreString);
					// SELECTION DE TOUTES LES ENCHERES EN COURS POUR CET UTILISATEUR

					EncheresManager encheresManager = new EncheresManager();
					ArticlesManager articleManager = new ArticlesManager();
					List<Encheres> enchereListe = encheresManager.selectionner();
					List<Articles> articleListe = articleManager.selectionner();
					List<Encheres> enchereListeByID = new ArrayList<Encheres>();
					List<Articles> articleListeByID = new ArrayList<Articles>();

					for (Encheres encheres : enchereListe) {
						if (encheres.getNo_utilisateur() == id) {
							enchereListeByID.add(encheres);
						}
					}


					for (Encheres enchere : enchereListeByID) {
						for (Articles article : articleListe) {
							if (enchere.getNo_article() == article.getNo_article() && article.getDate_fin_encheres().isAfter(LocalDate.now())) {
								articleListeByID.add(article);
							}
						}
					}


					request.setAttribute("articlesListe", articleListeByID);
					succesConnexion.forward(request, response);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else if (filtre==1){
				try {
					request.setAttribute("titre", "Filtre" + filtreString);
					// SELECTION DE TOUTES LES ENCHERES EN COURS POUR CET UTILISATEUR

					ArticlesManager articleManager = new ArticlesManager();
					List<Articles> articleListe = articleManager.selectionner();
					List<Articles> articleListeByID = new ArrayList<Articles>();

					for (Articles article : articleListe) {
							if (article.getDate_fin_encheres().isAfter(LocalDate.now())) {
								articleListeByID.add(article);
							}
						}
					


					request.setAttribute("articlesListe", articleListeByID);
					succesConnexion.forward(request, response);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			else if (filtre == 3) {
				try {
					request.setAttribute("titre", "Filtre" + filtreString);
					// SELECTION DE TOUTES LES ENCHERES EN COURS POUR CET UTILISATEUR

					EncheresManager encheresManager = new EncheresManager();
					ArticlesManager articleManager = new ArticlesManager();
					List<Encheres> enchereListe = encheresManager.selectionner();
					List<Articles> articleListe = articleManager.selectionner();
					List<Encheres> enchereListeByID = new ArrayList<Encheres>();
					List<Articles> articleListeByID = new ArrayList<Articles>();

					for (Encheres encheres : enchereListe) {
						if (encheres.getNo_utilisateur() == id) {
							enchereListeByID.add(encheres);
						}
					}


					for (Encheres enchere : enchereListeByID) {
						for (Articles article : articleListe) {
							if (enchere.getNo_article() == article.getNo_article() && article.getDate_fin_encheres().isBefore(LocalDate.now())) {
								articleListeByID.add(article);
							}
						}
					}


					request.setAttribute("articlesListe", articleListeByID);
					succesConnexion.forward(request, response);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			else if (filtre == 4) {
				try {
					request.setAttribute("titre", "Filtre" + filtreString);
					// SELECTION DE TOUTES LES ENCHERES EN COURS POUR CET UTILISATEUR

					EncheresManager encheresManager = new EncheresManager();
					ArticlesManager articleManager = new ArticlesManager();
					List<Encheres> enchereListe = encheresManager.selectionner();
					List<Articles> articleListe = articleManager.selectionner();
					List<Encheres> enchereListeByID = new ArrayList<Encheres>();
					List<Articles> articleListeByID = new ArrayList<Articles>();

						for (Articles article : articleListe) {
							if (article.getUtilisateur().getNo_utilisateur() == utilisateur.getNo_utilisateur() && article.getDate_fin_encheres().isAfter(LocalDate.now())) {
								articleListeByID.add(article);
							}
						}
					
					request.setAttribute("articlesListe", articleListeByID);
					succesConnexion.forward(request, response);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			else if (filtre == 5) {
				try {
					request.setAttribute("titre", "Filtre" + filtreString);
					// SELECTION DE TOUTES LES ENCHERES EN COURS POUR CET UTILISATEUR
					ArticlesManager articleManager = new ArticlesManager();
					List<Articles> articleListe = articleManager.selectionner();
					List<Articles> articleListeByID = new ArrayList<Articles>();

						for (Articles article : articleListe) {
							if (article.getUtilisateur().getNo_utilisateur() == utilisateur.getNo_utilisateur() && article.getDate_debut_encheres().isBefore(LocalDate.now())) {
								articleListeByID.add(article);
							}
						}
					
					request.setAttribute("articlesListe", articleListeByID);
					succesConnexion.forward(request, response);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			else if (filtre == 6) {
				try {
					request.setAttribute("titre", "Filtre" + filtreString);
					// SELECTION DE TOUTES LES ENCHERES EN COURS POUR CET UTILISATEUR

					EncheresManager encheresManager = new EncheresManager();
					ArticlesManager articleManager = new ArticlesManager();
					List<Encheres> enchereListe = encheresManager.selectionner();
					List<Articles> articleListe = articleManager.selectionner();
					List<Encheres> enchereListeByID = new ArrayList<Encheres>();
					List<Articles> articleListeByID = new ArrayList<Articles>();

						for (Articles article : articleListe) {
							if (article.getUtilisateur().getNo_utilisateur() == utilisateur.getNo_utilisateur() && article.getDate_fin_encheres().isBefore(LocalDate.now())) {
								articleListeByID.add(article);
							}
						}
					
					request.setAttribute("articlesListe", articleListeByID);
					succesConnexion.forward(request, response);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			
			

		} else {
			categorie = Integer.valueOf(request.getParameter("categorie"));
			recherche = request.getParameter("recherche");
			RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPAffichageArticles.jsp");

			if (categorie == 0) {
				if (!recherche.equals(null)) {
					request.setAttribute("titre", "Articles - Recherche : " + recherche);
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
					request.setAttribute("titre",
							"Articles - Catégorie : " + categorieString + " - Recherche : " + recherche);

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
				} else if (categorie != 0) {

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

	}

}
