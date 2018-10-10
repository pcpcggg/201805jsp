package service;

import java.util.List;

import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.userModel.pageVo;

public interface UserServiceInf {

	List<UserVo> getUserAll();

	UserVo selectUser();

	UserVo selectUser(UserVo userVo);

	UserVo selectUser(String userId);

	List<UserVo> selectUserPageList(pageVo page);

}
