package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Retraits;
/**
 * @author Luka CHOUVILLE
 *	RetraitsDAO
 */
public interface RetraitsDAO {
	
	public List<Retraits> selectionner() throws DALException;
	public Retraits selectionnerArticleID(Articles article) throws DALException;
	public void modifier(Retraits retrait) throws DALException;
}
