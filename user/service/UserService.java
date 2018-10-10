package service;

import java.util.List;

import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.userModel.pageVo;
import dao.UserDao;

public class UserService implements UserServiceInf {
	
	UserDao ud = new UserDao();

	@Override
	public List<UserVo> getUserAll() {
		return ud.getUserAll();
	}
	
	@Override
	public UserVo selectUser(String userId) {
		return ud.selectUser(userId);
	}
	
	@Override
	public UserVo selectUser(UserVo userVo) {
		return ud.selectUser(userVo);
	}

	@Override
	public UserVo selectUser() {
	
		return null;
	}
	
	@Override
	public List<UserVo> selectUserPageList(pageVo page){
		return ud.selectUserPageList(page);
	}
	

}
