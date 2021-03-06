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

import fr.eni.projetEncheres.bll.UtilisateursManager;
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
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!TODO mettre la JSP accueil connecté!!!!!!!!!!!!!!
		RequestDispatcher succesConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPConnexionUtilisateurs.jsp");
		
		String pseudo = request.getParameter("pseudo");
		String mot_de_passe = request.getParameter("mot_de_passe");

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
							System.out.println("utilisateur connecté");
							succesConnexion.forward(request, response);
						} else {
							request.setAttribute("msgErreurConnexion", "Pseudo ou Mot de Passe erroné");
							request.setAttribute("pseudoSaisi", pseudo);
							erreurConnexion.forward(request, response);
						}
					} else {
						request.setAttribute("msgErreurConnexion", "Pseudo ou Mot de Passe erroné");
						request.setAttribute("pseudoSaisi", pseudo);
						erreurConnexion.forward(request, response);
					}
				}

			} else {
				System.out.println("Liste utilisateur nulle!");
			}
		} catch (Exception e) {
			request.setAttribute("msgErreurConnexion", "Erreur dans le chargement des données");
			erreurConnexion.forward(request, response);
			System.out.println("ServletUtilisateur");
			e.printStackTrace();
		}

	}

}
