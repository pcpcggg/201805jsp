package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* BasicServlet.java
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
* 현재 시간을 출력하는 html 생성하는 서블랫
* </pre>
*/
public class BasicServlet extends HttpServlet {
	
	
	// 요청  http 매소드에 따라 실행도니느 메소드가 달라진다. doGet , doPost
	// get : doGet
	// post : doPost
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	//-
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//HttpServletRequest : 요청에 대한 정보
		//HttpServletResponse : 응답에 대한 정보
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw =  resp.getWriter();
		
		//date format을 이용하여
		// 년월일  만을 화면에 출력
		// simpleDateFormat
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:hh:mm"); 
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		pw.println("			hello, world");
		pw.println("			<br>"+ sdf);
		pw.println("		</body>");
		pw.println("	</html>");
		
		
		pw.println(sdf.format(date));
		pw.println("hello, world");
		pw.println(date);
		
	}
	
}

// 정적자료 : index.html --> url
// 동적자료 : servlet --> url mapping 구성필요 : web.xml

