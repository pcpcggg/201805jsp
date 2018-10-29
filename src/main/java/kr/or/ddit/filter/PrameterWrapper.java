//package kr.or.ddit.filter;
//
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
//
//public class PrameterWrapper extends HttpServletRequestWrapper {
//	
//	private Map<String, String[]> newMap;
//	
//	public PrameterWrapper(HttpServletRequest request) {
//		super(request);
//		
//		//reuqest 객체의 parmeterMap객체를 복사하여 새로운 map객체를 생성
//		newMap = new HashMap<String, String[]>(request.getParameterMap());
//	}
//	
//	//새로운 파라미터를 저장한다.
//	public void setParameter(String key, String[] values){
//		newMap.put(key, values);
//	}
//	
//	//parameter 관련 메소드 재정의
//	//getParameter(String name);
//	//getParameterValeus(String name);
//	//getParameterMap();
//	//getParameterNames();
//	
//	@Override
//	public Map<String, String[]> getParameterMap() {
//		return newMap;
//	}
//	
//	public String[] getParameterValeus(String name) {
//		return newMap.get(name);
//	}
//	
//	@Override
//	public String getParameter(String name) {
//		String[] values = newMap.get(name);
//		if(values == null){
//			return null;
//		}else{
//			return values[0];
//		}
//		
//	}
//	
//	@Override
//	public Enumeration<String> getParameterNames() {
//		return Collections.enumeration(newMap.keySet());
//	}
//}
