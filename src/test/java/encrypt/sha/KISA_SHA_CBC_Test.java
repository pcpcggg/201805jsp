package encrypt.sha;

import static org.junit.Assert.*;
import kr.or.ddit.encrypt.sha.KISA_SHA256;

import org.junit.Test;

public class KISA_SHA_CBC_Test {
	
	/**
	 * 
	* Method : EncryptTest
	* 작성자 : chan
	* 변경이력 :
	* Method 설명 : sha256 encrypt 테스트
	 */
	@Test
	public void EncryptTest() {
		/***Given***/
		String pass = "brownpass"; 
		String pass1 = "brownpast";
		String pass2 = "brownpasc";

		/***When***/
		String encrypt = KISA_SHA256.encrypt(pass);
		String encrypt1 = KISA_SHA256.encrypt(pass1);
		String encrypt2 = KISA_SHA256.encrypt(pass2);
		System.out.println("encrypt  : " + encrypt);
		System.out.println("encrypt1 : " + encrypt1);
		System.out.println("encrypt2 : " + encrypt2);


		/***Then***/
		assertEquals("f01471c38113db263f9a532d8b6c054af31bf653aeea92d1c284cdd022b9", encrypt);
	}

}
