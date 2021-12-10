package fr.eni.projetEncheres.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Utilisateurs;
import fr.eni.projetEncheres.dal.ArticlesDAO;
import fr.eni.projetEncheres.dal.DAOFactory;

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

	public void AjouterArticle(Articles article) throws BLLException {
		ArticlesValidation(article);
		try {
			this.articlesDAO.insert(article);;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
}


	public List<Articles> selectionner() {

		List<Articles> ArticlesListe = new ArrayList<Articles>();

		try {
			ArticlesListe = articlesDAO.selectionner();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ArticlesListe;

	}
	
	public Articles selectArticle(int no_article) throws BLLException {

		Articles article = null;
		if (no_article!=0) {
			try {
				article = articlesDAO.selectArticle(no_article);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			throw new BLLException("Le numéro d'article ne peut être nul!");
		}
		return article;

	}
	
	private void ArticlesValidation(Articles article) throws BLLException {

		boolean dataValid = true;

		StringBuffer sb = new StringBuffer();

		// Validation Nom de l'article
		if (article.getNom_article() == null || article.getNom_article().trim().isEmpty()) {
			sb.append("Le nom de l'article est obligatoire\n");
			dataValid = false;
		}

		// Validation Description
		if (article.getDescription() == null || article.getDescription().trim().isEmpty()) {
			sb.append("La description de l'article est obligatoire\n");
			dataValid = false;
		}

		// Validation date debut d'encheres
		if (article.getDate_debut_encheres() == null || article.getDate_debut_encheres().isBefore(article.getDate_debut_encheres())) {
			sb.append("La date de début d'enchères est obligatoire et forcément antérieur à la date de fin d'enchères");
			dataValid = false;
		}
		
		// Validation date fin d'encheres
		if (article.getDate_fin_encheres() == null || article.getDate_fin_encheres().isAfter(article.getDate_fin_encheres())) {
			sb.append("La date de fin d'enchères est obligatoire et forcément posterieur à la date de début d'enchères");
			dataValid = false;
		}
		
		// Validation prix_inital 
		if (article.getPrix_initial() == 0 || article.getPrix_initial() < 0) {
			sb.append("le prix doit être supérieur à 0");
			dataValid = false;
		}

		// Validation no_utilisateur, a approfondir 
		if (article.getUtilisateur() == null ) {
			sb.append("problème au niveau du numéro d'utilisateur");
			dataValid = false;
		}
		
		// Validation no_categorie, a approfondir 
		if (article.getCategorie() == null) {
			sb.append("problème au niveau du numéro de catégorie");
			dataValid = false;
		}

		// Etat du boolean
		if (!dataValid) {
			throw new BLLException(sb.toString());
		}

		
	}

}


