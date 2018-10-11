package etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class PageEtcTest {
	
	/**
	 * 
	* Method : test
	* 작성자 : chan
	* 변경이력 :
	* Method 설명 : 페이지 내비게이션 계산 테스트
	 */
	
	@Test
	public void pageNaviCalTest() {
		int totalUserCnt = 105;
		int pageSize = 10;
		
		int naviSize = (int)Math.ceil( (double)totalUserCnt / pageSize);
		
		assertEquals(11, naviSize);
	}

}
