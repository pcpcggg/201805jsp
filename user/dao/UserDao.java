package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.userModel.PageVo;

public class UserDao implements UserDaoInf {
	
	
	public UserDao(){}


	public List<UserVo> getUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<UserVo> userList = session.selectList("user.user");
		session.close(); // 닫아주기
		
		// cud는
		//session.commit();
		//session.rollback();
		
		return userList;
	}
	
	public UserVo selectUser(String userId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		UserVo selectUser = session.selectOne("user.selectUser",userId);
		session.close();
		
		return selectUser;
		
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		UserVo selectUser = session.selectOne("user.selectUserByVo",userVo);
		session.close();
		
		return selectUser;
		
	}
	
	public List<UserVo> selectUserPageList(PageVo page){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		List<UserVo> selectUserPageList = session.selectList("user.selectUserPageList", page);
		session.close();
		
		return selectUserPageList;
	}
	
	/**
	 * 
	* Method : getUserCnt
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	 */
	
	public int getUserCnt(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		int getUserCnt = session.selectOne("user.getUserCnt");
		session.close();
		
		return getUserCnt;
	}
	
	
}
