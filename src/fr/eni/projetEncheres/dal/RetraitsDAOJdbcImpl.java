package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Articles;
import fr.eni.projetEncheres.bo.Retraits;
/**
 * @author Luka CHOUVILLE
 *	RetraitsDAOJdbcImpl
 */
public class RetraitsDAOJdbcImpl implements RetraitsDAO {

	private static final String SELECT_TOUT = "SELECT * FROM RETRAITS";
	private static final String SELECT_ID = "SELECT * FROM RETRAITS WHERE no_article = ?";
	private static final String AJOUTER =  "INSERT INTO RETRAITS(no_article,rue,code_postal,ville) VALUES (?,?,?,?)"; 
	private static final String MODIFIER =  "UPDATE RETRAITS SET rue = ?, code_postale = ?, ville = ? WHERE no_article = ?"; 
	private ArticlesDAO articlesDAO;
	
	//Selectionner l'ensemble des encheres
	public List<Retraits> selectionner() throws DALException {
				
		List<Retraits> RetraitListe = new ArrayList<Retraits>();
		Statement statementRetrait= null;
		ResultSet resultRetrait = null;
				
		try (Connection cnx = ConnectionProvider.getConnection()) {
			statementRetrait = cnx.createStatement();
			resultRetrait  = statementRetrait.executeQuery(SELECT_TOUT);

			while (resultRetrait .next()) {
				Retraits Retrait = new Retraits(
						/* Recuperation de l'article*/
						articlesDAO.selectArticle(resultRetrait .getInt("no_article")),
						
						resultRetrait.getString("rue"),
						resultRetrait.getString("code_postal"),
						resultRetrait.getString("ville"));
				RetraitListe.add(Retrait);
			}

		} catch (SQLException e) {
			throw new DALException("Echec Connection/Requete : ",e);
		}
		finally {
					
			try {
				statementRetrait.close();
				resultRetrait.close();
			} catch (SQLException e) {
				throw new DALException("Echec Fermeture Connection : ",e);
			}
		}
				
		return RetraitListe;
	}
	public Retraits selectionnerArticleID(Articles article) throws DALException {
		
		Retraits retrait = null;
		PreparedStatement pstmtRetrait= null;
		ResultSet resultRetrait = null;
				
		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmtRetrait = cnx.prepareStatement(SELECT_ID);
			pstmtRetrait.setInt(1, article.getNo_article());
			
			resultRetrait  = pstmtRetrait.executeQuery();

			resultRetrait .next();
			retrait = new Retraits(
				article,
				resultRetrait.getString("rue"),
				resultRetrait.getString("code_postal"),
				resultRetrait.getString("ville"));
			

		} catch (SQLException e) {
			throw new DALException("Echec Connection/Requete : ",e);
		}
		finally {
					
			try {
				pstmtRetrait.close();
				resultRetrait.close();
			} catch (SQLException e) {
				throw new DALException("Echec Fermeture Connection : ",e);
			}
		}
				
		return retrait;
	}
	public void ajouter(Retraits retrait) throws DALException {
		 		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtRetrait= null;
			pstmtRetrait = cnx.prepareStatement(AJOUTER);
			int no_article = retrait.getArticle().getNo_article();
        	pstmtRetrait.setInt(1, no_article);
        	pstmtRetrait.setString(2, retrait.getRue() );
        	pstmtRetrait.setString(3, retrait.getCode_postal());
        	pstmtRetrait.setString(4, retrait.getVille());
			
        	pstmtRetrait.execute();

		}  catch (SQLException e) {
			throw new DALException("Echec Connection/Requete : ",e);
		}
	}
	public void modifier(Retraits retrait) throws DALException {
		 
		PreparedStatement pstmtRetrait= null;
				
		try (Connection cnx = ConnectionProvider.getConnection()) {
			pstmtRetrait = cnx.prepareStatement(MODIFIER);
        	pstmtRetrait.setString(1, retrait.getRue() );
        	pstmtRetrait.setString(2, retrait.getCode_postal());
        	pstmtRetrait.setString(3, retrait.getVille());
        	pstmtRetrait.setInt(4, retrait.getArticle().getNo_article());
			
        	
        	pstmtRetrait.executeUpdate();

		}  catch (SQLException e) {
			throw new DALException("Echec Connection/Requete : ",e);
		}
		finally {
					
			try {
				pstmtRetrait.close();
			} catch (SQLException e) {
				throw new DALException("Echec Fermeture Connection : ",e);
			}
		}
	}
}
