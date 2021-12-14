package fr.eni.projetEncheres.dal;

import java.util.List;
import fr.eni.projetEncheres.bo.Encheres;

/**
 * @author Luka CHOUVILLE
 * EncheresDAO
 */

public interface EncheresDAO {
	public List<Encheres> selectionner() throws DALException;
	public void ajoutEnchere(Encheres enchere) throws DALException;
	 public List<Encheres> selectionner_id(int no_utilisateur) throws DALException;
}
