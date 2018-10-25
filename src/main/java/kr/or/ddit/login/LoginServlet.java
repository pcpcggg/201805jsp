package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.userModel.UserVo;
import service.UserService;
import service.UserServiceInf;

public class LoginServlet extends HttpServlet{
	
	//service  --> request.getMethod() : "POST", "GET" --> doGet, doPost
	
//	private final String USERID = "brown";
//	private final String PASSWORD = "pass1234";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1. 사용자 아이디, 비밀번호를 reqeuest객체에서 받아온다.
		// 2. db에서 조회해온 아이디, 비밀번호를 체크한다.
		// 3-1. 일치할경우 main.jsp로 이동
		// 3-2. 불일치 할경우 login.jsp로 이동
		
		// 1
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		
		// remember-me 파라미터 받아서 sysout으로 출력
		// rememberMe == null : 아이디 기억 사용 안함
		String rememberMe = req.getParameter("remember-me");
		System.out.println("rememberMe :" + rememberMe);
		
		if(rememberMe == null){
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies){
				System.out.println(cookie.getName());
				
				if(cookie.getName().equals("remember")||
				  cookie.getName().equals("userId")){
					// -1 : 브라우저 재시작시 쿠키 삭제 반영
					// 0 : 바로삭제
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
		}
		// rerememberMe != null : 아이디 기억 사용
		else{
			// response 객체에 쿠기를 저장
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdCookie = new Cookie("userId", userId);
			
			resp.addCookie(cookie);
			resp.addCookie(userIdCookie);
		}
		
		
	
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw =resp.getWriter();
		
//		pw.println(userId);
//		pw.println(password);
		
		// 2 ---> db 대신 상수로 대체
		
		// 1. 사용자가 전송한 userId 파라미터로 사용자 정보조회
		
		UserServiceInf userS = new UserService();
		
		String dbUserId= userS.selectUser(userId).getUserId();
		
		UserVo usv = userS.selectUser(dbUserId);
		
		// 2. db에서 조회한 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교
		String encryptPass = KISA_SHA256.encrypt(password);
		
		if(usv != null && usv.authPass(encryptPass)){
			req.getSession().setAttribute("S_USER", usv);
			RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
			rd.forward(req, resp);
			// 3. session에 사용자 정보등록(as-is : 임의의 userVo 등록 / to-be : db에서 조회한 userVo)
		}else{
			resp.sendRedirect("login/login.jsp");
		}
	
		
		// 3-1 : main.jsp로 이동
//		if(USERID.equals(userId)&& PASSWORD.equals(password)){
//			// redirect
//			// resp.sendRedirect("main.jsp?userId="+userId+ "&password="+password);
//			
//			//session
//			UserVo userVo= new UserVo();
//			userVo.setUserId(userId);
//			userVo.setName("브라운");
//			userVo.setAlias("곰");
//			userVo.setBitrh(new Date());
//			
//			String id = req.getParameter(userVo.getUserId());
//			String name = req.getParameter(userVo.getName());
//			String alias = req.getParameter(userVo.getAlias());
//			//String bitrh = req.getParameter(userVo.getBitrh());
//			
//			req.getSession().setAttribute("userVo", userVo);
//			
//			
//			
//			//2. main.jsp
//			// body 영역에 이름 [별명]
//			
//			
//			
//			//dispatch
//			RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
//			rd.forward(req, resp);
//			
//			
//		}
//		// 3-2 : login.jsp 이동
//		else{
//			resp.sendRedirect("login/login.jsp");
//		}
//		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//post 방식에 인코딩 설정
				req.setCharacterEncoding("utf-8");
				
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter pw =resp.getWriter();
				
				pw.println("<!DOCTYPE html>");
				pw.println("	<html>");
				pw.println("		<head>");
				pw.println("			<meta charset=\"UTF-8\">");
				pw.println("			<title>Insert title here</title>");
				pw.println("		</head>");
				pw.println("		<body>");
				
				//userId : brwon / sally
				String[] userIds = req.getParameterValues("userId");
				for(String userId : userIds)
					pw.println("		userId : " + userId + "<br>");
				pw.println("		password : " + req.getParameter("password") + "<br>");
				pw.println("		</body>");
				pw.println("	</html>");
	}
}







