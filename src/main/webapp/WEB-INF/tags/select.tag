<%@tag language="java" pageEncoding="UTF-8"%>
<%@tag import="java.util.*"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.DriverManager"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="length" required="false" type="java.lang.String" %>
<script src="/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#select").on("change",function(){
			var val = $(this).val();	
			$(".in").val(val);
		});
	});
</script>


<%
	// DB작업에 필요한 객체변수 선언

			String prod_id = length;
			String prod_name = "";
	
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;	// 쿼리문이 select일때만 필요하다.
	
			
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "chan"; // 등록된 사용자 id
				String pass = "1234"; // 등록된 사용자 암호
				
				conn = DriverManager.getConnection(url, user, pass);
				
				stmt = conn.createStatement();
				String sql = "select prod_id, prod_name from prod where prod_lgu ='"+prod_id+"'";
				
				rs = stmt.executeQuery(sql); 
				
				System.out.println("실행 쿼리문 :" + sql);
				System.out.println("============================");
				
				%>
				선택한 id : <input type="text" readonly="readonly" class="in">
				<select id="select" name="select">
				<%
					while(rs.next()){
					%>
						<option value="<%= rs.getString("prod_id") %>"><%= rs.getString("prod_name") %> </option>
					<%
					}
				%>
				</select>
				<%
				
				
			} catch (SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} finally{
				// 6. 사용했던 자원을 반납한다.
				if(rs != null)try{rs.close();}catch (Exception e2) {}
				if(rs != null)try{stmt.close();}catch (Exception e2) {}
				if(rs != null)try{conn.close();}catch (Exception e2) {}
			}
			
	
	%>
	
	
	
	