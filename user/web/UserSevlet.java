package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.userModel.pageVo;
import service.UserService;
import service.UserServiceInf;


@WebServlet("/userAllList")
public class UserSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// 전체 사용자 정보조회
		UserServiceInf userService = new UserService();
		List<UserVo> userList= userService.getUserAll();
		
		pageVo pageVo = new pageVo() ;
		List<UserVo> pageList = userService.selectUserPageList(pageVo);
		
		// 조회된 사용자 정보를 userAllList.jsp를 통해 화면처리
		// userAllList.jsp에서 userList를 참조하려면???
		// attribute
		// session, application, request
		
		// session에 특징 : 해당 사용자만 접근이 가능(사용자 전용 공간)
		// 자주 참조하는 데이터 
		// 너무 많은 데이터를 저장할 경우 ??? 과부화(OOM 유발 가능성)
		
		// application : 모든 사용자가 접근 가능(서버당 하나만 생성) --> 일반적으로 설정과 관련된 값을 저장
		
		// request : 해당 요청이 응답이 끝날때 까지
		
		request.setAttribute("userList", userList);
		
		// 화면으로 위임 : 2가지
		// 1. dispatch : 보통 일반적으로 사용. 
		// 2. sendRedirect : 서버에 데이터가 변경되 있을때
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
