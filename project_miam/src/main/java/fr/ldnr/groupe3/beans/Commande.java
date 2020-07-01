package fr.ldnr.groupe3.beans;

import java.io.Serializable;

public class Commande implements Serializable {
	
	/**
	 * @author groupe3
	 * @since 01/05/2020
	 */
	private static final long serialVersionUID = -5905058943327431061L;
	private int idCommande;
	private int idClient;
	private int StatusCommande;
	private int typeCommande;
	
	
	
	public Commande() {
		
	}

	public Commande(int idCommande, int idClient, int statusCommande, int typeCommande) {
		super();
		this.idCommande = idCommande;
		this.idClient = idClient;
		StatusCommande = statusCommande;
		this.typeCommande = typeCommande;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getStatusCommande() {
		return StatusCommande;
	}

	public void setStatusCommande(int statusCommande) {
		StatusCommande = statusCommande;
	}

	public int getTypeCommande() {
		return typeCommande;
	}

	public void setTypeCommande(int typeCommande) {
		this.typeCommande = typeCommande;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", idClient=" + idClient + ", StatusCommande=" + StatusCommande
				+ ", typeCommande=" + typeCommande + "]";
	}
	

}
