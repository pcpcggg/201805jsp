package service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.userModel.UserVo;
import kr.or.ddit.userModel.PageVo;

public interface UserServiceInf {

	List<UserVo> getUserAll();

	UserVo selectUser();

	UserVo selectUser(UserVo userVo);

	UserVo selectUser(String userId);
	
	/**
	 * 
	* Method : selectUserPageList
	* 작성자 : chan
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 사용자 페이지 조회
	 */

	Map<String, Object> selectUserPageList(PageVo page);

}
