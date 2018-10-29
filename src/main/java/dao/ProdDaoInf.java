package dao;

import java.util.List;

import kr.or.ddit.prodModel.ProdVo;
import kr.or.ddit.userModel.PageVo;

public interface ProdDaoInf {
	List<ProdVo> prodList(PageVo page);
	int getProdCnt();
	ProdVo selectProd(ProdVo prodVo);
	
	ProdVo selectProd(String prodId);
}
