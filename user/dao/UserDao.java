package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.userModel.pageVo;

public class UserDao implements UserDaoInf {
	
	
	public UserDao(){}


	public List<UserVo> getUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		return session.selectList("user.user");
	}
	
	public UserVo selectUser(String userId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		return session.selectOne("user.selectUser",userId);
		
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		return session.selectOne("user.selectUserByVo",userVo);
		
	}
	
	public List<UserVo> selectUserPageList(pageVo page){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		return session.selectList("user.selectUserPageList", page);
	}
	
	
}
