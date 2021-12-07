package fr.eni.projetEncheres.dal;

public abstract class DAOFactory {
	/**
	 * @author Kristell
	 * DAO FaCtory
	 *
	 */
	public static UtilisateursDAO getUtilisateursDAO()
	{
		return new UtilisateursDAOJdbcImpl();
	}
}
