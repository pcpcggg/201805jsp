package dao;

import java.util.List;

import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.userModel.PageVo;

public interface UserDaoInf {
	public List<UserVo> getUserAll();
	
	public UserVo selectUser(String userId);
	
	public UserVo selectUser(UserVo userVo);
	
	public List<UserVo> selectUserPageList(PageVo page);
	
	/**
	* Method : getUserCnt
	* 작성자 : chan
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	int getUserCnt();
	
}
