package fr.ldnr.groupe3.model;

import fr.ldnr.group3.forms.HachForm;

public class CoinCoin {

	public static void main(String[] args) {
		
		String mdp = "coincoin";
		String adresseMail = "pj.sequi@gmail.com";
		String hashedPassword = "";
		HachForm hf = new HachForm();
		
		//essai 1
		try {
			 hashedPassword = hf.hach(adresseMail, mdp);
		} catch (Exception e) {
			System.out.println("Erreur lors du hash : " + e);
		}
		
		System.out.println("mdp = " + mdp);
		System.out.println("hasedPassWord = " + hashedPassword);
		
		//essai identique
		try {
			 hashedPassword = hf.hach(adresseMail, mdp);
		} catch (Exception e) {
			System.out.println("Erreur lors du hash : " + e);
		}
		
		System.out.println("mdp = " + mdp);
		System.out.println("hasedPassWord = " + hashedPassword);
		
		
		//essai different
		mdp = "coincoi";
		try {
			 hashedPassword = hf.hach(adresseMail, mdp);
		} catch (Exception e) {
			System.out.println("Erreur lors du hash : " + e);
		}
		
		System.out.println("mdp = " + mdp);
		System.out.println("hasedPassWord = " + hashedPassword);
	}
}
 