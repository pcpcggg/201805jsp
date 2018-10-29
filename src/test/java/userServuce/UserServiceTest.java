package userServuce;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import kr.or.ddit.userModel.PageVo;
import kr.or.ddit.userModel.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import service.UserService;
import service.UserServiceInf;
import dao.UserDao;
import dao.UserDaoInf;

public class UserServiceTest {
	
	// junit 실행주기
	// @BeforeClass 어노테이션이 적용된 메소드 실행 (최초 1회)
	// @Before 어노테이션이 적용된 메소드 실행 (테스트 메소드 실행전 실행)
	// @Test
	// @After 어노테이션이 적용된 메소드 실행(테스트 메소드 실행후 실행)
	// @AfterClass 어노테이션이 적용된 메소드 실행(최초 1회), 단 static 메소드로 선언
	
	// beforeClass
	// beforeClass --> before --> selectUserAll --> after
	// beforeClass --> before --> selectUser(String) --> after
	// beforeClass --> before --> selectUser(UserVo) --> after
	// afterClass
	
	private static String test ="";
	
	private UserServiceInf userS;
	private UserDaoInf userDao;

	
	@Before
	public void setup(){
		userDao = new UserDao();
		
	}
	
	@BeforeClass
	public static void beforeClass() {

		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
	
	@Before
	public void before(){
		System.out.println("before");
		userS = new UserService();
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	
	
	// 운영 메소드이름 + Test
	
	@Test
	public void getUserAll(){
		
		//list타입 리턴값을 받기 위해 list userVo선언 후   userDao값을 넣어준다.
		List<UserVo> userList = userS.getUserAll();
		// 향상된 반복문으로 콘솔에 찍기
		for (UserVo uv : userList){
			System.out.println(uv.toString());
		}
		// 테스트이기 때문에 디비값을 갯수를 알고있음.
		assertEquals(105, userList.size());
		
	}
	
	public String userId = "brown";
	
	@Test
	public void selectUser(){

		
		//list타입 리턴값을 받기 위해 list userVo선언 후   userDao값을 넣어준다.
		UserVo usv = userS.selectUser(userId);
		
		System.out.println(usv);
		
		// 테스트이기 때문에 디비값을 갯수를 알고있음.
		assertNotNull(usv);
		assertEquals("brown", usv.getUserId());
		assertEquals("브라운", usv.getName());
	}
		
	@Test
	public void selectUserByVo(){
	
		
		UserVo userVOvo = new UserVo();
		//list타입 리턴값을 받기 위해 list userVo선언 후   userDao값을 넣어준다.
		userVOvo.setUserId("brown");
		
		UserVo usv = userS.selectUser(userVOvo);
		
		System.out.println(usv);
		
		// 테스트이기 때문에 디비값을 갯수를 알고있음.
		assertNotNull(usv);
		assertEquals("brown", usv.getUserId());
		assertEquals("브라운", usv.getName());
	}
	
	
	@Test
	
	public void selectUserPageList(){
		
		
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		
		/***When***/
		Map<String, Object> resultMap = userS.selectUserPageList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		
		int pageCnt = (Integer)resultMap.get("pageCnt");
		
		/***Then***/
		assertEquals(10, userList.size());
		assertEquals(11, pageCnt);
	}
	
	@Test
	public void insertUserTest(){
		/***Given***/
		// userVo 준비 
		UserVo userVo = new UserVo();
		UserDaoInf userDao = new UserDao();
		
		userVo.setUserId("test123213");
		userVo.setName("testname");
		userVo.setPass("pass1234");
		userVo.setAddr1("대전 중구 중앙로 76");
		userVo.setAddr2("영민 빌딩 2층 대덕인재개발원");
		userVo.setZipcd("34940");
		
		GregorianCalendar gc = new GregorianCalendar(2018, 7, 8);
		userVo.setBirth(new Date(gc.getTimeInMillis()));
		
		userVo.setEmail("newUser@gamil.com");
		userVo.setTel("0422228202");
				
				
		/***When***/
		// userDao.insertUser()
		int insertCnt = userDao.insertUser(userVo);
		
		/***Then***/
		// 입력건수 비교
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteUserTest(){
		
		/***Given***/
		UserVo userVo = new UserVo();
		UserDaoInf userDao = new UserDao();
		
		userVo.setUserId("test123213");

		/***When***/
		
		int deleteCnt = userDao.deleteUser(userId);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	//gwt
	
	/***Given***/
	

	/***When***/

	/***Then***/

	

}
	
