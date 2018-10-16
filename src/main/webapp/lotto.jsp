<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
	body { text-align: center;}
	#myCanvas {
		margin-top : 300px;
		border : 1px solid #000;
	}
	
	span {
		line-height: 100px;
	    width: 100px;
	    display: block;
	    height: 100px;
	   
	    font-size: 20px;
	    font-weight: bold;
	    
	    -webkit-animation: spin 3s infinite linear;
	  	-o-animation: spin 3s infinite linear;
	  	-moz-animation: spin 3s infinite linear;
	  	animation: spin 3s infinite linear;
	}
	.con {
		 width:100px; height:100px; margin: 300px auto; transform: rotate(30deg)
		  border-radius: 50%;
		  margin: 0,0,0,0;
		  background-color: #0000FF;
		   border: 1px solid #ccc;
		   -webkit-transition:width 2s, height 2s, background-color 2s, -webkit-transform 2s;
    transition:width 2s, height 2s, background-color 2s, transform 2s, color 2s, border:3s margin:3;
		 }
	.con:HOVER{
		margin: 100,0,0,0;
		background-color: #FFCCCC;
		color: #ffff00;
		border: 5px solid #ff000;
		 transform: scale(4.05) !important;
	    -webkit-transform: scale(4.05) !important;
	    -moz-transform: scale(4.05);
	    -o-transform: scale(4.05);
	    -webkit-transition: .2s;
	    -moz-transition: .2s;
	    -ms-transition: .2s;
	    border-radius: 50%;
	}
	
	@-webkit-keyframes spin {
	    0%  {-webkit-transform: rotate(0deg);
	    	-webkit-transform: translateX(0);
	    }
	    100% {-webkit-transform: rotate(360deg);
	     transform: scale(4.05) !important;
	    -webkit-transform: scale(4.05) !important;
	    -moz-transform: scale(4.05);
	    -o-transform: scale(4.05);
	    -webkit-transition: .2s;
	    -moz-transition: .2s;
	    -ms-transition: .2s;}
	}
	 
	@-moz-keyframes spin {
	   0%  {-moz-transform: rotate(0deg);}
	    100% {-moz-transform: rotate(360deg);
	     transform: scale(4.05) !important;
	    -webkit-transform: scale(4.05) !important;
	    -moz-transform: scale(4.05);
	    -o-transform: scale(4.05);
	    -webkit-transition: .2s;
	    -moz-transition: .2s;
	    -ms-transition: .2s;}
	}
	@keyframes spin {
	    0%  {transform: rotate(0deg);}
	    100% {transform: rotate(360deg);
	    	 transform: scale(4.05) !important;
	    -webkit-transform: scale(4.05) !important;
	    -moz-transform: scale(4.05);
	    -o-transform: scale(4.05);
	    -webkit-transition: .2s;
	    -moz-transition: .2s;
	    -ms-transition: .2s;
	    
	    }
	    
	    
	}
	
	#homer *
{
    position: absolute;
    box-sizing:content-box;
    -moz-box-sizing:content-box;
}

#homer
{
    position: relative;
    width: 94px;
    height: 133px;
    margin: 0 auto;
}

#homer .head *
{
    border: 1px solid #110b00;
}

#homer .head .no-border
{
    border: none;
}

#homer .head .body
{
    background: #fbd800;
}

#homer .head .hair1
{
    top: 14px;
    left: 0px;    
    height:13px;
    width:22px;
    border-radius: 22px 22px 0 0;
    -moz-border-radius: 22px 22px 0 0;
    -webkit-border-radius: 22px 22px 0 0;
    background: transparent;
    -webkit-transform: rotate(-44deg);
    -ms-transform: rotate(-44deg);
    transform: rotate(-44deg);
    border-bottom: none;
}

#homer .head .hair2
{
    top: 8px;
    left: 9px;    
    height:16px;
    width:26px;
    border-radius: 32px 32px 0 0;
    -moz-border-radius: 32px 32px 0 0;
    -webkit-border-radius: 32px 32px 0 0;
    background: transparent;
    -webkit-transform: rotate(-27deg);
    -ms-transform: rotate(-27deg);
    transform: rotate(-27deg);
    border-bottom: none;
}

#homer .head .head-top
{
    top: 15px;
    left: 2px;
    width: 65px;
    height: 62px;
    border-bottom: none;
    -webkit-transform: rotate(-24deg);
    -ms-transform: rotate(-24deg);
    transform: rotate(-24deg);
    -moz-border-radius: 43% 44% 0 0;
    -webkit-border-radius: 43% 44% 0 0;
    border-radius: 43% 44% 0 0;
    -webkit-box-shadow: inset 8px 12px 0px -12px rgba(247,254,140,1), inset 13px 3px 0px -11px rgba(247,254,140,1), inset -2px 0px 0px 0px rgba(229,158,4,1);
    -moz-box-shadow: inset 8px 12px 0px -12px rgba(247,254,140,1), inset 13px 3px 0px -11px rgba(247,254,140,1), inset -2px 0px 0px 0px rgba(229,158,4,1);
    box-shadow: inset 8px 12px 0px -12px rgba(247,254,140,1), inset 13px 3px 0px -11px rgba(247,254,140,1), inset -2px 0px 0px 0px rgba(229,158,4,1);
}

#homer .head .head-main
{
    top: 40px;
    left: 17px;
    width: 48px;
    height: 62px;
    -webkit-transform: rotate(-24deg);
    -ms-transform: rotate(-24deg);
    transform: rotate(-24deg);
}

#homer .head .m1, #homer .head .m2, #homer .head .m3, #homer .head .m4
{
    width: 1px;
    height: 14px;
    background: #110b00;
}

#homer .head .m1
{
    top: 77px;
    left: 9px;
    -webkit-transform: rotate(-13deg);
    -ms-transform: rotate(-13deg);
    transform: rotate(-13deg);
}

#homer .head .m2
{
    top: 76px;
    left: 12px;
    height: 12px;
    -webkit-transform: rotate(-45deg);
    -ms-transform: rotate(-45deg);
    transform: rotate(-45deg);
}

#homer .head .m3
{
    top: 71px;
    left: 16px;
    height: 15px;
    -webkit-transform: rotate(1deg);
    -ms-transform: rotate(1deg);
    transform: rotate(1deg);
}

#homer .head .m4
{
    top: 70px;
    left: 21px;
    -webkit-transform: rotate(-39deg);
    -ms-transform: rotate(-39deg);
    transform: rotate(-39deg);
}

#homer .head .ear
{
    top: 90px;
    left: 14px;
    width: 11px;
    height: 13px;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}

#homer .head .ear .inner1
{
    top: 3px;
    left: 2px;
    width: 7px;
    height: 5px;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
    border-top: 1px solid #110b00;
    -webkit-transform: rotate(-21deg);
    -ms-transform: rotate(-21deg);
    transform: rotate(-21deg);
}

#homer .head .ear .inner2
{
    top: 3px;
    left: 4px;
    width: 7px;
    height: 5px;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
    border-top: 1px solid #110b00;
    -webkit-transform: rotate(-109deg);
    -ms-transform: rotate(-109deg);
    transform: rotate(-109deg);
}

#homer .head .ear .clip
{
    top: 1px;
    left: 8px;
    width: 5px;
    height: 10px;
}

#homer .head .right-eye
{
    top: 48px;
    left: 48px;
    width: 31px;
    height: 31px;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
    background: #ffffff;
    box-shadow: -2px -1px 0px 0px rgba(247,254,140,1);
    overflow: hidden;
}

#homer .head .right-eye .right-eye-pupil
{
    top: 11px;
    left: 20px;
    width: 4px;
    height: 4px;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
    background: #110b00;
}

#homer .head .left-eye
{
    top: 51px;
    left: 23px;
    width: 31px;
    height: 31px;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
    background: #ffffff;
    box-shadow: -1px -1px 0px 0px rgba(247,254,140,1);
    overflow: hidden;
}

#homer .head .left-eye .left-eye-pupil
{
    top: 13px;
    left: 11px;
    width: 4px;
    height: 4px;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
    background: #110b00;
}

#homer .head .left-eye .eyelid-top
{
    top: -21px;
    left: 0px;
    width: 30px;
    height: 20px;
    border-bottom: 1px solid #110b00;
    border-radius: 50% 50% 0 0;
    
    -webkit-animation-name: homerlefteyelidtop;
    -webkit-animation-duration: 10s;
    -webkit-animation-timing-function: linear;
    -webkit-animation-delay: 1s;
    -webkit-animation-iteration-count: infinite;
    -webkit-animation-play-state: running;
    animation-name: homerlefteyelidtop;
    animation-duration: 10s;
    animation-timing-function: linear;
    animation-delay: 1s;
    animation-iteration-count: infinite;
    animation-play-state: running;
}

#homer .head .left-eye .eyelid-bottom
{
    bottom: -11px;
    left: 0px;
    width: 30px;
    height: 10px;
    border-top: 1px solid #110b00;
    border-radius: 0 0 50% 50%;
    
    -webkit-animation-name: homerlefteyelidbottom;
    -webkit-animation-duration: 10s;
    -webkit-animation-timing-function: linear;
    -webkit-animation-delay: 1s;
    -webkit-animation-iteration-count: infinite;
    -webkit-animation-play-state: running;
    animation-name: homerlefteyelidbottom;
    animation-duration: 10s;
    animation-timing-function: linear;
    animation-delay: 1s;
    animation-iteration-count: infinite;
    animation-play-state: running;
}


@-webkit-keyframes homerlefteyelidtop
{
0% {top: -21px;}
2% {top: 0px;}
4% {top: -21px;}
100% {top: -21px;}
}


@keyframes homerlefteyelidtop
{
0% {top: -21px;}
2% {top: 0px;}
4% {top: -21px;}
100% {top: -21px;}
}

@-webkit-keyframes homerlefteyelidbottom
{
0% {bottom: -11px;}
2% {bottom: 0px;}
4% {bottom: -11px;}
100% {bottom: -11px;}
}


@keyframes homerlefteyelidbottom
{
0% {bottom: -11px;}
2% {bottom: 0px;}
4% {bottom: -11px;}
100% {bottom: -11px;}
}

#homer .head .right-eye .eyelid-top
{
    top: -18px;
    left: 0px;
    width: 30px;
    height: 17px;
    border-bottom: 1px solid #110b00;
    border-radius: 50% 50% 0 0;
    
    -webkit-animation-name: homerrighteyelidtop;
    -webkit-animation-duration: 10s;
    -webkit-animation-timing-function: linear;
    -webkit-animation-delay: 1s;
    -webkit-animation-iteration-count: infinite;
    -webkit-animation-play-state: running;
    animation-name: homerrighteyelidtop;
    animation-duration: 10s;
    animation-timing-function: linear;
    animation-delay: 1s;
    animation-iteration-count: infinite;
    animation-play-state: running;
}

#homer .head .right-eye .eyelid-bottom
{
    bottom: -11px;
    left: 0px;
    width: 30px;
    height: 10px;
    border-top: 1px solid #110b00;
    border-radius: 0 0 50% 50%;
    
    -webkit-animation-name: homerrighteyelidbottom;
    -webkit-animation-duration: 10s;
    -webkit-animation-timing-function: linear;
    -webkit-animation-delay: 1s;
    -webkit-animation-iteration-count: infinite;
    -webkit-animation-play-state: running;
    animation-name: homerrighteyelidbottom;
    animation-duration: 10s;
    animation-timing-function: linear;
    animation-delay: 1s;
    animation-iteration-count: infinite;
    animation-play-state: running;
}

@-webkit-keyframes homerrighteyelidtop
{
0% {top: -18px;}
2% {top: 0px;}
4% {top: -18px;}
100% {top: -18px;}
}

@keyframes homerrighteyelidtop
{
0% {top: -18px;}
2% {top: 0px;}
4% {top: -18px;}
100% {top: -18px;}
}

@-webkit-keyframes homerrighteyelidbottom
{
0% {bottom: -11px;}
2% {bottom: 0px;}
4% {bottom: -11px;}
100% {bottom: -11px;}
}

@keyframes homerrighteyelidbottom
{
0% {bottom: -11px;}
2% {bottom: 0px;}
4% {bottom: -11px;}
100% {bottom: -11px;}
}

#homer .head .nose
{
    top: 71px;
    left: 50px;
    width: 18px;
    height: 12px;
    border-left: none;
    border-right: none;
    -webkit-transform: rotate(-13deg);
    -ms-transform: rotate(-13deg);
    transform: rotate(-13deg);
}

#homer .head .nose-tip
{
    top: 69px;
    left: 60px;
    width: 14px;
    height: 12px;
    border-left: none;
    -moz-border-radius: 0 50% 50% 0%;
    -webkit-border-radius: 0 50% 50% 0;
    border-radius: 0 50% 50% 0;
    -webkit-transform: rotate(-13deg);
    -ms-transform: rotate(-13deg);
    transform: rotate(-13deg);
}

#homer .head .neck1
{
    top: 85px;
    left: 16px;
    width: 6px;
    height: 31px;
    background: transparent;
    border-right: 1px solid #110b00;
    border-radius: 50% 50% 25% 50%;
    -webkit-transform: rotate(-14deg);
    -ms-transform: rotate(-14deg);
    transform: rotate(-14deg);
    -webkit-box-shadow: 2px 0px 0px 0px rgba(247,254,140,1), 5px 0px 0px 0px rgba(251,216,0,1);
    -moz-box-shadow: 2px 0px 0px 0px rgba(247,254,140,1), 5px 0px 0px 0px rgba(251,216,0,1);
    box-shadow: 2px 0px 0px 0px rgba(247,254,140,1), 5px 0px 0px 0px rgba(251,216,0,1);
}

#homer .head .neck2
{
    top: 114px;
    left: 25px;
    width: 45px;
    height: 19px;
    border-top: none;
    border-bottom: none;
    -webkit-box-shadow: inset 2px 0px 0px 0px rgba(247,254,140,1);
    -moz-box-shadow: inset 2px 0px 0px 0px rgba(247,254,140,1);
    box-shadow: inset 2px 0px 0px 0px rgba(247,254,140,1);
}

#homer .head .mouth1
{
    top: 86px;
    left: 28px;
    width: 48px;
    height: 44px;
    background: #cfae67;
    -moz-border-radius: 46% 52% 44% 50%;
    -webkit-border-radius: 46% 52% 44% 50%;
    border-radius: 46% 52% 44% 50%;
    -webkit-box-shadow: inset -1px -1px 0px 0px rgba(152,110,36,1);
    -moz-box-shadow: inset -1px -1px 0px 0px rgba(152,110,36,1);
    box-shadow: inset -1px -1px 0px 0px rgba(152,110,36,1);
}

#homer .head .mouth2
{
    top: 101px;
    left: 43px;
    width: 48px;
    height: 12px;
    background: #cfae67;
    -moz-border-radius: 46% 52% 44% 50%;
    -webkit-border-radius: 46% 52% 44% 50%;
    border-radius: 46% 52% 44% 50%;
    -webkit-transform: rotate(-15deg);
    -ms-transform: rotate(-15deg);
    transform: rotate(-15deg);
    -webkit-box-shadow: inset -1px 0px 0px 0px rgba(152,110,36,1);
    -moz-box-shadow: inset -1px 0px 0px 0px rgba(152,110,36,1);
    box-shadow: inset -1px 0px 0px 0px rgba(152,110,36,1);
}

#homer .head .mouth3
{
    top: 102px;
    left: 35px;
    width: 48px;
    height: 12px;
    background: transparent;
    -moz-border-radius: 46% 52% 44% 50%;
    -webkit-border-radius: 46% 52% 44% 50%;
    border-radius: 46% 52% 44% 50%;
    border-bottom: 1px solid #110b00;
    -webkit-transform: rotate(-4deg);
    -ms-transform: rotate(-4deg);
    transform: rotate(-4deg);
}

#homer .head .mouth4
{
    top: 110px;
    left: 38px;
    width: 7px;
    height: 5px;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
    border-top: 1px solid #110b00;
    -webkit-transform: rotate(-81deg);
    -ms-transform: rotate(-81deg);
    transform: rotate(-81deg);
}

#homer .head .mouth5
{
    top: 84px;
    left: 64px;
    width: 27px;
    height: 13px;
    background: transparent;
    -moz-border-radius: 46% 52% 44% 50%;
    -webkit-border-radius: 46% 52% 44% 50%;
    border-radius: 46% 52% 44% 50%;
    -webkit-transform: rotate(-131deg);
    -ms-transform: rotate(-131deg);
    transform: rotate(-131deg);
    border-top: none;
    -webkit-box-shadow: inset -1px -1px 0px 0px rgba(152,110,36,1);
    -moz-box-shadow: inset -1px -1px 0px 0px rgba(152,110,36,1);
    box-shadow: inset -1px -1px 0px 0px rgba(152,110,36,1);
}

#homer .head .mouth6
{
    top: 84px;
    left: 46px;
    width: 32px;
    height: 31px;
    background: #cfae67;
    -webkit-transform: rotate(-18deg);
    -ms-transform: rotate(-18deg);
    transform: rotate(-18deg);
    -moz-border-radius: 0 0 0px 22px;
    -webkit-border-radius: 0 0 0px 22px;
    border-radius: 0 0 0px 22px;
}

#homer .head .mouth7
{
    top: 104px;
    left: 62px;
    width: 17px;
    height: 12px;
    background: #cfae67;
    -moz-border-radius: 46% 52% 44% 50%;
    -webkit-border-radius: 46% 52% 44% 50%;
    border-radius: 46% 52% 44% 50%;
    border-left: none;
    border-bottom: none;
    -webkit-transform: rotate(6deg);
    -ms-transform: rotate(6deg);
    transform: rotate(6deg);
}

#homer .head .mouth8
{
    top: 79px;
    left: 71px;
    width: 15px;
    height: 30px;
    background: #cfae67;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
    -webkit-transform: rotate(-30deg);
    -ms-transform: rotate(-30deg);
    transform: rotate(-30deg);
}
	
	
</style>
</head>
<body>
	<!-- <canvas id="myCanvas" width="200" height="200"></canvas>
	 -->
	<%
	// DB작업에 필요한 객체변수 선언
			
			int randomNo = (int)(Math.random()*19)+1;
	
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;	// 쿼리문이 select일때만 필요하다.
			
			int no_203 = 0;
			String name_203 = null;
			
			try{
				// 1. JBDC 드라이버 로딩  ==> Class.forName()을 이용한다.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				// 2. 해당 DB에 접속하기 ==> 접속
				//		==> DriverManger.getConnection()을 이용하고
				//		==> 접속이 성공하면 Connection객체가 생성된다.
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "chan"; // 등록된 사용자 id
				String pass = "1234"; // 등록된 사용자 암호
				
				conn = DriverManager.getConnection(url, user, pass);
				
				// 3. Statement객체 또는 PreparedStatement 객체 생성 질의를 수행하고 결과를 받아오는 객체
				//					  ==> 이 객체의 생성은 Connection객체를 이용한다.
				stmt = conn.createStatement();
				
				// 4. Statement객체를 이용하여 질의를 수행하고
				//	    결과를 받아서 ResultSet객체에 담는다.
				//	  (단, ResultSet객체는 Select문일 때만 사용한다.)
				String sql = "select * from JSPSTUDENT where no =" + randomNo;// 실행할 sql명령
				rs = stmt.executeQuery(sql); // sql명령이 select일 경우 
											 // 기타 insert, update, delete 명령일 때는
											 // executeUpdate()를 사용한다. 
				
				// 5. ResultSet 객체에 저장되어 있는 자료를 
				//	    반복문과 next()메서드를 이용하여 차례로 읽어와 처리한다.
				System.out.println("실행 쿼리문 :" + sql);
				System.out.println("============================");
				
				// rs.next() ==> ResultSet 객체의 데이터를 가리키는 포인터를 다음 레코드로
				//			 ==> 이동시키고 그 곳에 데이터가 있으면 true, 없으면 false를 반환한다.
				
				
				while(rs.next()){
					//out.println(rs.getInt("no"));
					//out.println(rs.getString("name"));
					
					no_203 = rs.getInt("no") ;
					name_203 = rs.getString("name");
					
				}
				System.out.println();
				System.out.println("출력끝");
				
				
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
	
	<div id="homer" style="margin-top: 72px;">
					<div class="head">

					<div class="hair1"></div>
					<div class="hair2"></div>
					<div class="body head-top"></div>
					<div class="no-border body head-main"></div>
					<div class="no-border m1"></div>
					<div class="no-border m2"></div>
					<div class="no-border m3"></div>
					<div class="no-border m4"></div>
					<div class="no-border neck1"></div>
					<div class="body neck2"></div>
					<div class="body ear">
						<div class="no-border inner1"></div>
						<div class="no-border inner2"></div>
						<div class="no-border body clip"></div>
					</div>
					<div class="mouth">
						<div class="mouth5"></div>
						<div class="mouth2"></div>
						<div class="mouth1"></div>
						<div class="mouth7"></div>
						<div class="no-border mouth3"></div>
						<div class="no-border mouth4"></div>
						<div class="no-border mouth6"></div>
						<div class="no-border mouth8"></div>
					</div>
					<div class="right-eye">
						<div class="no-border right-eye-pupil"></div>
						<div class="no-border body eyelid-top"></div>
						<div class="no-border body eyelid-bottom"></div>
					</div>
					<div class="body nose"></div>
					<div class="body nose-tip"></div>
					<div class="left-eye">
						<div class="no-border left-eye-pupil"></div>
						<div class="no-border body eyelid-top"></div>
						<div class="no-border body eyelid-bottom"></div>
					</div>
					</div>
					</div>
	
	<div class="con">
		<span style=" width: 100px; height: 100px; border:1px solid #ccc"><%=name_203%></span>
	</div>
	
	<div> 마우스를 올려주세요.</div>
	
	
	
	
	<!-- 
	<script type="text/javascript">
		var name = "<%=name_203%>";
		var canvas = document.getElementById("myCanvas");
		var ctx = canvas.getContext("2d");
		ctx.fillStyle = "#0f0";
		//ctx.fillRect(0,0,150,75); 
		
		ctx.beginPath();
		ctx.arc(100,100,100,0,2*Math.PI);
		ctx.stroke();
		ctx.font = "60px Arial";
		ctx.fillText(name, 10 ,122);
	</script>
	 -->
</body>
</html>