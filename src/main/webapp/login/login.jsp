<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="http://getbootstrap.com/favicon.ico">
<!-- Bootstrap core CSS -->
<link href="http://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="http://getbootstrap.com/docs/4.1/examples/sign-in/signin.css" rel="stylesheet">

<title>Insert title here</title>
<style type="text/css">
	ul { list-style: none;}
	li span { width: 65px; display:inline-block; margin-bottom: 5px;}
	
	
</style>

</head>
<body>
	<%-- 브라우저 주소줄에 입력한경우 : get
		 form 태그의 method 속성 : get/post
	 --%>
	

	<form class="form-signin" style="text-align: center;" method="post" action="/dditLogin">
      <img class="mb-4" src="http://getbootstrap.com/docs/4.1/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">아이디</label>
      <input type="text" name="userId" id="inputEmail" class="form-control" placeholder="아이디를 넣어주세요." required autofocus>
      <label for="inputPassword" class="sr-only">암호</label>
      <input type="password" name="password" id="inputPassword" class="form-control" placeholder="암호를넣어주세요." required>
      
  
      <input class="btn btn-lg btn-primary btn-block"  type="submit" value="로그인">
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>

     
	
</body>
</html>