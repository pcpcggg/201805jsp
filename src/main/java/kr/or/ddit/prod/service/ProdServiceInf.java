package kr.or.ddit.prod.service;

import java.util.Map;

import kr.or.ddit.prodModel.ProdVo;
import kr.or.ddit.userModel.PageVo;


public interface ProdServiceInf {

	Map<String, Object> prodList(PageVo page);
	int getProdCnt();
	ProdVo selectProd(ProdVo prodVo);
	ProdVo selectProd(String prodId);
}
