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

	public Articles AjouterArticle(Articles a) {
		System.out.println(a);
		try {
			this.articlesDAO.insert(a);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	return a;
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


