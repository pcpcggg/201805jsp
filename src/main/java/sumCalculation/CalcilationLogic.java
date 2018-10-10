package sumCalculation;

public class CalcilationLogic {
	
	public static void main(String[] args){
		CalcilationLogic logic = new CalcilationLogic();
		int i_start = 1;
		int i_end = 10;
		
		int sumResult = logic.sumBetweenTwoNumbers(i_start, i_end);
		
		if(sumResult == 55){
			System.out.println("정답");
		}else{
			System.out.println("오답");
		}
	}
	
	public int sumBetweenTwoNumbers(int i_start, int i_end) {
		int min = Math.min(i_start, i_end);
		int max = Math.max(i_start, i_end);
		
		int sum =0;
		
		for(int i =i_start; i < i_end ; i++){	
			if(!(i_start == i)){
				sum = sum + i;
			}
		}
		return sum;
	}
}