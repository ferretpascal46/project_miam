package fr.ldnr.groupe3.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Client implements Serializable {

	/**
	@auteur: groupe 3
	@since 01/07/2020
	// Les propriétés du bean : elles correspondent aux champs de la base de données 
	*/
	private static final long serialVersionUID = 4727646321130165006L;
	
	@Id
	@Column(name="fk_idUtilisateur")
	private int idUtilisateur;
	private String nom;
	private String prenom;
	private int numeroRue;
	private String rue;
	private String complement;
	private int codePostal;
	private String ville;
	private String telephone;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	 public Client() {
	    }
	public Client(int idUtilisateur, String nom, String prenom, int numeroRue, String rue, String complement,
			int codePostal, String ville, String telephone, Date dateCreation) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroRue = numeroRue;
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.dateCreation = dateCreation;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNumeroRue() {
		return numeroRue;
	}
	public void setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Client [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", numeroRue="
				+ numeroRue + ", rue=" + rue + ", complement=" + complement + ", codePostal=" + codePostal + ", ville="
				+ ville + ", telephone=" + telephone + ", dateCreation=" + dateCreation + "]";
	}	
}
