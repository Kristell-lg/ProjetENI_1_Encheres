package fr.eni.projetEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bll.BLLException;

import fr.eni.projetEncheres.bo.Encheres;
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
		} catch (Exception e) {
			throw new BLLException("Echec Recuperation Enchere 1  : ", e);
		}

		return EncheresListe;
	}

	public void ajoutEnchere(Encheres enchere) throws BLLException { // INSERT ENCHERE //
		try {

			encheresDAO.ajoutEnchere(enchere);
		} catch (Exception e) {
			throw new BLLException("Echec Insertion Enchere : ", e);
		}
	}

	/*
	 * public List<Encheres> selectionnerEnchereByIdUtilisateur(int no_utilisateur)
	 * throws BLLException { // SELECT_ENCHERES_id//
	 * 
	 * List<Encheres> EncheresListe = new ArrayList<Encheres>();
	 * 
	 * try { System.out.println(); EncheresListe =
	 * this.encheresDAO.selectionnerEnchereByIdUtilisateur(no_utilisateur);
	 * System.out.println("1"); if (EncheresListe==null) {
	 * System.out.println("EncheresListe n'existe pas"); } } catch (Exception e) {
	 * throw new BLLException("Echec Recuperation Enchere 2  : ", e); }
	 * 
	 * return EncheresListe; }
	 */
	
	
	public Encheres selectionnerEnchereByIdUtilisateur(int no_utilisateur) throws BLLException { // SELECT_ENCHERES_id//

		Encheres encheres =null; 

		try {
			System.out.println(encheres);
			encheres = encheresDAO.selectionnerEnchereByIdUtilisateur(no_utilisateur);
			System.out.println("1");
			if (encheres==null) {
				System.out.println("EncheresListe n'existe pas");
			}
		} catch (Exception e) {
			throw new BLLException("Echec Recuperation Enchere 2.1  : ", e);
		}

		return encheres;
	}
}
