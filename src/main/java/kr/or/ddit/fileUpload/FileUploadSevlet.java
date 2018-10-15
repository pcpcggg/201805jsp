package kr.or.ddit.fileUpload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/fileUpload")
public class FileUploadSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	// fileUpload.jsp 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/fileupload/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 일반 text 파라미터 : requset.getParameter("파라미터명");
		// 파일 : requset.getPart("파라미터명");
		
		//System.out.println(request.getReader());
		System.out.println(request.getContentType());
		System.out.println("userId : " + request.getParameter("userId"));
		//System.out.println(request.getParameter("profile"));
		
		// profile part
		Part profilePart = request.getPart("profile");
		System.out.println("profilePart : "+profilePart.getContentType());
		
		//Content-disposition 헤더 정보
		// 파일과 관련된 부가정보
		System.out.println("Content-disposition : " + profilePart.getHeader("Content-disposition"));
		
		String ContentDisposition = profilePart.getHeader("Content-disposition");
		
		int StringStart = ContentDisposition.indexOf("filename=");
		int StringEnd = ContentDisposition.lastIndexOf("\"");
		
		String fileName = ContentDisposition.substring(StringStart+10, StringEnd);
		
		// 파일쓰기
		profilePart.write("C:\\Users\\chan\\Desktop\\DeveloperCourse\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + fileName);
		profilePart.delete(); // 파일업로드 과정에서 사용한 디스크 임시 영역에서 지원줌
		
		
	}

}
