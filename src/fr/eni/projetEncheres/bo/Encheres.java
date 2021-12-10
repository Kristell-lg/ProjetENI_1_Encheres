package fr.eni.projetEncheres.bo;

import java.time.LocalDate;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

/**
 * @author Luka CHOUVILLE
 *	Class des Encheres
 */

public class Encheres {
	
	// Attribue
	
	private int no_utilisateur;
	private int no_article;
	private LocalDate date_enchere;
	private int montant;
	
	// Constructeur
	
	public Encheres(int pNo_utilisateur,int pNo_article, LocalDate pDate_enchere,int pMontant) {
		this.no_utilisateur = pNo_utilisateur;
		this.no_article = pNo_article;
		this.date_enchere = pDate_enchere;
		this.montant = pMontant;
	}
	// Accesseur
	
	public int getNo_utilisateur() {
		return this.no_utilisateur;
	}
	
	public int getNo_article() {
		return this.no_article;
	}
	public LocalDate getDate_enchere() {
		return this.date_enchere;
	}
	public int getMontant() {
		return this.montant;
	}
	
	// Methode
	
	public string toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("no_utilisateur : ").append(this.no_utilisateur);
		sb.append("no_article : ").append(this.no_article);
		sb.append("date_enchere : ").append(this.date_enchere);
		sb.append("montant : ").append(this.montant);
	}
}
