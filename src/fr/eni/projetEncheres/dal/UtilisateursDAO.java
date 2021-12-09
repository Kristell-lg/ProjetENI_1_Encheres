package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateurs;
/**
 * @author Kristell
 * @update Luka CHOUVILLE
 * DAOUtilisateur pour les méthodes à implémenter dans le JDBCImpl
 *
 */
public interface UtilisateursDAO {
	public List<Utilisateurs> selectionner();
	public void ajoutUtilisateur(Utilisateurs utilisateur);
	public Utilisateurs selectUtilisateur(int no_utilisateur) throws DALException;
	public void supprimerUtilisateur(Utilisateurs u) throws Exception;
}
