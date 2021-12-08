package fr.eni.projetEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEncheres.bll.BLLException;
import fr.eni.projetEncheres.bll.UtilisateursManager;
import fr.eni.projetEncheres.bo.Utilisateurs;
import fr.eni.projetEncheres.dal.UtilisateursDAO;
import fr.eni.projetEncheres.dal.DALException;
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
		
		UtilisateursManager utilisateursManager = new UtilisateursManager();
		
		Utilisateurs u = null;
		u = utilisateursManager.selectUtilisateur(1);
		System.out.println(u);
		request.setAttribute("utilisateur", u);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPAfficherProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
