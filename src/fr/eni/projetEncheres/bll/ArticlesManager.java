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

	public Articles AjouterArticle(int no_artcile, String nom_article, String description, LocalDate date_debut_encheres, 
			LocalDate date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie) {
		ArticlesDAO DAOArticles = DAOFactory.getArticlesDAO();
		Articles a = null;
		DAOArticles.insert(a);

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


