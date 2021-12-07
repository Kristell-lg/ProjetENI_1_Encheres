package fr.eni.projetEncheres.dal;

public abstract class DAOFactory {
	/**
	 * @author Kristell
	 * 
	 * @modif Clément
	 * DAO Factory
	 *
	 */
	public static UtilisateursDAO getUtilisateursDAO()
	{
		return new UtilisateursDAOJdbcImpl();
	}
	
	public static ArticlesDAO getArticlesDAO()
	{
		return new ArticlesDAOJbdcImpl();
	}
}
