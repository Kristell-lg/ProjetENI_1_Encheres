/**
 * 
 */
package fr.eni.projetEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateurs;
import fr.eni.projetEncheres.dal.DAOFactory;
import fr.eni.projetEncheres.dal.UtilisateursDAO;

/**
 * @author Kristell
 * BLL Utilisateur
 */
public class UtilisateursManager {

	private UtilisateursDAO utilisateursDAO;

	public UtilisateursManager() {
		this.utilisateursDAO = DAOFactory.getUtilisateursDAO();
	}

	public List<Utilisateurs> selectionner() {

		List<Utilisateurs> utilisateursListe = new ArrayList<Utilisateurs>();

		try {
			utilisateursListe = this.utilisateursDAO.selectionner();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return utilisateursListe;

	}
}
