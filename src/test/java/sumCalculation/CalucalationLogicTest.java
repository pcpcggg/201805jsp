package sumCalculation;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalucalationLogicTest {
	// 테스트는 순서는 보장하지 않는다.
	// 주변 환경에 까지 영향을 주면 안되기 때문이다.
	
	// 1~10 까지의 합
	@Test
	public void sumBetweenTwoNumbers() {
		CalcilationLogic logic = new CalcilationLogic();
		int i_start = 10;
		int i_end = 1;
		
		int sumResult = logic.sumBetweenTwoNumbers(i_start, i_end);
		
		assertEquals(44, sumResult);
		
	}
	
	@Test
	public void sumBetweenTwoNumbers2(){
		
		CalcilationLogic logic = new CalcilationLogic();
		int i_start = 1;
		int i_end = 10;
		
		int sumResult = logic.sumBetweenTwoNumbers(i_start+2, i_end+2);
		
		assertEquals(60, sumResult);
	}
	
}
