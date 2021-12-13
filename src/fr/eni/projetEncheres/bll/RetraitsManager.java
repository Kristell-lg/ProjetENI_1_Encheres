package fr.eni.projetEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Retraits;
import fr.eni.projetEncheres.dal.DAOFactory;
import fr.eni.projetEncheres.dal.RetraitsDAO;
/**
 * @author Luka CHOUVILLE
 *	RetraitsManager
 */
public class RetraitsManager {
		// ATTRIBUTS
		private RetraitsDAO retraitsDAO;
		
		//CONSTRUCTEURS
		public RetraitsManager() {
				this.retraitsDAO = DAOFactory.getRetraitsDAO();
		}
		//METHODES
		public List<Retraits> selectionner() throws BLLException { // SELECT_TOUT RETRAIT //

			List<Retraits> RetraitsListe = new ArrayList<Retraits>();

			try {
				RetraitsListe = retraitsDAO.selectionner();
			} catch (Exception e) {
				throw new BLLException("Echec Recuperation Retraits : ",e);
			}

			return RetraitsListe;
		}
		public Retraits selectionnerArticleID(Articles article) throws BLLException { // SELECT_ID RETRAIT //

			Retraits Retrait = null;

			try {
				Retrait = retraitsDAO.selectionnerArticleID(article);
			} catch (Exception e) {
				throw new BLLException("Echec Recuperation Retraits : ",e);
			}

			return Retrait;
		}
		public void modifier(Retraits retrait) throws BLLException { // MODIFIER RETRAIT //

			try {
				retraitsDAO.modifier(retrait);
			} catch (Exception e) {
				throw new BLLException("Echec Modification Retraits : ",e);
			}

		}
}
