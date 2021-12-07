package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.projetEncheres.bo.Articles;

/**
 * 
 * @author Clément
 *
 */

public class ArticlesDAOJbdcImpl implements ArticlesDAO {

	private static final String SELECT_TOUT = "SELECT (*) FROM ARTICLES";
	private static final String INSERT = "INSERT INTO ARTICLES(no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)VALUES(?,?,?,?,?,?,?,?,?)";

	// Selectionner l'ensemble des données - pour se connecter
	public List<Articles> selectionner() {

		List<Articles> ArticlesListe = new ArrayList<Articles>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement statementArticles = cnx.createStatement();
			ResultSet resultArticles = statementArticles.executeQuery(SELECT_TOUT);

			while (resultArticles.next()) {
				Articles Article = new Articles(resultArticles.getInt("no_article"),
						resultArticles.getString("nom_article"), resultArticles.getString("description"),
						resultArticles.getDate("date_debut_encheres"), resultArticles.getDate("date_fin_encheres"),
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

		return null;
	}

	public void insert(Articles a) {
		Articles ar = new Articles();

		ResultSet rs = null;

		try (Connection c = ConnectionProvider.getConnection();
				PreparedStatement stmt = c.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
			// mise en place de la requete

			// Parametrage

			stmt.setInt(1, ar.getNo_article());
			stmt.setString(2, ar.getNom_article());
			stmt.setString(3, ar.getDescription());
			stmt.setObject(4, ar.getDate_debut_encheres());
			stmt.setObject(5, ar.getDate_fin_encheres());
			stmt.setInt(6, ar.getPrix_initial());
			stmt.setInt(7, ar.getPrix_vente());
			stmt.setInt(8, ar.getNo_utilisateur());
			stmt.setInt(9, ar.getNo_categorie());
			// Execution de la requet

			int nbDeLignesAffectees = stmt.executeUpdate();

			// récupérer des clés générées

			if (nbDeLignesAffectees >= 1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					ar.setNo_article(rs.getInt(1));
				}
				stmt.execute();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
