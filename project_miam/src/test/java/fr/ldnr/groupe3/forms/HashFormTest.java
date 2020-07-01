package fr.ldnr.groupe3.forms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;

public class HashFormTest {

	public HashForm hf = new HashForm();
	
	@Test
	public void testSameHach() {
		String mdp = "coincoin";
		String adresseMail = "pj.sequi@gmail.com";
		String hashedPassword1 = "";
		String hashedPassword2 = "";
		
		try {
			 hashedPassword1 = hf.hash(adresseMail, mdp);
			 hashedPassword2 = hf.hash(adresseMail, mdp);
		} catch (Exception e) {
			System.out.println("Erreur lors du hash : " + e);
		}
		
		assertEquals(hashedPassword1, hashedPassword2);
	}

	@Test 
	public void testDifferent() {
		String mdp1 = "coincoin";
		String mdp2 = "Coincoin";
		String adresseMail = "pj.sequi@gmail.com";
		String hashedPassword1 = "";
		String hashedPassword2 = "";
		
		try {
			 hashedPassword1 = hf.hash(adresseMail, mdp1);
			 hashedPassword2 = hf.hash(adresseMail, mdp2);
		} catch (Exception e) {
			System.out.println("Erreur lors du hash : " + e);
		}
		
		assertNotSame(hashedPassword1, hashedPassword2);
	}
	
}
