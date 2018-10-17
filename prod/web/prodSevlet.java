package web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prodModel.ProdVo;
import kr.or.ddit.userModel.PageVo;
import kr.or.ddit.userModel.UserVo;
import service.ProdService;
import service.ProdServiceInf;
import service.UserService;
import service.UserServiceInf;

@WebServlet("/prod")
public class prodSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public prodSevlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdServiceInf prodService = new ProdService();
		
		PageVo pageVo = new PageVo() ;
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		
		Map<String, Object> resulMap = prodService.prodList(pageVo);
		
		List<ProdVo> pageList = (List<ProdVo>)resulMap.get("prodList");
		
		int pageCnt = (int) resulMap.get("pageCnt");

		request.setAttribute("pageList", pageList);
		request.setAttribute("pageCnt", pageCnt);
		
		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodPageList.jsp");
		rd.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
