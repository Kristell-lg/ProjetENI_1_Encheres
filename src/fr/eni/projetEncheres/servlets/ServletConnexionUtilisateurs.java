package fr.eni.projetEncheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author Kristell
 * Servlet implementation class ServletConnexionUtilisateurs
 */
@WebServlet("/ServletConnexionUtilisateurs")
public class ServletConnexionUtilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/JSPConnexionUtilisateurs.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String mot_de_passe = request.getParameter("mot_de_passe");
		

		StringBuffer sb = new StringBuffer();
		sb.append("pseudo : ").append(pseudo).append(System.lineSeparator());
		sb.append("mot_de_passe : ").append(mot_de_passe).append(System.lineSeparator());		
		response.getWriter().append(sb.toString()); 
	}

}
