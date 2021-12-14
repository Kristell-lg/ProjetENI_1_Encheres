package fr.eni.projetEncheres.servlets;

import java.io.IOException;

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
 * @author Luka CHOUVILLE
 * Servlet implementation class ServletAfficherProfil
 */
@WebServlet("/Profil")
public class ServletAfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LE GET POUR LE DETAIL DU PROFIL CONNECTE
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPAfficherProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//LE POST POUR LE DETAIL DES PROFILS EXTERIEURS
		UtilisateursManager utilisateursManager = new UtilisateursManager();
		try {
			int id = Integer.valueOf(request.getParameter("idProfil"));
			Utilisateurs utilisateur = utilisateursManager.selectUtilisateur(id);
			
			// mise en place des variable
			request.setAttribute("utilisateur",utilisateur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPAfficherProfil.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
