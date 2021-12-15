package fr.eni.projetEncheres.bll;

import java.util.ArrayList;
import java.util.List;

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
			System.out.println("BLL"+EncheresListe);
		} catch (Exception e) {
			e.printStackTrace();
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
}
