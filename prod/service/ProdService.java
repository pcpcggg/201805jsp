package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.userModel.PageVo;
import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.prodModel.ProdVo;
import dao.ProdDao;
import dao.ProdDaoInf;

public class ProdService implements ProdServiceInf{
	
	ProdDaoInf pd = new ProdDao();
	
	@Override
	public Map<String, Object> prodList(PageVo page){
		// 페이지에 해당하는 유저 리스트 (1~10건 사이)
		List<ProdVo> prodList = pd.prodList(page);
		
		// 페이지 내비게이션을 위한 유저 리스트 조회
		int totalProdCnt = pd.getProdCnt();
		
		// 결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("prodList", prodList);
		resultMap.put("pageCnt", (int)Math.ceil( (double)totalProdCnt / page.getPageSize()));
		
		return resultMap;
	}

	public int getProdCnt() {
		return pd.getProdCnt();
	}
	
	@Override
	public ProdVo selectProd(ProdVo prodVo) {
		return pd.selectProd(prodVo);
	}
	

	@Override
	public ProdVo selectProd(String prodId) {
		return pd.selectProd(prodId);
	}
}
