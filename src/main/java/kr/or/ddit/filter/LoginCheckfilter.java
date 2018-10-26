package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import service.UserService;
import service.UserServiceInf;
import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.userModel.UserVo;

public class LoginCheckfilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// 세션이 있을때 : 전부 통과
		
		
		
		
//		HttpSession S_USER =((HttpServletRequest)request).getSession();
//		
//		System.out.println(request.getParameter("userId"));
//		
//		if(request.getParameter("userId")!= null){
//			request.setAttribute("S_USER", request.getParameter("userId"));
//			chain.doFilter(request, response);
//		}
//		
//		if(S_USER.getAttribute("S_USER") == null){
//			request.getRequestDispatcher("/").forward(request, response);
//		}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
