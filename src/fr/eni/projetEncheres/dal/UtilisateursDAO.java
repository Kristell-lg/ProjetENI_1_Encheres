package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateurs;
/**
 * @author Kristell
 * @update Luka CHOUVILLE
 * DAOUtilisateur pour les méthodes à implémenter dans le JDBCImpl
 *@update Maxence MEDARD
 */
public interface UtilisateursDAO {
	public List<Utilisateurs> selectionner();
	public void ajoutUtilisateur(Utilisateurs utilisateur);
	public Utilisateurs selectUtilisateur(int no_utilisateur) throws DALException;
	public void supprimerUtilisateur(Utilisateurs utilisateur) throws Exception;
	public void modifierUtilisateur(Utilisateurs utilisateur)throws DALException;
}
