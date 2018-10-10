package kr.or.ddit.userDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.userModel.UserVo;

public class UserDao {
	public List<UserVo> getUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFantory();
		SqlSession session = factory.openSession();
		
		return session.selectList("user.user");
	}
	
	
	
}
