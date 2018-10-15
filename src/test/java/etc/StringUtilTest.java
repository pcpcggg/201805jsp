package etc;

import static org.junit.Assert.*;
import kr.or.ddit.util.StringUtil;

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
	
	//쿠키 문자열 파싱 테스트
	@Test
	public void getCookieTest(){
		/***Given***/
		String cookieString = "remember=Y; userId=brown; etc=test";

		/***When***/
		
		String cookieValue = StringUtil.getCookie(cookieString, "remember");
		String cookieValue2 = StringUtil.getCookie(cookieString, "userId");

		/***Then***/
		
		assertEquals("Y", cookieValue);
		assertEquals("brown", cookieValue2);
		

	}
	
	

}
