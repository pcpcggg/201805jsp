package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.util.StringUtil;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/userUpdate")
public class UserUpdateSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServiceInf userService = new UserService();
		String userId = request.getParameter("userId");
		
		// 사용자 아이디에 해당하는 사용자 정보 조회
		UserVo userVo = userService.selectUser(userId);
		
		// jsp로 위임하기 위해 사용자 정보를 requset에 저장
		request.setAttribute("userVo", userVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userUpdateForm.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post 한글 파라미터 인코딩 처리
		
		request.setCharacterEncoding("utf-8");
		
		// 파일 업로드 처리
		String fileName ="";
		String profile ="";
		Part profilePart = request.getPart("profile");
		String ContentDisposition = profilePart.getHeader("Content-disposition");
		fileName = StringUtil.getFileNameFrimHeader(ContentDisposition);
		
		
		//파라미터 받아오기
		// userId, name, pass, addr1, addr2, birth, zipcd, email, tel
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String birth = request.getParameter("birth");
		String zipcd = request.getParameter("zipcd");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		// /profile/moon.png
		
		
		
		System.out.println(userId + "/" + name+ "/" + pass+ "/" + addr1+ "/" + addr2+ "/" + birth+ "/" + zipcd+ "/" + email+ "/" + tel +"/" );
		
		// 파라미터를 userVo
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setName(name);
		userVo.setPass(pass);;
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		
		UserServiceInf usi = new UserService();
		String userIdChk = request.getParameter("userId");
		UserVo userFile = usi.selectUser(userIdChk);

		
		if(fileName.equals("")){
			profile = userFile.getProfile();
		}else{
			String path = getServletContext().getRealPath("/profile");
			profilePart.write(path + File.separator + fileName);
			profilePart.delete(); // 파일업로드 과정에서 사용한 디스크 임시 영역에서 지원줌
			profile = "/profile/" + fileName;
		}
		
		userVo.setProfile(profile);
		
		SimpleDateFormat sdf ;
		try {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			userVo.setBirth(sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		userVo.setZipcd(zipcd);
		userVo.setEmail(email);
		userVo.setTel(tel);
		
		// 사용자 등록 서비스 호출
		
		UserServiceInf userService = new UserService();
		int updateCnt = userService.updateUser(userVo);
		
		// 사용자 리스트로 이동 (redirect : 서버 상태가 변경되므로 사용자가 새로고침을 통해)
		// 재요청시 중복 등록되는 현상을 막는다.
		response.sendRedirect("/userDetail?userId="+userVo.getUserId());
		
	}

}
