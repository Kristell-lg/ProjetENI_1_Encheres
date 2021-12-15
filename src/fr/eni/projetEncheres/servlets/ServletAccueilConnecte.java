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
import fr.eni.projetEncheres.bll.EncheresManager;
import fr.eni.projetEncheres.bll.UtilisateursManager;
import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Encheres;
import fr.eni.projetEncheres.bo.Utilisateurs;
import fr.eni.projetEncheres.dal.DALException;

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
		RequestDispatcher erreurConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPConnexionUtilisateurs.jsp");
		RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPAffichageArticles.jsp");

		String pseudo = request.getParameter("pseudo");
		String mot_de_passe = request.getParameter("mot_de_passe");

		int id = 0;

		List<Utilisateurs> listeUtilisateursBDD = new ArrayList<>();
		UtilisateursManager utilisateursManager = new UtilisateursManager();

		try {
			listeUtilisateursBDD = utilisateursManager.selectionner();

			if (listeUtilisateursBDD != null) {
				for (Utilisateurs utilisateurs : listeUtilisateursBDD) {
					// CHERCHER DANS LA BDD - si un pseudo correpond à celui entré par l'utilisateur
					if (utilisateurs.getPseudo().trim().equals(pseudo)) {
						// CHERCHER DANS LA BDD - si le mot de passe correspond à ce pseudo
						if (utilisateurs.getMot_de_passe().trim().equals(mot_de_passe)) {
							id = utilisateurs.getNo_utilisateur();

						}
					}
				}

			} else {
				System.out.println("Liste utilisateur nulle!");
			}
		} catch (Exception e) {
			request.setAttribute("erreur", "Erreur dans le chargement des données");
			erreurConnexion.forward(request, response);
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		if (session != null) {
			Utilisateurs utilisateur = (Utilisateurs) session.getAttribute("utilisateur");
			session.setAttribute("utilisateur", utilisateur);
		}

		// SELECTION DE TOUS LES ARTICLES
		try {
			ArticlesManager articlesManager = new ArticlesManager();
			List<Articles> articlesListe = articlesManager.selectionner();
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

		
		String pseudo = request.getParameter("pseudo");
		String mot_de_passe = request.getParameter("mot_de_passe");

		int id = 0;

		List<Utilisateurs> listeUtilisateursBDD = new ArrayList<>();
		UtilisateursManager utilisateursManager = new UtilisateursManager();
		listeUtilisateursBDD = utilisateursManager.selectionner();

		if (listeUtilisateursBDD != null) {
			for (Utilisateurs utilisateurs : listeUtilisateursBDD) {
				// CHERCHER DANS LA BDD - si un pseudo correpond à celui entré par l'utilisateur
				if (utilisateurs.getPseudo().trim().equals(pseudo)) {
					// CHERCHER DANS LA BDD - si le mot de passe correspond à ce pseudo
					if (utilisateurs.getMot_de_passe().trim().equals(mot_de_passe)) {
						id = utilisateurs.getNo_utilisateur();

					}
				}
			}

			int categorie = Integer.valueOf(request.getParameter("categorie"));
			String recherche = request.getParameter("recherche");

			if (categorie == 0) {
				if (!recherche.equals(null)) {
					request.setAttribute("titre", "Articles - Recherche : " + recherche);

					// SELECTION DE TOUTES LES ENCHERES EN COURS POUR CET UTILISATEUR
					try {
						EncheresManager encheresManager = new EncheresManager();
						ArticlesManager articleManager = new ArticlesManager();
						List<Encheres> enchereListe  = encheresManager.selectionner();
						List<Articles> articleListe=  articleManager.selectionner();
						List<Encheres> enchereListeByID= new ArrayList<Encheres>();
						List<Articles> 


						
						for (Encheres encheres : enchereListe) {
							if (encheres.getNo_utilisateur()==id) {
								enchereListeByID.add(encheres);
							}
						}
						for (Encheres encheres : enchereListeByID) {
							for (Articles article : articleListe) {
							}
							
						}
						}

						request.setAttribute("articlesListe", enchereListe);
						/* succesConnexion.forward(request, response); */
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
	}
}
