package fr.ldnr.groupe3.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.ldnr.groupe3.Enum.TypeProduit;

@Entity
public class Produit implements Serializable {
 
	/**
	 * @author groupe3
	 * @since 01/05/2020
	 */
	private static final long serialVersionUID = -1586713427333743572L;
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduit;
	private String nomProduit;
	@Enumerated(EnumType.ORDINAL)
	private TypeProduit typeProduit;
	private Double prix;
	
	public Produit() {
		
	}
	
	public Produit(int idProduit, String nomProduit, TypeProduit type, Double prix) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.typeProduit = type;
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
	public TypeProduit getType() {
		return typeProduit;
	}
	public void setType(TypeProduit type) {
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
