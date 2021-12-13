package fr.eni.projetEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEncheres.bll.UtilisateursManager;
import fr.eni.projetEncheres.bo.Utilisateurs;

/**
 * Servlet implementation class ServletModifierUtilisateurTest
 */
@WebServlet("/ModifierProfil")
public class ServletModifierUtilisateurTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPModifierProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateursManager utilisateursManager = new UtilisateursManager();
		
		//TEMPORAIRE
		int id = 1;
		id= Integer.parseInt(request.getParameter("no_utilisateur"));
		
		try {
			
			Utilisateurs utilisateurModif = utilisateursManager.selectUtilisateur(id);
			
			if (utilisateurModif!=null) {
				// mise en place des variable
				request.setAttribute("pseudo",(String)utilisateurModif.getPseudo());
				request.setAttribute("prenom",(String)utilisateurModif.getPrenom());
				request.setAttribute("nom",(String)utilisateurModif.getNom());
				request.setAttribute("email",(String)utilisateurModif.getEmail());
				request.setAttribute("tel",(String)utilisateurModif.getTelephone());
				request.setAttribute("rue",(String)utilisateurModif.getRue());
				request.setAttribute("ville",(String)utilisateurModif.getVille());
				request.setAttribute("cp",(String)utilisateurModif.getCode_postal());
			}
			else {
				request.setAttribute("erreur", "L'utilisateur remonté est null");
				RequestDispatcher erreur = request.getRequestDispatcher("/WEB-INF/jsp/JSPModifierProfil.jsp");
				erreur.forward(request, response);
			}
			
			RequestDispatcher succes = request.getRequestDispatcher("/WEB-INF/jsp/JSPAfficherProfil.jsp");
			succes.forward(request, response);
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
	}

}
