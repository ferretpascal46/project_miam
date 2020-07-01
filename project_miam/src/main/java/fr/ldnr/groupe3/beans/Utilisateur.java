package fr.ldnr.groupe3.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur implements Serializable{
	/**
	 * @author group3
	 * @since 01/05/2020
	 */
	private static final long serialVersionUID = 1L;
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;
    private String adresseMail;
    private String motDePasse;
    private int role;
    
    public Utilisateur() {
    }
    
	public Utilisateur(int idUtilisateur, String adresseMail, String motDePasse, int role) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.adresseMail = adresseMail;
		this.motDePasse = motDePasse;
		this.role = role;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	@Override
    public String toString() {
        return "Utilisateur{" + "id=" + idUtilisateur + ", email=" + adresseMail + ", motDePasse=" + motDePasse + ", role=" + role + '}';
    }
    
	
	
}
