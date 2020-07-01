package fr.ldnr.groupe3.beans;

import java.io.Serializable;

public class Produit implements Serializable {
 
	/**
	 * @author groupe3
	 * @since 01/05/2020
	 */
	private static final long serialVersionUID = -1586713427333743572L;
	private int idProduit;
	private String nomProduit;
	private int typeProduit;
	private Double prix;
	
	public Produit() {
		
	}
	
	public Produit(int idProduit, String nomProduit, int typeProduit, Double prix) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.typeProduit = typeProduit;
		this.prix = prix;
	}
	public int getIdProduit() {
		
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getLibelle() {
		return nomProduit;
	}
	public void setLibelle(String libelle) {
		this.nomProduit = libelle;
	}
	public int getType() {
		return typeProduit;
	}
	public void setType(int type) {
		this.typeProduit = type;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", typeProduit=" + typeProduit
				+ ", prix=" + prix + "]";
	}
	
	
	
}
