package fr.eni.projetEncheres.dal;

import java.util.List;
import fr.eni.projetEncheres.bo.Encheres;

/**
 * @author Luka CHOUVILLE
 * @update Kristell
 * EncheresDAO
 */

public interface EncheresDAO {
	public List<Encheres> selectionner() throws DALException;
	public void ajoutEnchere(Encheres enchere) throws DALException;
	public Encheres selectionnerEnchereByIdUtilisateur(int no_utilisateur) throws Exception;
}
