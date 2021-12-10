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
	
	//CONSTRUCTEUR
	public EncheresManager() {
			this.encheresDAO = DAOFactory.getEncheresDAO();
	}
	//METHODE
	public List<Encheres> selectionner() throws BLLException { // SELECT_TOUT ENCHERE //

		List<Encheres> EncheresListe = new ArrayList<Encheres>();

		try {
			EncheresListe = encheresDAO.selectionner();
		} catch (Exception e) {
			throw new BLLException("Echec Recuperation Enchere : ",e);
		}

		return EncheresListe;
	}
}
