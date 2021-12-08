package fr.eni.projetEncheres.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Articles;
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

	public void AjouterArticle(Articles a) {
		//VALIDATION DONNEES
		System.out.println(a);
		try {
			this.articlesDAO.insert(a);;
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
	
	private void ArticlesValidation(String nom_article, String description, LocalDate date_debut_encheres, LocalDate date_fin_encheres,int prix_initial,int no_utilisateur, int no_categorie) throws BLLException {

		boolean dataValid = true;

		StringBuffer sb = new StringBuffer();

		// Validation Nom de l'article
		if (nom_article == null || nom_article.trim().isEmpty()) {
			sb.append("Le nom de l'article est obligatoire\n");
			dataValid = false;
		}

		// Validation Description
		if (description == null || description.trim().isEmpty()) {
			sb.append("La description de l'article est obligatoire\n");
			dataValid = false;
		}

		// Validation date debut d'encheres
		if (date_debut_encheres == null || date_debut_encheres.isBefore(date_fin_encheres)) {
			sb.append("La date de début d'enchères est obligatoire et forcément antérieur à la date de fin d'enchères");
			dataValid = false;
		}
		
		// Validation date fin d'encheres
		if (date_fin_encheres == null || date_fin_encheres.isAfter(date_debut_encheres)) {
			sb.append("La date de fin d'enchères est obligatoire et forcément posterieur à la date de début d'enchères");
			dataValid = false;
		}
		
		// Validation prix_inital 
		if (prix_initial == 0 || prix_initial < 0) {
			sb.append("le prix doit être supérieur à 0");
			dataValid = false;
		}

		// Validation no_utilisateur, a approfondir 
		/*if (no_utilisateur == 0 || ??) {
			sb.append("problème au niveau du numéro d'utilisateur");
			dataValid = false;
		}*/
		
		// Validation no_categorie, a approfondir 
				/*if (no_categorie == 0 || ?? {
					sb.append("problème au niveau du numéro de catégorie");
					dataValid = false;
		}*/

		// Etat du boolean
		if (!dataValid) {
			throw new BLLException(sb.toString());
		}

		
	}

}


