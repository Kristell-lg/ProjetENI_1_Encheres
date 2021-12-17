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
import fr.eni.projetEncheres.bo.Retraits;

/**
 * @authorLukaCHOUVILLE EncheresDAOJDBCImpl
 * 
 * @modif  Clement
 */

public class EncheresDAOJdbcImpl implements EncheresDAO {

	private static final String SELECT_TOUT = "SELECT * FROM ENCHERES";
	private static final String SELECT_ENCHERES_id = "SELECT * FROM ENCHERES e INNER JOIN ARTICLES_VENDUS a ON e.no_article=a.no_article AND e.no_utilisateur=? ";
	private static final String SELECT_NBENCHERES_Article = "SELECT COUNT(no_utilisateur)as nbEnchere FROM ENCHERES WHERE no_article = ?";
	
	private static final String SELECT_DERNIER_ENCHERES_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article=? GROUP BY no_utilisateur, no_article, date_enchere, montant_enchere HAVING date_enchere = (SELECT MAX(date_enchere) FROM ENCHERES WHERE no_article=?)";

	private static final String INSERTENCHERE = "INSERT INTO ENCHERES(no_utilisateur,no_article,date_enchere,montant_enchere)VALUES(?,?,?,?)";
	private static final String MODIFIER =  "UPDATE ENCHERES SET montant_enchere = ?,date_enchere=?  WHERE no_article = ? AND no_utilisateur=? "; 
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
				encheres = new Encheres(rs.getInt("no_utilisateur"), rs.getInt("no_article"),
						(rs.getTimestamp("date_enchere")).toLocalDateTime(), rs.getInt("montant_enchere"));
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
	
	public int selectionnerEnchereArticle(int no_article) throws DALException {

		List<Encheres> EncheresListe = new ArrayList<Encheres>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int nbEnchere = 0;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_NBENCHERES_Article);
			pstmt.setInt(1, no_article);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				nbEnchere = rs.getInt("nbEnchere");
			}	
			
		} catch (SQLException e) {
			throw new DALException("Echec Connection/Requete:", e);
		} finally {

			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				throw new DALException("Echec Fermeture Connection:", e);
			}
		}
		
		return nbEnchere;
	}
	
	public Encheres selectionnerDernierEnchereArticle(int no_article) throws Exception {

		Encheres encheres = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(SELECT_DERNIER_ENCHERES_ARTICLE);

			pstmt.setInt(1, no_article);
			pstmt.setInt(2, no_article);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				encheres = new Encheres(rs.getInt("no_utilisateur"), rs.getInt("no_article"),
						(rs.getTimestamp("date_enchere")).toLocalDateTime(), rs.getInt("montant_enchere"));
			}	

		} catch (SQLException e) {
			throw new DALException("EchecConnection/Requete:", e);
		} finally {

			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				throw new DALException(e);
			}
		}
		if (encheres == null) {
			encheres = new Encheres(-1,-1,LocalDateTime.now(),0);
		}
		return encheres;
	}
	
	public void modifier(Encheres enchere) throws DALException {
		 
		PreparedStatement pstmt= null;
				
		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmt = cnx.prepareStatement(MODIFIER);
			pstmt.setInt(1, enchere.getMontant_enchere() );
			pstmt.setObject(2, java.sql.Timestamp.valueOf(enchere.getDate_enchere()));
			pstmt.setInt(3, enchere.getNo_article() );
        	pstmt.setInt(4, enchere.getNo_utilisateur() );
			
        	
        	pstmt.executeUpdate();

		}  catch (SQLException e) {
			throw new DALException("Echec Connection/Requete : ",e);
		}
		finally {
					
			try {
				pstmt.close();
			} catch (SQLException e) {
				throw new DALException("Echec Fermeture Connection : ",e);
			}
		}
	}
}