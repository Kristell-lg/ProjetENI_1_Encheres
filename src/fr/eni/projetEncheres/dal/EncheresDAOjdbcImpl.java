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
 * JDBCImpl
 */
public class EncheresDAOjdbcImpl {

	private static final String SELECT_TOUT = "SELECT * FROM ENCHERES";
	
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
							LocalDate.parse(resultEncheres.getString("date_enchere")),resultEncheres.getInt("montant"));
					EncheresListe.add(enchere);
				}

				

			} catch (SQLException e) {
				throw new DALException(e);
			}
			finally {
				
				try {
					statementEncheres.close();
					resultEncheres.close();
				} catch (SQLException e) {
					throw new DALException(e);
				}
			}
			
			return EncheresListe;
		}
}
