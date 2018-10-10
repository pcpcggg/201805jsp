package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw =  resp.getWriter();
		
		String[] userIdValues = req.getParameterValues("userId");
		Map<String, String[]> requestMap = req.getParameterMap();
		
		Enumeration<String> parameterNames = req.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String parameterName = parameterNames.nextElement();
			System.out.println("parameterName : " + parameterName);
		}

			
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>LoginServlet</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		pw.println("req.getParameter userId : " +req.getParameter("userId")+"<br/>");
		pw.println("req.getParameter password : " +req.getParameter("password")+"<br/>");
		for(String str : userIdValues){
			pw.println(
					"userIdValues "+str + "<br>"	
			);
		}
		
		
		for(String str : requestMap.get("userId") ){
			pw.println(
					"requestMap str :" + str +"<br/>"
			);
		}	
		pw.println("requestMap.get(password) :" + requestMap.get("password"));
		
		pw.println("		</body>");
		pw.println("	</html>");
		
		

		
	}
}
