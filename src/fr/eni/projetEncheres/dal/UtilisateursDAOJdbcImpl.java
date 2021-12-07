package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateurs;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {

	private static final String SELECTTOUT = "SELECT (*) FROM UTILISATEURS";

	public List<Utilisateurs> selectionner() {
		
		List<Utilisateurs> utilisateursListe = new ArrayList<Utilisateurs>();
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			Statement statementUtilisateurs = cnx.createStatement();
			ResultSet resultUtilisateurs = statementUtilisateurs.executeQuery(SELECTTOUT);

			while (resultUtilisateurs.next()) {
				Utilisateurs utilisateur = new Utilisateurs(resultUtilisateurs.getInt("no_utilisateur"), resultUtilisateurs.getString("pseudo"),
						resultUtilisateurs.getString("nom"),resultUtilisateurs.getString("prenom"),resultUtilisateurs.getString("email"),
						resultUtilisateurs.getString("telephone"),resultUtilisateurs.getString("rue"),resultUtilisateurs.getString("code_postal"),
						resultUtilisateurs.getString("ville"),resultUtilisateurs.getString("mot_de_passe"),resultUtilisateurs.getInt("credit"),
						resultUtilisateurs.getBoolean("administrateur"));
				utilisateursListe.add(utilisateur);
			}

			statementUtilisateurs.close();
			resultUtilisateurs.close();

		} catch (SQLException e) {
			System.out.println("Méthode selectionner - UtilisateursDAOJdbcImpl.java ");
			e.printStackTrace();
		}
		
		return null;
	}

}
