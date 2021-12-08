package fr.eni.projetEncheres.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Utilisateurs;
import fr.eni.projetEncheres.dal.ArticlesDAO;
import fr.eni.projetEncheres.dal.DAOFactory;
import fr.eni.projetEncheres.dal.UtilisateursDAO;


/**
 * 
 * @author Clément
 *
 *  */

public class ArticlesManager {
	
	private ArticlesDAO articlesDAO;
	
	public ArticlesManager() {
		this.articlesDAO = DAOFactory.getArticlesDAO();	
}

	public void AjouterArticle(Articles a) {
		//VALIDATION DONNEES
		System.out.println(a);
		try {
			System.out.println("j'ai réussi à passer à la DAL");
			this.articlesDAO.insert(a);;
		} catch (Exception e) {
			System.out.println("je n'ai pas à passer à la DAL");
			e.printStackTrace();
		}
		
}


	public List<Articles> selectionner() {

		List<Articles> ArticlesListe = new ArrayList<Articles>();

		try {
			ArticlesListe = this.articlesDAO.selectionner();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ArticlesListe;

	}
}


