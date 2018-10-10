<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	//factorial method 선언
	
	public String msg(){
		return "hello, world";
	}
%>

<%=msg()%>
<br/>
<br/>
<%!
	int input = 0;
	
	public int factorial(int n){
		if(n<=1){
			return n;
		}
		else{
			return factorial(n-1)*n;
		}
	}
%>
<%
	for(int i =1; i <= 8; i++){
		input = i;
%>
	  결과값 factorial(<%= i %>) : <%=factorial(input)%>
	 <br/>
<%
	}
%>


</body>
</html>