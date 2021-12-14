/**
 * @author clementcorcuff
 * 
 */


package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.bll.EncheresManager;
import fr.eni.projetEncheres.bo.Encheres;
import fr.eni.projetEncheres.bo.Utilisateurs;
import fr.eni.projetEncheres.dal.UtilisateursDAO;

/**
 * Servlet implementation class ServletFaireEncheres
 */
@WebServlet("/FaireEncheres")
public class ServletFaireEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/JSPFaireEncheres.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 */		
		Utilisateurs utilisateur = null ;
		
		HttpSession session = request.getSession();
		
		if (session!=null) {
			utilisateur = (Utilisateurs)session.getAttribute("utilisateur");
			
		int no_utilisateur = 1;
		int no_article = 1;
		LocalDate date_enchere = LocalDate.now();
		;
		int montant_enchere = Integer.valueOf(request.getParameter("ma_proposition"));

			System.out.println("0");

			EncheresManager EncheresManager = new EncheresManager();
			
			System.out.println("1");
		
			try {
				Encheres enchere = new Encheres(no_utilisateur, no_article, date_enchere, montant_enchere);
				
				EncheresManager.ajoutEnchere(enchere);
				
				if (utilisateur.getCredit() > enchere.getMontant_enchere()) {


				request.setAttribute("retour", "enchère envoyée");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPAffichageArticles.jsp");
				rd.forward(request, response);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
				request.setAttribute("retour", "échec de l'enchere");

			}
			
			request.setAttribute("retour", "Solde insuffisant");
		}
	}
}


