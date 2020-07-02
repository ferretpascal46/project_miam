package fr.ldnr.groupe3.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.ldnr.groupe3.Enum.StatusCommande;
import fr.ldnr.groupe3.Enum.TypeDeCommande;

@Entity
public class Commande implements Serializable {
	
	/**
	 * @author groupe3
	 * @since 01/05/2020
	 */
	private static final long serialVersionUID = -5905058943327431061L;
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommande;
	@Column(name="fk_idClient")
	private int idClient;
	@Enumerated(EnumType.ORDINAL)
	private StatusCommande statusCommande;
	@Enumerated(EnumType.ORDINAL)
	private TypeDeCommande typeDeCommande;
	
	
	
	public Commande() {
		
	}

	public Commande(int idClient, StatusCommande status, TypeDeCommande type) {
		super();
		this.idClient = idClient;
		this.statusCommande = status;
		this.typeDeCommande = type;
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

	public StatusCommande getStatusCommande() {
		return statusCommande;
	}

	public void setStatusCommande(StatusCommande statusCommande) {
		this.statusCommande = statusCommande;
	}

	public TypeDeCommande getTypeCommande() {
		return typeDeCommande;
	}

	public void setTypeCommande(TypeDeCommande typeCommande) {
		this.typeDeCommande = typeCommande;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", idClient=" + idClient + ", StatusCommande=" + statusCommande
				+ ", typeCommande=" + typeDeCommande + "]";
	}
	

}
