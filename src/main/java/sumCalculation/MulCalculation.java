package sumCalculation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		
		int sum = 1;
		int i_param1 = Integer.parseInt(param1);
		int i_param2 = Integer.parseInt(param2);
		
		for(int i =i_param1; i < i_param2 ; i++){	
			if(!(i_param1 == i)){
				sum = sum * i;
			}
		}
		
		int sumsum = sum;
		
		request.getSession().setAttribute("sumsum", sumsum);
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
		
		
//		request.getSession().setAttribute("sumsum", sumsum);
//		
//		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
	}

}
