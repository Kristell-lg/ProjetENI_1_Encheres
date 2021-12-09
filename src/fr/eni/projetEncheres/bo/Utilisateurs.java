/**
 * 
 */
package fr.eni.projetEncheres.bo;

/**
 * @author Kristell
 *	Classe pour génerer des objets utilisateurs & gérer leurs caractéristiques
 */
public class Utilisateurs {
	
	private int no_utilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String code_postal;
	private String ville;
	private String mot_de_passe;
	private int credit;
	private boolean administrateurs;
	
	
	//Méthodes GETTERS & SETTERS pour l'ensemble des variables
	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public boolean isAdministrateurs() {
		return administrateurs;
	}

	
	
	//CONSTRUCTEUR avec no_utilisateur pour les utilisateurs déjà présents en BDD (affichage, modification ou suppression)
	public Utilisateurs(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String code_postal, String ville, String mot_de_passe, int credit, boolean administrateurs) {
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateurs = administrateurs;
	}
	
	//CONSTRUCTEUR sans no_utilisateur & admnistrateurs pour les utilisateurs qui sont créés (nouvelle inscription)
	public Utilisateurs(String pseudo, String nom,String prenom, String email, String telephone, String rue, String code_postal,
			String ville, String mot_de_passe, int credit) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
	}
	
	
	public Utilisateurs(String pseudo, String mot_de_passe) {
		this.pseudo = pseudo;
		this.mot_de_passe = mot_de_passe;
	}
	
	//Méthode TOSTRING 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateurs [no_utilisateur=");
		builder.append(no_utilisateur);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", code_postal=");
		builder.append(code_postal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", mot_de_passe=");
		builder.append(mot_de_passe);
		builder.append(", credit=");
		builder.append(credit);
		builder.append(", administrateurs=");
		builder.append(administrateurs);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
