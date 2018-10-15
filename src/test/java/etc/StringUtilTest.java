package etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test() {
		/***Given***/
		String ContentDisposition = "form-data; name=\"profile\"; filename=\"brown.png\"";
		
		int StringStart = ContentDisposition.indexOf("filename=");
		int StringEnd = ContentDisposition.lastIndexOf("\"");
		
		String fileName2 = ContentDisposition.substring(StringStart+10, StringEnd);
		
		
		/***When***/
		//logic
		
		String fileName = fileName2;
		
		
		/***Then***/
		assertEquals("brown.png", fileName);
		
	}

}
