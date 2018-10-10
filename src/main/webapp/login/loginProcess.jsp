<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- login.jsp 에서 전송한 파라미터 : userId, password --%>
	<%-- request parameter 관련 메소드
		1. getParmeter(String name);
		2. getParmeterValues(String name )
		3. getParmeterMap();
		4. getParmeterNames();
	 --%>
	 <%
	 	String[] userIdValues = request.getParameterValues("userId");
	 
		Map<String, String[]> requestMap = request.getParameterMap();
		
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String parameterName = parameterNames.nextElement();
			System.out.println("parameterName : " + parameterName);
		}
	 %>
	 
	request.getParameter("userId") : <%= request.getParameter("userId") %><br/>
	request.getParameter("userId") : <% 
		for(String str : userIdValues){
			out.write(str + "<br>");
		}
	%><br/>
	
	request.getParameter("password") : <%= request.getParameter("password") %>
	<br/>
	<%
		for(String str : requestMap.get("userId") ){
	%>
			str : <%= str%><br/>
	<%} %>
	requestMap.get("password") : <%= requestMap.get("password") %>
	
	
	
</body>
</html>