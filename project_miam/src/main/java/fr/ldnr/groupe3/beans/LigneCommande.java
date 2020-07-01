package fr.ldnr.groupe3.beans;

import java.io.Serializable;

public class LigneCommande implements Serializable {
	
	/**
	 * @author group3
	 * @since 01/05/2020
	 */
	private static final long serialVersionUID = 3007242006489287847L;
	private int idLigneCommande;
	private int idCommande;
	private int idProduit;
	
	
	public LigneCommande() {
		
	}
	
	public LigneCommande(int idLigneCommande, int idCommande, int idProduit) {
		super();
		this.idLigneCommande = idLigneCommande;
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
