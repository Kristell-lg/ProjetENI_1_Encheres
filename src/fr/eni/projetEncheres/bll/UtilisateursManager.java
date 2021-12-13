/**
 * 
 */
package fr.eni.projetEncheres.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.projetEncheres.bo.Utilisateurs;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.DAOFactory;
import fr.eni.projetEncheres.dal.UtilisateursDAO;

/**
 * @author Kristell
 * @update Luka CHOUVILLE
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
	
	//METHODE Selectionner pour un utilisateur présents en BDD sur l'id
		public Utilisateurs selectUtilisateur(int no_utilisateur){

			Utilisateurs utilisateur = null;

			try {
				utilisateur = this.utilisateursDAO.selectUtilisateur(no_utilisateur);
				if (utilisateur==null) {
					System.out.println("l'utilisateur n'existe pas");
				}
			} catch (Exception e) {
				System.out.println("BLL UtilisateursManager");
				e.printStackTrace();
			}

			return utilisateur;

		}
	
	//Ajouter un utilisateur après inscription
	public void ajoutUtilisateur(Utilisateurs utilisateur) throws BLLException {
		//VERIFIER LA SAISIE
		 UtilisateurValidation(utilisateur);

		if (utilisateur!=null) {
			this.utilisateursDAO.ajoutUtilisateur(utilisateur);
		}
		else {
			System.out.println("Au moins un des champ requis est vide ou l'email/le téléphone ne respecte pas le format");
		}
	}
	
	//Supprimer un utilisateur
	public void supprimerUtilisateur(Utilisateurs utilisateur) throws Exception{
	    this.utilisateursDAO.supprimerUtilisateur(utilisateur); 
	}
	
	
	//Modification du profil de l'utilisateur
 	public void modifierUtilisateur (Utilisateurs utilisateur) throws BLLException, DALException{
 		UtilisateurValidation(utilisateur);
 		if (utilisateur!=null) {
			this.utilisateursDAO.modifierUtilisateur(utilisateur);
		}
		else {
			System.out.println("Au moins un des champ requis est vide ou l'email/le téléphone ne respecte pas le format");
		}
 		
 	}
	
		// vérification des données Utilisateur
		// rajout du statut d'admin ?
	private void UtilisateurValidation(Utilisateurs utilisateur) throws BLLException {

		boolean dataValid = true;

		StringBuffer sb = new StringBuffer();

		// Validation du Pseudo
		
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().trim().isEmpty()) {
			sb.append("Le pseudo est obligatoire\n");
			dataValid = false;
		}

		// Validation du nom
		
		if (utilisateur.getNom() == null || utilisateur.getNom().trim().isEmpty()) {
			sb.append("La nom est obligatoire\n");
			dataValid = false;
		}
		
		// Validation du prénom
		
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().trim().isEmpty()) {
			sb.append("La prenom est obligatoire\n");
			dataValid = false;
		}


		// Validation email
		
		  Pattern validEmail =
		  Pattern.compile("^[A-Z0-9._-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
		  Pattern.CASE_INSENSITIVE); Matcher matcherEmail =
		  validEmail.matcher(utilisateur.getEmail()); if (!matcherEmail.find()) {
		  sb.append("L'email n'est pas au format attendu !\n"); dataValid = false; }
		 

		// Validation du telephone
		
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().trim().isEmpty()) {
			sb.append("Le téléphone est obligatoire\n");
			dataValid = false;
		}
		
		// Validation Adresse @TO DO : REGEX SUR LE CODE POSTAL ?
		if (utilisateur.getRue() == null || utilisateur.getRue().trim().isEmpty()) {
			sb.append("La rue est obligatoire\n");
			dataValid = false;
		}

		if (utilisateur.getCode_postal() == null || utilisateur.getCode_postal().trim().isEmpty()) {
			sb.append("Le code postal est obligatoire\n");
			dataValid = false;
		}

		if (utilisateur.getVille() == null || utilisateur.getVille().trim().isEmpty()) {
			sb.append("La ville est obligatoire\n");
			dataValid = false;
		}

		// Validation mdp
		
		Pattern validMDP = Pattern.compile("^.*(?=.{8,})(?=.*\\d)(?=.*[a-zA-Z])|(?=.{8,})(?=.*\\d)(?=.*[!@#$%^&])|(?=.{8,})(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$");
	
		/*
		 * Le mot de passe doit comporter au moins huit (8) caractères lorsque le
		 * système peut le prendre en charge. Les mots de passe doivent inclure des
		 * caractères d'au moins deux (2) de ces groupements: caractères alphanumériques
		 * et spéciaux.
		 * 
		 */

		Matcher matcherMDP = validMDP.matcher(utilisateur.getMot_de_passe());
		if (!matcherMDP.find()) {
			sb.append("Le mot de passe n'est pas au format attendu !\n");
			dataValid = false;
		}
		 
		  
		 
		// Etat du boolean
		if (!dataValid) {
			throw new BLLException(sb.toString());
		}

	}
}
