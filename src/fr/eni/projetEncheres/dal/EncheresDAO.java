package fr.eni.projetEncheres.dal;

import java.util.List;
import fr.eni.projetEncheres.bo.Encheres;

/**
 * @author Luka CHOUVILLE
 * @update Kristell
 * @update Clément
 * EncheresDAO
 */

public interface EncheresDAO {
	public List<Encheres> selectionner() throws DALException;
	public Encheres selectionnerEnchereByIdUtilisateur(int no_utilisateur) throws Exception;
	public Encheres selectionnerDernierEnchereArticle(int no_article) throws Exception;
	public int selectionnerEnchereArticle(int no_article) throws DALException;
	public void ajoutEnchere(Encheres enchere) throws DALException;
	public void supprimerEnchere(Encheres enchere) throws Exception;
	
}
