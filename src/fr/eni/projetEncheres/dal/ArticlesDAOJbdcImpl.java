package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fr.eni.projetEncheres.bo.Articles;

/**
 * 
 * @author Clément
 *
 */

public class ArticlesDAOJbdcImpl implements ArticlesDAO {

	private static final String SELECT_TOUT = "SELECT * FROM ARTICLES_VENDUS";
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)VALUES(?,?,?,?,?,?,?,?)";

	// select by encheres 
	
	
	// Selectionner l'ensemble des données - pour se connecter
	public List<Articles> selectionner() {

		List<Articles> ArticlesListe = new ArrayList<Articles>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement statementArticles = cnx.createStatement();
			ResultSet resultArticles = statementArticles.executeQuery(SELECT_TOUT);

			while (resultArticles.next()) {
				Articles Article = new Articles(resultArticles.getInt("no_article"),
						resultArticles.getString("nom_article"), resultArticles.getString("description"),
						LocalDate.parse(resultArticles.getString("date_debut_encheres")), LocalDate.parse(resultArticles.getString("date_fin_encheres")),
						resultArticles.getInt("prix_initial"), resultArticles.getInt("prix_vente"),
						resultArticles.getInt("no_utilisateur"), resultArticles.getInt("no_categorie"));
				ArticlesListe.add(Article);
			}

			statementArticles.close();
			resultArticles.close();

		} catch (SQLException e) {
			System.out.println("Méthode selectionner - ArticlesDAOJdbcImpl.java ");
			e.printStackTrace();
		}

		return ArticlesListe;
	}

	public void insert(Articles a) {

		try (Connection c = ConnectionProvider.getConnection();
				PreparedStatement stmt = c.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
			// mise en place de la requete

			// Parametrage
			stmt.setString(1, a.getNom_article());
			stmt.setString(2, a.getDescription());
			stmt.setDate(3, java.sql.Date.valueOf(a.getDate_debut_encheres()));
			stmt.setDate(4, java.sql.Date.valueOf(a.getDate_fin_encheres()));
			stmt.setInt(5, a.getPrix_initial());
			stmt.setInt(6, a.getPrix_vente());
			stmt.setInt(7, a.getNo_utilisateur());
			stmt.setInt(8, a.getNo_categorie());
			
			// Execution de la requete
			stmt.executeUpdate();

		

			
		} catch (SQLException e) {
			System.out.println("Je n'ai pas réussi à insérer dans la BDD -DAL");
			e.printStackTrace();
		}
	}
}
