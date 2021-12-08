package fr.eni.projetEncheres.dal;

import java.sql.SQLException;
import java.util.List;
import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Utilisateurs;

/**
 * 
 * @author Clément
 * DAO
 */

public interface ArticlesDAO {
	public List<Articles> selectionner() throws SQLException;

	public void insert(Articles article);
	
}
