package kr.or.ddit.fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.userModel.UserVo;

@WebServlet("/fileDownloadSevlet")
public class FileDownloadSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		UserServiceInf userService = new UserService();
		
		UserVo userVo = userService.selectUser(userId);
		
		
		File f = new File(userVo.getProfile());
		
		FileInputStream fis = new FileInputStream(f);
		byte[] buffer = new byte[512];
		int len = 0;
		
		ServletOutputStream sos = response.getOutputStream();
		
		//파일을 일기
		while( (len = fis.read(buffer)) != -1){
			// 파일 쓰기
			sos.write(buffer, 0, len);
		}
		sos.close();
		fis.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
