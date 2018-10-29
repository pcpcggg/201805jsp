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

@WebServlet("/fileDownloadName")
public class FileDownloadNameSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파일 대한 정보 (파일명 등)
		// 응답에 대한 정보(html 이 아니라 바이너리 파일)
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition","attachment; filename=git.txt");
		
		
		File f = new File("C:\\Users\\chan\\Desktop\\DeveloperCourse\\A_TeachingMaterial\\6.JspSrpgin\\upload\\git.txt");
		
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
