package fr.ldnr.groupe3.beans;

import java.io.Serializable;

public class Produit implements Serializable {
 
	/**
	 * @author groupe3
	 * @since 01/05/2020
	 */
	private static final long serialVersionUID = -1586713427333743572L;
	
	private int idProduit;
	private String libelle;
	private int type;
	private Double prix;
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
}
