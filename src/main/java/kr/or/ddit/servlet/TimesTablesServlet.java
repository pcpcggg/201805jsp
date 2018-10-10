package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* TimesTablesServlet.java
*
* @author chan
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* chan 최초 생성
*
* 구구단 만들기
* </pre>
*/
public class TimesTablesServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw =  resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("<style>");
		pw.println(" td { border :1px solid #ddd; padding:10px;}");
		pw.println("</style>");
		pw.println("		</head>");
		pw.println("		<body>");
		for(int z = 1; z <= 9; z++){
			if( z%2 == 0){
				pw.println(z);
				pw.println("			<table>");
				for(int j = 1; j<= 9; j++){
					pw.println("				<tr>");
					for(int i = 2; i <= 9; i++ ){
						pw.println("					<td>");
						pw.println(						i + " * " + j + " = " + i*j);
						pw.println("					</td>");
					}
					pw.println("				</tr>");
				}
				pw.println("			</table>");
				pw.println("<br>");
			}
		}
		pw.println("		</body>");
		pw.println("	</html>");
		
	}
	
}
