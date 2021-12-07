package fr.eni.projetEncheres.bo;

import java.time.LocalDate;

/**
 * @author clementcorcuff
 * 
 *         Classe générant des objets "Articles Vendus" et leurs
 *         caractéristiques
 */

public class ArticlesVendus {

	private int no_artcile;
	private String nom_article;
	private String description;
	private LocalDate date_debut_encheres;
	private LocalDate date_fin_encheres;
	private int prix_initial;
	private int prix_vente;
	private int no_utilisateur;
	private int no_categorie;

	// Méthodes GETTERS & SETTERS pour l'ensemble des variables

	public int getNo_artcile() {
		return no_artcile;
	}

	public void setNo_artcile(int no_artcile) {
		this.no_artcile = no_artcile;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate_debut_encheres() {
		return date_debut_encheres;
	}

	public void setDate_debut_encheres(LocalDate date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}

	public LocalDate getDate_fin_encheres() {
		return date_fin_encheres;
	}

	public void setDate_fin_encheres(LocalDate date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	public int getPrix_initial() {
		return prix_initial;
	}

	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	// Constructeur sans paramètre

	public ArticlesVendus() {
		super();
	}

	// Constructeur avec tous les paramètres pour les Articles vendus (avec date de fin d'enchères et prix de vente final 

	public ArticlesVendus(int no_artcile, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie) {
		super();
		this.no_artcile = no_artcile;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}


	// Methode ToString

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Utilisateurs [no_article=");
		sb.append(no_artcile);
		sb.append(", nom_article=");
		sb.append(nom_article);
		sb.append(", description=");
		sb.append(description);
		sb.append(", date_debut_encheres=");
		sb.append(date_debut_encheres);
		sb.append(", date_fin_encheres=");
		sb.append(date_fin_encheres);
		sb.append(", prix_initial=");
		sb.append(prix_initial);
		sb.append(", prix_vente=");
		sb.append(prix_vente);
		sb.append(", no_utilisateur=");
		sb.append(no_utilisateur);
		sb.append(", no_categorie=");
		sb.append(no_categorie);
		sb.append("]");
		return sb.toString();
		
		//commentaire test
	}
}
