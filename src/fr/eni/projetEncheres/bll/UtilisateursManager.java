/**
 * 
 */
package fr.eni.projetEncheres.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.projetEncheres.bll.BLLException;
import fr.eni.projetEncheres.bo.Utilisateurs;
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
	
	public void supprimerUtilisateur(Utilisateurs utilisateur) throws Exception{

	    this.utilisateursDAO.supprimerUtilisateur(utilisateur); 
	}
	
	
	
		// vérification des données Utilisateur
		// rajout du statut d'admin ?
	private void UtilisateurValidation(String pseudo, String nom, String prenom, String email,String telephone,String rue, String code_postal, String ville, String mot_de_passe, int credit) throws BLLException {

		boolean dataValid = true;

		StringBuffer sb = new StringBuffer();

		// Validation du Pseudo
		
		if (pseudo == null || pseudo.trim().isEmpty()) {
			sb.append("Le pseudo est obligatoire\n");
			dataValid = false;
		}

		// Validation du nom
		
		if (nom == null || nom.trim().isEmpty()) {
			sb.append("La nom est obligatoire\n");
			dataValid = false;
		}
		
		// Validation du prénom
		
		if (prenom == null || prenom.trim().isEmpty()) {
			sb.append("La prenom est obligatoire\n");
			dataValid = false;
		}


		// Validation email
		
		Pattern validEmail = Pattern.compile("^[A-Z0-9._-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcherEmail = validEmail.matcher(email);
		if (!matcherEmail.find()) {
			sb.append("L'email n'est pas au format attendu !\n");
			dataValid = false;
		}

		// Validation du telephone
		
		if (telephone == null || telephone.trim().isEmpty()) {
			sb.append("Le téléphone est obligatoire\n");
			dataValid = false;
		}
		
		// Validation Adresse @TO DO : REGEX SUR LE CODE POSTAL ?
		if (rue == null || rue.trim().isEmpty()) {
			sb.append("La rue est obligatoire\n");
			dataValid = false;
		}

		if (code_postal == null || code_postal.trim().isEmpty()) {
			sb.append("Le code postal est obligatoire\n");
			dataValid = false;
		}

		if (ville == null || ville.trim().isEmpty()) {
			sb.append("La ville est obligatoire\n");
			dataValid = false;
		}

		// Validation mdp
		
		Pattern validMDP = Pattern.compile("^[a-zA-Z0-9]{4,}$");
		Matcher matcherMDP = validMDP.matcher(mot_de_passe);
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
