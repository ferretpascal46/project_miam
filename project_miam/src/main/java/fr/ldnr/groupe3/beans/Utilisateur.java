package fr.ldnr.groupe3.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.ldnr.groupe3.Enum.Role;

@Entity
public class Utilisateur implements Serializable{
	/**
	 * @author group3
	 * @since 01/07/2020
	 */
	private static final long serialVersionUID = 1L;
	
	@Id     
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;
    private String adresseMail;
    private String motDePasse;
	
	@Enumerated(EnumType.ORDINAL)
	// Optional, ORDINAL est la valeur par défauts, 0 pour le gérant, 1 pour les clients
	private Role role;

    public Utilisateur() {
    }
    
	public Utilisateur(String adresseMail, String motDePasse, Role role) {
		super();		
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
    public String toString() {
        return "Utilisateur{" + "id=" + idUtilisateur + ", email=" + adresseMail + ", motDePasse=" + motDePasse + ", role=" + role + '}';
    }
    
	
	
}
