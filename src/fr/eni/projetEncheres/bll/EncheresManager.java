package fr.eni.projetEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Encheres;
import fr.eni.projetEncheres.bo.Utilisateurs;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.DAOFactory;
import fr.eni.projetEncheres.dal.EncheresDAO;

public class EncheresManager {

	// ATTRIBUE

	private EncheresDAO encheresDAO;

	// CONSTRUCTEUR
	public EncheresManager()

	{
		this.encheresDAO = DAOFactory.getEncheresDAO();

	}

	// METHODE
	public List<Encheres> selectionner() throws BLLException { // SELECT_TOUT ENCHERE //

		List<Encheres> EncheresListe = new ArrayList<Encheres>();

		try {
			EncheresListe = encheresDAO.selectionner();
			System.out.println("BLL"+EncheresListe);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BLLException("Echec Recuperation Enchere 1  : ", e);
		}

		return EncheresListe;
	}

	public void ajoutEnchere(Encheres enchere) throws BLLException { // INSERT ENCHERE //
		Encheres derEnchere = null;
		try {
			UtilisateursManager utilisateursManager = new UtilisateursManager(); // Recup la dernier enchere
			int no_article = enchere.getNo_article();
			if(VerfiEnchereArticle(no_article)) {
				derEnchere = selectionnerDernierEnchereArticle(no_article);
			}
			encheresDAO.ajoutEnchere(enchere);
			utilisateursManager.crediter(utilisateursManager.selectUtilisateur(enchere.getNo_utilisateur()), enchere.getMontant_enchere());
			/* Remboursser */
			if(derEnchere != null) {
				Utilisateurs utilremboursse = utilisateursManager.selectUtilisateur(derEnchere.getNo_utilisateur()); // Recup l'utilisateur a remboursser
				utilisateursManager.remboursser(utilremboursse, derEnchere.getMontant_enchere()); // Remboursser l'utilisateur
			}
		} catch (Exception e) {
			System.out.println(derEnchere);
			throw new BLLException("Echec Insertion Enchere : ", e);
		}
	}

	public void supprimerEnchere(Encheres enchere) throws Exception{
	    this.encheresDAO.supprimerEnchere(enchere); 
	}
	
	public Encheres selectionnerEnchereByIdUtilisateur(int no_utilisateur) throws BLLException { // SELECT_ENCHERES_id_id//

		Encheres encheres =null; 

		try {
			encheres = encheresDAO.selectionnerEnchereByIdUtilisateur(no_utilisateur);
			System.out.println(encheres);
			if (encheres==null) {
				System.out.println("EncheresListe n'existe pas");
			}
		} catch (Exception e) {
			throw new BLLException("Echec Recuperation Enchere 2.1  : ", e);
		}

		return encheres;
	}
	public Boolean VerfiEnchereArticle(int no_article) throws BLLException{
		int nbEncheres = 0;
		try {
			nbEncheres = encheresDAO.selectionnerEnchereArticle(no_article);
		} catch (Exception e) {
			throw new BLLException("Echec Recuperation Enchere Sur Article  : ", e);
		}
		if(nbEncheres>0) {
			return true;
		}
		return false;
	}
	// /!\ Doit etre dans un test !! Verifier qu'il y a au moin déja un enchere pour eviter le null pointer //
	public Encheres selectionnerDernierEnchereArticle(int no_article) throws BLLException { // SELECT_DERNIER_ENCHERES_ARTICLE_// 

		Encheres encheres =null; 

		try {
			encheres = encheresDAO.selectionnerDernierEnchereArticle(no_article);
			System.out.println(encheres);
			if (encheres==null) {
				System.out.println("aucun Enchere sur cette article");
			}
		} catch (Exception e) {
			throw new BLLException("Echec Recuperation Enchere 2.1  : ", e);
		}

		return encheres;
	}
}
