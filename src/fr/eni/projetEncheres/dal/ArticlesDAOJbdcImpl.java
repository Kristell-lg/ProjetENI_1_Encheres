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
import fr.eni.projetEncheres.bo.Categories;
import fr.eni.projetEncheres.bo.Utilisateurs;

/**
 * 
 * @author Clément
 *@update Kristell
 */

public class ArticlesDAOJbdcImpl implements ArticlesDAO {

	private static final String SELECT_TOUT = "SELECT * FROM (ARTICLES_VENDUS a  INNER JOIN UTILISATEURS u ON a.no_utilisateur=u.no_utilisateur) INNER JOIN CATEGORIES c ON a.no_categorie =c.no_categorie";
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)VALUES(?,?,?,?,?,?,?,?)";
	private static final String SELECT_ID = "SELECT * FROM (ARTICLES_VENDUS a  INNER JOIN UTILISATEURS u ON a.no_utilisateur=u.no_utilisateur AND a.no_article=?) INNER JOIN CATEGORIES c ON a.no_categorie =c.no_categorie";
	// select by encheres 
	
	
	// Selectionner l'ensemble des données - pour se connecter
	public List<Articles> selectionner() {

		List<Articles> ArticlesListe = new ArrayList<Articles>();

		try (Connection cnx = ConnectionProvider.getConnection();
				Statement statementArticles = cnx.createStatement();
				ResultSet resultArticles = statementArticles.executeQuery(SELECT_TOUT);
			) {

			while (resultArticles.next()) {
				Categories categorie = new Categories(resultArticles.getString("libelle"));
				
				Utilisateurs utilisateur = new Utilisateurs(resultArticles.getInt("no_utilisateur"),resultArticles.getString("pseudo"),
						resultArticles.getString("nom"),resultArticles.getString("prenom"),resultArticles.getString("email"),
						resultArticles.getString("telephone"),resultArticles.getString("rue"),resultArticles.getString("code_postal"),
						resultArticles.getString("ville"),resultArticles.getString("mot_de_passe"),resultArticles.getInt("credit"),resultArticles.getBoolean("administrateur"));
				
				Articles Article = new Articles(resultArticles.getInt("no_article"),
						resultArticles.getString("nom_article"), resultArticles.getString("description"),
						LocalDate.parse(resultArticles.getString("date_debut_encheres")), LocalDate.parse(resultArticles.getString("date_fin_encheres")),
						resultArticles.getInt("prix_initial"), resultArticles.getInt("prix_vente"),utilisateur, categorie);
				ArticlesListe.add(Article);
			}

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
			
			//TODO MODIFIER LES CHIFFRES EN DUR
			stmt.setInt(7, a.getUtilisateur().getNo_utilisateur());
			stmt.setInt(8, a.getCategorie().getNoCategorie());
			
			// Execution de la requete
			stmt.executeUpdate();

		

			
		} catch (SQLException e) {
			System.out.println("Je n'ai pas réussi à insérer dans la BDD -DAL");
			e.printStackTrace();
		}
	}
	
	//Selectionner un article pour l'afficher
	public Articles selectArticle(int no_article) throws DALException {
			
			Articles article = null;
			
			try (Connection cnx = ConnectionProvider.getConnection();
					PreparedStatement statementArticles = cnx.prepareStatement(SELECT_ID);) {
				statementArticles.setInt(1, no_article);
				ResultSet resultArticles = statementArticles.executeQuery();

				while (resultArticles.next()) {
					Categories categorie = new Categories(resultArticles.getString("libelle"));
					
					Utilisateurs utilisateur = new Utilisateurs(resultArticles.getString("pseudo"),
							resultArticles.getString("nom"),resultArticles.getString("prenom"),resultArticles.getString("email"),
							resultArticles.getString("telephone"),resultArticles.getString("rue"),resultArticles.getString("code_postal"),
							resultArticles.getString("ville"),resultArticles.getString("mot_de_passe"),resultArticles.getInt("credit"));
					
					article = new Articles(resultArticles.getInt("no_article"),
							resultArticles.getString("nom_article"), resultArticles.getString("description"),
							LocalDate.parse(resultArticles.getString("date_debut_encheres")), LocalDate.parse(resultArticles.getString("date_fin_encheres")),
							resultArticles.getInt("prix_initial"), resultArticles.getInt("prix_vente"),utilisateur, categorie);
				}


			} catch (SQLException e) {
				throw new DALException(e);
			}
			
			return article;
		}
}
