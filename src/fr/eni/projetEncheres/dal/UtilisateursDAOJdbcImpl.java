package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.bo.Utilisateurs;
/**
 * @author Kristell
 * JDBCImpl
 * @update Luka CHOUVILLE
 */
public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {

	private static final String SELECT_TOUT = "SELECT * FROM UTILISATEURS";
	private static final String INSERTUTILISATEURS = "INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal, ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,100,0)";
	private static final String SELECT_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";

	//Selectionner l'ensemble des données - pour se connecter
	public List<Utilisateurs> selectionner() {
		
		List<Utilisateurs> utilisateursListe = new ArrayList<Utilisateurs>();
		Statement statementUtilisateurs = null;
		ResultSet resultUtilisateurs = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			statementUtilisateurs = cnx.createStatement();
			resultUtilisateurs = statementUtilisateurs.executeQuery(SELECT_TOUT);

			while (resultUtilisateurs.next()) {
				Utilisateurs utilisateur = new Utilisateurs(resultUtilisateurs.getInt("no_utilisateur"), resultUtilisateurs.getString("pseudo"),
						resultUtilisateurs.getString("nom"),resultUtilisateurs.getString("prenom"),resultUtilisateurs.getString("email"),
						resultUtilisateurs.getString("telephone"),resultUtilisateurs.getString("rue"),resultUtilisateurs.getString("code_postal"),
						resultUtilisateurs.getString("ville"),resultUtilisateurs.getString("mot_de_passe"),resultUtilisateurs.getInt("credit"),
						resultUtilisateurs.getBoolean("administrateur"));
				utilisateursListe.add(utilisateur);
			}

			

		} catch (SQLException e) {
			System.out.println("Méthode selectionner - UtilisateursDAOJdbcImpl.java ");
			e.printStackTrace();
		}
		finally {
			
			try {
				statementUtilisateurs.close();
				resultUtilisateurs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return utilisateursListe;
	}
	
	
	//Ajouter un utilisateur après inscription
	public void ajoutUtilisateur(Utilisateurs utilisateur) {
			PreparedStatement pstmtUtilisateurs = null;
			
			try (Connection cnx = ConnectionProvider.getConnection()) {
				pstmtUtilisateurs = cnx.prepareStatement(INSERTUTILISATEURS);
				
				pstmtUtilisateurs.setString(1, utilisateur.getPseudo());
				pstmtUtilisateurs.setString(2, utilisateur.getNom());
				pstmtUtilisateurs.setString(3, utilisateur.getPrenom());
				pstmtUtilisateurs.setString(4, utilisateur.getEmail());
				pstmtUtilisateurs.setString(5, utilisateur.getTelephone());
				pstmtUtilisateurs.setString(6, utilisateur.getRue());
				pstmtUtilisateurs.setString(7, utilisateur.getCode_postal());
				pstmtUtilisateurs.setString(8, utilisateur.getVille());
				pstmtUtilisateurs.setString(9, utilisateur.getMot_de_passe());
				
				pstmtUtilisateurs.executeUpdate();
				

			} catch (SQLException e) {
				//TODO GERER ERREUR UNICITE EMAIL & PSEUDO
				System.out.println("Méthode ajoutUtilisateur - UtilisateursDAOJdbcImpl.java ");
				e.printStackTrace();
			}
			finally {
				try {
					pstmtUtilisateurs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	
	//Selectionner l'ensemble des données - pour se connecter
	public Utilisateurs selectUtilisateur(int no_utilisateur) throws DALException {
			
			Utilisateurs utilisateur = null;
			PreparedStatement statementUtilisateurs = null;
			ResultSet resultUtilisateurs = null;
			
			try (Connection cnx = ConnectionProvider.getConnection()) {
				statementUtilisateurs = cnx.prepareStatement(SELECT_ID);
				statementUtilisateurs.setInt(1, no_utilisateur);
				resultUtilisateurs = statementUtilisateurs.executeQuery();

				resultUtilisateurs.next();
				utilisateur = new Utilisateurs(resultUtilisateurs.getInt("no_utilisateur"), resultUtilisateurs.getString("pseudo"),
							resultUtilisateurs.getString("nom"),resultUtilisateurs.getString("prenom"),resultUtilisateurs.getString("email"),
							resultUtilisateurs.getString("telephone"),resultUtilisateurs.getString("rue"),resultUtilisateurs.getString("code_postal"),
							resultUtilisateurs.getString("ville"),resultUtilisateurs.getString("mot_de_passe"),resultUtilisateurs.getInt("credit"),
							resultUtilisateurs.getBoolean("administrateur"));

				

			} catch (SQLException e) {
				throw new DALException(e);
			}
			finally {
				
				try {
					statementUtilisateurs.close();
					resultUtilisateurs.close();
				} catch (SQLException e) {
					throw new DALException(e);
				}
			}
			
			return utilisateur;
		}
	
	public void supprimerUtilisateur(Utilisateurs utilisateur) throws Exception {
	    try (Connection connection = ConnectionProvider.getConnection();
	            PreparedStatement stmt = connection.prepareStatement(DELETE);) {
	        stmt.setInt(1, utilisateur.getNo_utilisateur());
	        stmt.execute();
	    } catch (SQLException e) {
	        throw new Exception(e);
	    }
	}
	
}
