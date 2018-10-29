package kr.or.ddit.prod.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.prodModel.ProdVo;


@WebServlet("/prodDetail")
public class prodDetailSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public prodDetailSevlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProdServiceInf ProdService = new ProdService();
		String prodId = request.getParameter("prodId");
		
		// 사용자 아이디에 해당하는 사용자 정보 조회
		ProdVo prodVo = ProdService.selectProd(prodId);
		
		// jsp로 위임하기 위해 사용자 정보를 requset에 저장
		request.setAttribute("prodVo", prodVo);

		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodDetail.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
