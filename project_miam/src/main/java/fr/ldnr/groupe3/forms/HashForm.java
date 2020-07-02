package fr.ldnr.groupe3.forms;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashForm {
	public final String salt = "Le_GrouPe_3-EST_lE plus ForT Du Monde_CoinCoin";
	
	public String hash(String mail, String password) throws NoSuchAlgorithmException {
		String passWord = salt+mail+password;
		 try { 
			 
	            // getInstance() method is called with algorithm SHA-512 
	            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
	  
	            // digest() method is called 
	            // to calculate message digest of the input string 
	            // returned as array of byte 
	            byte[] messageDigest = md.digest(passWord.getBytes()); 
	  
	            // Convert byte array into signum representation 
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	            String hashedPassword = no.toString(16); 
	  
	            // Add preceding 0s to make it 32 bit 
	            while (hashedPassword.length() < 32) { 
	            	hashedPassword = "0" + hashedPassword; 
	            } 
	  
	            // return the HashText 
	            return hashedPassword; 
	        } 
	  
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        } 
	}
	
}
