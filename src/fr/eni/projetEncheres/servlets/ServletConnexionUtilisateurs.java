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
 * @author Kristell Servlet implementation class ServletConnexionUtilisateurs
 */
@WebServlet("/ServletConnexionUtilisateurs")
public class ServletConnexionUtilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPConnexionUtilisateurs.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher erreurConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPConnexionUtilisateurs.jsp");
		RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPAffichageArticles.jsp");
		
		String pseudo = request.getParameter("pseudo");
		String mot_de_passe = request.getParameter("mot_de_passe");
	
		int id = 0;
		Boolean logIn = false;

		List<Utilisateurs> listeUtilisateursBDD = new ArrayList<>();
		UtilisateursManager utilisateursManager = new UtilisateursManager();

		try {
			listeUtilisateursBDD = utilisateursManager.selectionner();
			if (listeUtilisateursBDD != null) {
				for (Utilisateurs utilisateurs : listeUtilisateursBDD) {
					//CHERCHER DANS LA BDD - si un pseudo correpond à celui entré par l'utilisateur
					if (utilisateurs.getPseudo().trim().equals(pseudo)) {
						//CHERCHER DANS LA BDD - si le mot de passe correspond à ce pseudo
						if (utilisateurs.getMot_de_passe().trim().equals(mot_de_passe)) {
							logIn = true;	
							id = utilisateurs.getNo_utilisateur();
						} else {
							request.setAttribute("msgErreurConnexion", "Pseudo ou Mot de Passe erroné");
							request.setAttribute("pseudoSaisi", pseudo);
						}
					} else {
						request.setAttribute("msgErreurConnexion", "Pseudo ou Mot de Passe erroné");
						request.setAttribute("pseudoSaisi", pseudo);
					}
				}

			} else {
				System.out.println("Liste utilisateur nulle!");
			}
		} catch (Exception e) {
			request.setAttribute("msgErreurConnexion", "Erreur dans le chargement des données");
			System.out.println("henlo3");
			erreurConnexion.forward(request, response);
			e.printStackTrace();
		}
		
		//DETERMINER SI LA RECHERCHE DANS BDD A MATCH LA SAISIE UTILISATEUR OU PAS
		if (logIn) {
			
			ArticlesManager articlesManager = new ArticlesManager();
			
			try {
				List<Articles> articlesListe = articlesManager.selectionner();
				request.setAttribute("articlesListe", articlesListe);
				
				HttpSession session = request.getSession();
				
				if (session!=null) {
					UtilisateursManager manager = new UtilisateursManager();
					Utilisateurs utilisateur = manager.selectUtilisateur(id);
					session.setAttribute("utilisateur", utilisateur); 
					succesConnexion.forward(request, response);
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
				request.setAttribute("retour", "insertion d'article à échoué!");	
			}
			
		}
		else {
			erreurConnexion.forward(request, response);
		}
	        //TODO Réécriture du lien si le client n'accepte pas les cookies 						
	   


	}

}
