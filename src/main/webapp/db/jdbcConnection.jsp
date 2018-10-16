<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
			// 작업하기 전에 JBDC 드라이버를 Build Path에 추가한다.
			
			// DB작업에 필요한 객체변수 선언
			Connection conn = null;
			ResultSet rs = null; 

			try{
				// 1. JBDC 드라이버 로딩  ==> Class.forName()을 이용한다.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				// 2. 해당 DB에 접속하기 ==> 접속
				//		==> DriverManger.getConnection()을 이용하고
				//		==> 접속이 성공하면 Connection객체가 생성된다.
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "chan"; // 등록된 사용자 id
				String pass = "1234"; // 등록된 사용자 암호
				
				long startTime = System.currentTimeMillis();
				for(int i=0; i < 30; i++){
					conn = DriverManager.getConnection(url, user, pass);
					out.println("schema : " + conn.getSchema());
				%>
					<br/>
				<%
					try{conn.close();}catch (Exception e2) {}
				}
				long endTime = System.currentTimeMillis();
				%>
				<br/>
				<%
				out.println("endTime - startTime : " + (endTime - startTime) + "ms");
				
				conn = DriverManager.getConnection(url, user, pass);
							
				
			} catch (SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} finally{
				
				if(rs != null)try{conn.close();}catch (Exception e2) {}
			}
			
	
	%>

</body>
</html>