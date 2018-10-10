package dao;

import java.util.List;

import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.userModel.pageVo;

public interface UserDaoInf {
	public List<UserVo> getUserAll();
	
	public UserVo selectUser(String userId);
	
	public UserVo selectUser(UserVo userVo);
	
	public List<UserVo> selectUserPageList(pageVo page);
}
