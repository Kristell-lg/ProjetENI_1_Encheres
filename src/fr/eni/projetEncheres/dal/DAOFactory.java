package fr.eni.projetEncheres.dal;

public abstract class DAOFactory {
	/**
	 * @author Kristell
	 * @modif Clément
	 * @update Luka CHOUVILLE
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
	
	public static EncheresDAO getEncheresDAO()
	{
		return new EncheresDAOJdbcImpl();
	}
	
	public static RetraitsDAO getRetraitsDAO()
	{
		return new RetraitsDAOJdbcImpl();
	}
}
