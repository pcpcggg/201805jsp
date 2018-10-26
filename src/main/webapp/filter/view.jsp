<%@page import="kr.or.ddit.filter.RequestCointerFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
view.jsp

<%-- post --%>
userNm : ${userNm}<br/>
<form method="post" action="/filterServlet">
	${userNm}
	<input type="text" name="userNm" value="브라운"><br/>
	<button type="submit">전송</button>
</form>

<%--<%= RequestCointerFilter.uriMap --%>
<br/>
<c:forEach items="${uriMap}" var="map">
	${map.key}, ${map.value} <br/>
</c:forEach>

</body>
</html>