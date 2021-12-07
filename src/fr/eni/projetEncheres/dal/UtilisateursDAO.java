package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateurs;
/**
 * @author Kristell
 * DAOUtilisateur pour les méthodes à implémenter dans le JDBCImpl
 *
 */
public interface UtilisateursDAO {
	public List<Utilisateurs> selectionner();
	public void ajoutUtilisateur(Utilisateurs utilisateur);
}
