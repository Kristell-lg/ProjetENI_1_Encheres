package fr.eni.projetEncheres.dal;

public abstract class DAOFactory {
	/**
	 * @author Kristell
	 * DAO Factory
	 *
	 */
	public static UtilisateursDAO getUtilisateursDAO()
	{
		return new UtilisateursDAOJdbcImpl();
	}
}
