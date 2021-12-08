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

	//CONSTRUCTEUR
	public UtilisateursManager() {
		this.utilisateursDAO = DAOFactory.getUtilisateursDAO();
	}

	//METHODE Selectionner pour les utilisateurs présents en BDD
	public List<Utilisateurs> selectionner() {

		List<Utilisateurs> utilisateursListe = new ArrayList<Utilisateurs>();

		try {
			utilisateursListe = this.utilisateursDAO.selectionner();
			if (utilisateursListe==null) {
				System.out.println("liste bll nulle");
			}
		} catch (Exception e) {
			System.out.println("BLL UtilisateursManager");
			e.printStackTrace();
		}

		return utilisateursListe;

	}
	
	//Ajouter un utilisateur après inscription
	public void ajoutUtilisateur(Utilisateurs utilisateur) {
		//VERIFIER LA SAISIE
		if (utilisateur.getPseudo()!=null && utilisateur.getNom()!=null && utilisateur.getPrenom()!=null && utilisateur.getEmail()!=null &&
			utilisateur.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") && utilisateur.getTelephone().matches("^(0|\\+33)[1-9]([-. ]?[0-9]{2}){4}$") 
			&& utilisateur.getRue()!=null && utilisateur.getCode_postal()!=null && utilisateur.getCode_postal().matches("\\d{2}[ ]?\\d{3}") && utilisateur.getVille()!=null && utilisateur.getMot_de_passe()!=null) {
			System.out.println("ça match les formats je peux envoyer à la DAL");
			this.utilisateursDAO.ajoutUtilisateur(utilisateur);
		}
		else {
			System.out.println("Au moins un des champ requis est vide ou l'email/le téléphone ne respecte pas le format");
		}
		
	}
	
}
