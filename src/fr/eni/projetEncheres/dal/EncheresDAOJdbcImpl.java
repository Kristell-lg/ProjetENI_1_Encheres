package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Encheres;
import fr.eni.projetEncheres.dal.DALException;

/**
 * @author Luka CHOUVILLE
 * EncheresDAO - JDBCImpl
 */
public class EncheresDAOJdbcImpl implements EncheresDAO {

	private static final String SELECT_TOUT = "SELECT * FROM ENCHERES";
	private static final String INSERTENCHERE = "INSERT INTO ENCHERE(no_utilisateur,no_article,date_enchere,montant_enchere) Value (?,?,?,?)";
	
	//Selectionner l'ensemble des encheres
		public List<Encheres> selectionner() throws DALException {
			
			List<Encheres> EncheresListe = new ArrayList<Encheres>();
			Statement statementEncheres = null;
			ResultSet resultEncheres = null;
			
			try (Connection cnx = ConnectionProvider.getConnection()) {
				statementEncheres = cnx.createStatement();
				resultEncheres = statementEncheres.executeQuery(SELECT_TOUT);

				while (resultEncheres.next()) {
					Encheres enchere = new Encheres(resultEncheres.getInt("no_utilisateur"),resultEncheres.getInt("no_article"),
							LocalDate.parse(resultEncheres.getString("date_enchere")),resultEncheres.getInt("montant_enchere"));
					EncheresListe.add(enchere);
				}

				

			} catch (SQLException e) {
				throw new DALException("Echec Connection/Requete : ",e);
			}
			finally {
				
				try {
					statementEncheres.close();
					resultEncheres.close();
				} catch (SQLException e) {
					throw new DALException("Echec Fermeture Connection : ",e);
				}
			}
			
			return EncheresListe;
		}
		
		// Inserer un Enchere
		public void ajoutEnchere(Encheres enchere) throws DALException{
			PreparedStatement pstmtUtilisateurs = null;
			
			try (Connection cnx = ConnectionProvider.getConnection()) {
				pstmtUtilisateurs = cnx.prepareStatement(INSERTENCHERE);
				
				pstmtUtilisateurs.setInt(1, enchere.getNo_utilisateur());
				pstmtUtilisateurs.setInt(2, enchere.getNo_article());
				pstmtUtilisateurs.setDate(3, java.sql.Date.valueOf(enchere.getDate_enchere()));
				pstmtUtilisateurs.setInt(4, enchere.getMontant());
				
				pstmtUtilisateurs.executeUpdate();
				

			} catch (SQLException e) {
				throw new DALException("Echec Connection/Requete : ",e);
			}
			finally {
				try {
					pstmtUtilisateurs.close();
				} catch (SQLException e) {
					throw new DALException("Echec Fermeture Connection : ",e);
				}
			}
			
		}
}
