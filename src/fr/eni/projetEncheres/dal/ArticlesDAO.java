package fr.eni.projetEncheres.dal;

import java.util.List;
import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Utilisateurs;

/**
 * 
 * @author Clément
 *
 */

public interface ArticlesDAO {
	public List<Articles> selectionner();

	public void insert(Articles article);

}
