package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Encheres;

/**
 * @authorLukaCHOUVILLE EncheresDAOJDBCImpl
 * 
 * @modif  Clement
 */

public class EncheresDAOJdbcImpl implements EncheresDAO {

	private static final String SELECT_TOUT = "SELECT * FROM ENCHERES";
	private static final String INSERTENCHERE = "INSERT INTO ENCHERES(no_utilisateur,no_article,date_enchere,montant_enchere)VALUES(?,?,?,?)";
	private static final String SELECT_ENCHERES_id = "SELECT * FROM ENCHERES e INNER JOIN ARTICLES_VENDUS a ON e.no_article=a.no_article AND e.no_utilisateur=? ";
	private static final String DELETE = "DELETE FROM ENCHERES WHERE enchere.No_utilisateur = ?";
//Selectionnerl'ensembledesencheres
	public List<Encheres> selectionner() throws DALException {

		List<Encheres> EncheresListe = new ArrayList<Encheres>();
		Statement statementEncheres = null;
		ResultSet resultEncheres = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			statementEncheres = cnx.createStatement();
			resultEncheres = statementEncheres.executeQuery(SELECT_TOUT);

			
			while (resultEncheres.next()) {
				Encheres enchere = new Encheres(resultEncheres.getInt("no_utilisateur"),
						resultEncheres.getInt("no_article"), (resultEncheres.getTimestamp("date_enchere")).toLocalDateTime(),
						resultEncheres.getInt("montant_enchere"));
				EncheresListe.add(enchere);
				System.out.println("DAL"+EncheresListe);
			}
		} catch (SQLException e) {
			throw new DALException("Echec Connection/Requete:", e);
		} finally {

			try {
				statementEncheres.close();
				resultEncheres.close();
			} catch (SQLException e) {
				throw new DALException("Echec Fermeture Connection:", e);
			}
		}
		
		return EncheresListe;
	}

	public void ajoutEnchere(Encheres enchere) throws DALException {
		System.out.println("4");

		try (Connection c = ConnectionProvider.getConnection();
				PreparedStatement stmt = c.prepareStatement(INSERTENCHERE)) {

			stmt.setInt(1, enchere.getNo_utilisateur());
			stmt.setInt(2, enchere.getNo_article());
			stmt.setObject(3, java.sql.Timestamp.valueOf(enchere.getDate_enchere()));
			stmt.setInt(4, enchere.getMontant_enchere());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODOAuto-generatedcatchblock
			e.printStackTrace();
		}

	}
	public void supprimerEnchere(Encheres enchere) throws Exception {
		
	    try (Connection connection = ConnectionProvider.getConnection();
	    		PreparedStatement stmt = connection.prepareStatement(DELETE);) {
	    				stmt.setInt(1,  enchere.getNo_utilisateur());
	    				stmt.execute();
	    				} catch (SQLException e) {
	    				throw new Exception(e);
	    }
	} 
	public Encheres selectionnerEnchereByIdUtilisateur(int no_utilisateur) throws Exception {

		Encheres encheres = null;
		PreparedStatement stmt = null;

		ResultSet rs = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			stmt = cnx.prepareStatement(SELECT_ENCHERES_id);

			stmt.setInt(1, no_utilisateur);

			rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println("1");
				encheres = new Encheres(rs.getInt("no_utilisateur"), rs.getInt("no_article"),
						LocalDateTime.parse(rs.getString("date_enchere")), rs.getInt("montant_enchere"));
				System.out.println("2");
			}	

		} catch (SQLException e) {
			throw new DALException("EchecConnection/Requete:", e);
		} finally {

			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				throw new DALException(e);
			}
		}

		return encheres;
	}

}