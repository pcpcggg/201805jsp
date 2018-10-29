package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestCointerFilter implements Filter{
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//application
		ServletContext application = request.getServletContext();
		
		// application 객체에서 requestMap 가져오기
		Map<String, Integer> uriMap = (Map<String, Integer>) application.getAttribute("uriMap");
		
		//String uri =((HttpServletRequest)request).getRequestURI();
		//Integer cntS = uriMap.get(uri);
		
		
		//application 객체에 rcMap 객체가 존재하는지 확인
		if(uriMap==null){
			uriMap = new HashMap<String, Integer>();
			
		}
		
		String uri =((HttpServletRequest)request).getRequestURI();
		Integer cntS = uriMap.get(uri);
		
		
		// 최초요청시
		if(cntS == null){
			uriMap.put(uri, 1);
		}else{
			uriMap.put(uri, ++cntS);
		}
		application.setAttribute("uriMap", uriMap);

//		
//		System.out.println(uriMap);
//		
//		request.getServletContext().setAttribute("uriMap", uriMap);
//		
//		System.out.println(request.getServletContext());
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
