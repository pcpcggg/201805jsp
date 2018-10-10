<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.userModel.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/header.jsp"%>
<%@include file="/common/left.jsp"%>

			<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>번호</th>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>생일</th>
				</tr>
				<%
					List<UserVo> userList = (List<UserVo>)request.getAttribute("userList");
					int i = 1;
					for(UserVo uv : userList ){
				%>
					<tr>
						<td><%=i++ %></td>
						<td><%= uv.getUserId() %></td>
						<td><%= uv.getName() %></td>
						<td><%= uv.getBirth() %></td>
	
					</tr>
				
				<%} %>

			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
			
		</div>
	</div>
	<!-- /.blog-main -->
	</div>
</body>
</html>