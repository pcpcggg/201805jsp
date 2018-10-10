package kr.or.ddit.userTest;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.userDao.UserDao;
import kr.or.ddit.userDao.selectUserDao;
import kr.or.ddit.userModel.UserVo;

import org.junit.Test;

public class UserTest {

	@Test
	public void getUserAll(){
		UserDao userDao = new UserDao();
		
		//list타입 리턴값을 받기 위해 list userVo선언 후   userDao값을 넣어준다.
		List<UserVo> userList = userDao.getUserAll();
		// 향상된 반복문으로 콘솔에 찍기
		for (UserVo uv : userList){
			System.out.println(uv.toString());
		}
		// 테스트이기 때문에 디비값을 갯수를 알고있음.
		assertEquals(5, userList.size());
		
	}
	
	public String userId = "brown";
	
	@Test
	public void selectUser(){
		selectUserDao sud = new selectUserDao();
		
		//list타입 리턴값을 받기 위해 list userVo선언 후   userDao값을 넣어준다.
		UserVo usv = sud.selectUser(userId);
		
		System.out.println(usv);
		
		// 테스트이기 때문에 디비값을 갯수를 알고있음.
		assertNotNull(usv);
		assertEquals("brown", usv.getUserId());
		assertEquals("브라운", usv.getName());
	}
		
	@Test
	public void selectUserByVo(){
		selectUserDao sud = new selectUserDao();
		
		UserVo userVOvo = new UserVo();
		//list타입 리턴값을 받기 위해 list userVo선언 후   userDao값을 넣어준다.
		userVOvo.setUserId("brown");
		
		UserVo usv = sud.selectUser(userVOvo);
		
		System.out.println(usv);
		
		// 테스트이기 때문에 디비값을 갯수를 알고있음.
		assertNotNull(usv);
		assertEquals("brown", usv.getUserId());
		assertEquals("브라운", usv.getName());
	}
	
	
	//gwt
	
	/***Given***/
	

	/***When***/

	/***Then***/

		
}
	
