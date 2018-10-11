<%@page import="kr.or.ddit.userModel.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.userModel.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/header.jsp"%>
<%@include file="/common/left.jsp"%>

<script>
	$(document).ready(function(){
		console.log("123");
		// tr에 select (class = "userCilck")
		
		$(".userClick").on("click", function(){
			console.log("1234");
			var userId = $(this).children()[1].innerText;
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
	});
</script>

<style>
.userClick {cursor: pointer;}
.userClick:hover { background: #ccc !important;}
</style>

<form action="/userDetail" method="get" id="frm" >
	<input type="hidden" id="userId" name="userId"/>
</form>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자 userPageList</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>번호</th>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>생일</th>
				</tr>
				<%
					List<UserVo> userList = (List<UserVo>)request.getAttribute("pageList");

					for(UserVo uv : userList ){
				%>
					<tr class="userClick">
						<td><%= uv.getRnum() %></td>
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
				<li><a href=""><<</a></li>
				<li>
					<a href="/userPageList?page=1&pageSize=10" aria-label="Previous">
        				<span aria-hidden="true">&laquo;</span>
      				</a>
      			</li>
				<%
					int pagetCnt = (Integer)request.getAttribute("pageCnt");
					int pageSize = 5;
					for(int pageNum =1; pageNum <= userList.size() ; pageNum++){ 
				%>
						<li><a href="userPageList?page=<%=pageNum%>&pageSize=<%=pageSize%>"><%=pageNum%></a></li>
				<%	} %>
				<li>
					<a href="" aria-label="Next">
        				<span aria-hidden="true">&raquo;</span>
      				</a>
				</li>
				<li><a href="">>></a></li>
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