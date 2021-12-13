package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.bll.UtilisateursManager;
import fr.eni.projetEncheres.bo.Utilisateurs;

/**
 * Servlet implementation class ServletModifierUtilisateurTest
 */
@WebServlet("/ModifierProfil")
public class ServletModifierUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPModifierProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher erreurConnexion = request.getRequestDispatcher("/WEB-INF/jsp/JSPModifierProfil.jsp");
		UtilisateursManager utilisateursManager = new UtilisateursManager();

		// TEMPORAIRE
		HttpSession session = request.getSession();
		Utilisateurs utilisateurConnecte = (Utilisateurs) session.getAttribute("utilisateur");
		boolean Ok = true;

		try {
			// VERIFIER L'UNICITE DU PSEUDO & DE L'EMAIL
			List<Utilisateurs> utilisateurs = utilisateursManager.selectionner();
			
			for (Utilisateurs u : utilisateurs) {
				if (u.getNo_utilisateur() != utilisateurConnecte.getNo_utilisateur()
						&& u.getPseudo().equals(request.getParameter("pseudo"))) {
					Ok = false;
					request.setAttribute("erreur", "Ce pseudo existe déjà");
				} else {
					if (u.getNo_utilisateur() != utilisateurConnecte.getNo_utilisateur() && u.getEmail().equals(request.getParameter("email"))) {
						Ok = false;
						request.setAttribute("erreur", "Cet email est déjà utilisé");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		if (Ok) {
		if (request.getParameter("exmdp").equals(utilisateurConnecte.getMot_de_passe())) {
			if (request.getParameter("mdp")==null) {
				try {
					Utilisateurs utilisateur = new Utilisateurs(request.getParameter("pseudo"),
							request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"),
							request.getParameter("tel"), request.getParameter("rue"),
							request.getParameter("codepostal"), request.getParameter("ville"),
							request.getParameter("exmdp"), 0);
					int id = utilisateurConnecte.getNo_utilisateur();

					utilisateursManager.modifierUtilisateur(utilisateur, id);

					Utilisateurs utilisateurNouveau = utilisateursManager.selectUtilisateur(id);
					session.setAttribute("utilisateur", utilisateurNouveau);

					RequestDispatcher succes = request.getRequestDispatcher("/WEB-INF/jsp/JSPAfficherProfil.jsp");
					succes.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				if (request.getParameter("mdp").equals(request.getParameter("mdpVerif"))) {
					if (!request.getParameter("mdp").equals(request.getParameter("exmdp"))) {
						System.out.println("sans mdp");
						try {
							Utilisateurs utilisateur = new Utilisateurs(request.getParameter("pseudo"),
									request.getParameter("nom"), request.getParameter("prenom"),
									request.getParameter("email"), request.getParameter("tel"),
									request.getParameter("rue"), request.getParameter("codepostal"),
									request.getParameter("ville"), request.getParameter("mdp"), 0);
							System.out.println(utilisateur);
							int id = utilisateurConnecte.getNo_utilisateur();

							utilisateursManager.modifierUtilisateur(utilisateur, id);
							Utilisateurs utilisateurNouveau = utilisateursManager.selectUtilisateur(id);
							session.setAttribute("utilisateur", utilisateurNouveau);

							RequestDispatcher succes = request.getRequestDispatcher("/WEB-INF/jsp/JSPAfficherProfil.jsp");
							succes.forward(request, response);

						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						// Le nouveau mdp correspond à l'ancien mdp
						request.setAttribute("erreur","L'ancien mot de passe et le nouveau mot de passe ne peuvent correspondre!");
					}
				} else {
					// Le nouveau mdp ne correspond pas à la verif du nouveau mdp
					request.setAttribute("erreur","Le mot de passe et la confirmation de mot de passe ne correpsondent pas!");
				}

			}

		} else {
			// Le mdp ne correspond pas à l'ancien mdp
			request.setAttribute("erreur", "Mot de passe erroné !");
		}

	}
	else {
		erreurConnexion.forward(request, response);
	}

	}
}
