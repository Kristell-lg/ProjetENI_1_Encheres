package fr.eni.projetEncheres.bo;
/**
* @author  kristell
* 
*         Classe générant des objets "Catégories" et leurs
*         caractéristiques
*/
public class Categories {
	private int noCategorie;
	private String libelle;
	
	
	//CONSTRUCTEURS
	public Categories(String libelle) {
		this.libelle = libelle;
	}
	
	public Categories(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public Categories(int noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	//GETTERS/SETTERS
	public int getNoCategorie() {
		return noCategorie;
	}


	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categories [noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
