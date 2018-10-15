<%@page import="kr.or.ddit.userModel.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.userModel.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/common/header.jsp"%>
<%@include file="/common/left.jsp"%>

<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.DecimalFormat"%>

<%
	UserVo userVoD = (UserVo)request.getAttribute("userVo");
	DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date nowDate = new Date();
	String tempDate = sdFormat.format(userVoD.getBirth());

%>


			<div class="row">
	<div class="col-sm-8 blog-main">
		<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<% if(userVoD.getProfile() == null){ %>
								<img src="/profile/no_image.png" width="300px;"/>
							<%}else{ %>
								<img src="<%=userVoD.getProfile()%>" width="300px;"/>
							<%}%>
						</div>
					</div>
		
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<% System.out.print(userVoD.getUserId() );%>
							<label for="userNm" class=" control-label"><%=userVoD.getUserId() %></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<label class=" control-label"><%= userVoD.getName() %></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%= userVoD.getAddr1()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class=" control-label"><%= userVoD.getAddr2()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class=" control-label"><%= userVoD.getZipcd() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<label class=" control-label"><%= tempDate %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<label class=" control-label"><%= userVoD.getEmail() %></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<label class=" control-label"><%= userVoD.getTel() %></label>
						</div>
					</div>
					
					<br/>
					<br/>
					
				</form>
				
				<form method="get" action="/userUpdate">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="hidden" name="userId" value="<%=userVoD.getUserId()%>">
							<button type="submit" class="btn btn-default">수정하기</button>
						</div>
					</div>
				</form>
	</div>
</div>
			
		</div>
	</div>
	<!-- /.blog-main -->
	</div>
</body>
</html>