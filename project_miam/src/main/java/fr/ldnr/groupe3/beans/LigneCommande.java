package fr.ldnr.groupe3.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LigneCommande implements Serializable {
	
	/**
	 * @author group3
	 * @since 01/05/2020
	 */
	private static final long serialVersionUID = 3007242006489287847L;
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLigneCommande;
	@Column(name="fk_idCommande")
	private int idCommande;
	@Column(name="fk_idProduit")
	private int idProduit;
	
	
	public LigneCommande() {
		
	}
	
	public LigneCommande(int idCommande, int idProduit) {
		super();
		this.idCommande = idCommande;
		this.idProduit = idProduit;
	}
	public int getIdLigneCommande() {
		return idLigneCommande;
	}
	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", idCommande=" + idCommande + ", idProduit="
				+ idProduit + "]";
	}
	
	

}
