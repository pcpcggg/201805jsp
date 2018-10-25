<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" required="false" type="java.lang.Integer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--length : ${length} --%>

<style>

	.dd1{ color: #ff0;}
	.dd2{ color: #0f0;}
	.dd3{ color: #ff0;}
	.dd4{ color: #00f;}
	.dd5{ color: #000;}
	
.spin{
  -webkit-animation: spin 2s infinite linear;
  animation: spin 2s infinite linear;
  color: #f00;
  font-size: 20px;
  width: 400px;
}
 
@-webkit-keyframes spin {
    0%  {-webkit-transform: rotate(0deg);}
    100% {-webkit-transform: rotate(360deg);}
}
 
@keyframes spin {
    0%  {transform: rotate(0deg);}
    100% {transform: rotate(360deg);}
}
</style>

<div class="spin">
	<c:forEach begin="1" end="${length == '' ? 20: length}" varStatus="ee">
		<span class="dd${ee.index}"><c:out value="="/></span>
	</c:forEach>
	logging
	<c:forEach begin="1" end="${length == '' ? 20: length}" varStatus="ee">
		<span class="dd${ee.index}"><c:out value="="/></span>
	</c:forEach>
</div>