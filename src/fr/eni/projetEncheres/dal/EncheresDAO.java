package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.Encheres;

/**
 * @author Luka CHOUVILLE
 * EncheresDAO
 */

public interface EncheresDAO {
	public List<Encheres> selectionner() throws DALException;
}