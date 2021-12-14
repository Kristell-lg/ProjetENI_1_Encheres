package fr.eni.projetEncheres.bo;

public class Retraits {

/**
 * @author Luka CHOUVILLE
 * Class des Retraits
*/
	/* ATTRIBUTS */
	private Articles article;
	private String rue;
	private String code_postal;
	private String ville;
	
	/* CONSTRUCTEURS */
	public Retraits(Articles article, String rue, String code_postal, String ville) {
		this.article = article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
	
	/* ACCESSEUR */
	public Articles getArticle() {
		return article;
	}

	public String getRue() {
		return rue;
	}


	public String getCode_postal() {
		return code_postal;
	}


	public String getVille() {
		return ville;
	}
	/* METHODE */
	
	public void Modifier(String rue, String code_postal, String ville) {
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}
	
	public String Afficher() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.rue);
		sb.append(" ");
		sb.append(this.ville);
		sb.append(" ");
		sb.append(this.code_postal);
		return sb.toString();
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Retraits [no_article= ");
		sb.append(this.article.getNo_article());
		sb.append(", rue= ");
		sb.append(this.rue);
		sb.append(", ville= ");
		sb.append(this.ville);
		sb.append(", code_postal= ");
		sb.append(this.code_postal);
		return sb.toString();
	}
	
}
