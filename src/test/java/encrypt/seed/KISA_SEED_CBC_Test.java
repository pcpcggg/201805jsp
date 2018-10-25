package encrypt.seed;

import static org.junit.Assert.*;
import kr.or.ddit.encrypt.seed.KISA_SEED_CBC;

import org.junit.Test;

public class KISA_SEED_CBC_Test {

	@Test
	public void EncryptTest() {
		/***Given***/
		String pass = "brownpass"; 
		
		/***When***/
		String encrypt = KISA_SEED_CBC.Encrypt(pass);
		String dscrypt = KISA_SEED_CBC.Decrypt(encrypt);
		
		System.out.println("dscrypt : " + dscrypt);
		
		if(encrypt.equals("5207bbf01d00451c23800ae909470f26")){
			System.out.println("1234123");
		}
		
		/***Then***/
		assertEquals("5207bbf01d00451c23800ae909470f26", encrypt);
		assertEquals(pass, dscrypt);
		
		
	}

}
