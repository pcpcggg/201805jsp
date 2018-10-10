package kr.or.ddit.userDao;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.userModel.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class selectUserDao {
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
}
