package dao;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.prodModel.ProdVo;
import kr.or.ddit.userModel.PageVo;



import kr.or.ddit.userModel.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProdDao implements ProdDaoInf {
	
	public List<ProdVo> prodList(PageVo page){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<ProdVo> prodList = session.selectList("prod.prodList", page);
		session.close();
		
		return prodList;
	}
	
	public int getProdCnt(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int getProdCnt = session.selectOne("prod.getProdCnt");
		session.close();
		
		return getProdCnt;
	}
	
	public ProdVo selectProd(ProdVo prodVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		ProdVo selectProd = session.selectOne("prod.selectProdByVo",prodVo);
		session.close();
		
		return selectProd;
		
	}
	
	public ProdVo selectProd(String prodId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		ProdVo selectProd = session.selectOne("prod.selectProd",prodId);
		session.close();
		
		return selectProd;
		
	}



}
