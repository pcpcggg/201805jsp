package sumCalculation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//기존 view 요청 get : localhost:8081/jsp/sumInput.jsp
		//반경 view 요청 get : localhost:8081/sumCalculation
		//sumInput.jsp forward
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumInput.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		int i_start = Integer.parseInt(start);
		int i_end = Integer.parseInt(end);
		
		CalcilationLogic logic = new CalcilationLogic();
		
		int sum  = logic.sumBetweenTwoNumbers(i_start, i_end);
		
	
		
		int sumsum = sum;
		
		request.getSession().setAttribute("sumsum", sumsum);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
	}

}
