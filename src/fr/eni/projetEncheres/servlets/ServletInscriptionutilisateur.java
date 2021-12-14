package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEncheres.bll.UtilisateursManager;
import fr.eni.projetEncheres.bo.Utilisateurs;

/**@author Kristell Servlet implementation class ServletConnexionUtilisateurs
 * Servlet implementation class ServletInscriptionutilisateur
 */
@WebServlet("/Inscription")
public class ServletInscriptionutilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPInscriptionUtilisateur.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher erreurInscription = request.getRequestDispatcher("/WEB-INF/jsp/JSPInscriptionUtilisateur.jsp");
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!TODO mettre la JSP accueil connecté!!!!!!!!!!!!!
		//RequestDispatcher succesInscription = request.getRequestDispatcher("/Connexion");
		
		UtilisateursManager utilisateursManager = new UtilisateursManager();
		
		String pseudo = request.getParameter("pseudo");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String mdp = request.getParameter("mdp");
		String mdpVerif = request.getParameter("mdpVerif");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String codepostal = request.getParameter("codepostal");
	
		
		//Vérification que le mot de passe et la confirmation de mot de passe correspond sinon renvoie au formulaire inscription
		if (mdp.equals(mdpVerif)) {
			try {
				//UNICITE EMAIL & PSEUDO
				List<Utilisateurs> listeUtilisateurs =   utilisateursManager.selectionner();
				Boolean ok = false;
				
				request.setAttribute("pseudo", pseudo);
				request.setAttribute("prenom", prenom);
				request.setAttribute("nom", nom);
				request.setAttribute("email", email);
				request.setAttribute("tel", tel);
				request.setAttribute("rue", rue);
				request.setAttribute("ville", ville);
				request.setAttribute("codepostal", codepostal);
				
				for (Utilisateurs utilisateurs : listeUtilisateurs) {
					if (utilisateurs.getPseudo().trim().equalsIgnoreCase(pseudo) |utilisateurs.getEmail().trim().equalsIgnoreCase(pseudo)) {
						throw new Exception();
					}
					else {
						ok = true;
					}
				}
				
				if (ok) {
					Utilisateurs utilisateur = new Utilisateurs(pseudo, nom,prenom,email,tel,rue,codepostal,ville,mdp,0);
					utilisateursManager.ajoutUtilisateur(utilisateur);
					response.sendRedirect(request.getContextPath()+"/Connexion");
				}
				
			}
			catch(Exception e) {
				request.setAttribute("erreur", "Erreur - l'inscription n'a pas pu aboutir (email ou mot de passe déjà utilisés)");
				erreurInscription.forward(request, response);
				e.printStackTrace();
			}
		} else {
			request.setAttribute("erreur", "Le mot de passe et la confirmation de mot de passe ne correspondent pas. ");
			erreurInscription.forward(request, response);
		}
	}
	

}
