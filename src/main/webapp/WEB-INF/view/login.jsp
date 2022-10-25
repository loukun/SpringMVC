<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body>
	<h2>用户登录</h2>
	<span style="color:red">${loginError }</span>
	<form action="${pageContext.request.contextPath }/login2" method="post">
	用户名：<input type="text" name="username"/> <br>
	密码：<input type="password" name="password"/> <br>
	<input type="submit" value="登录"/>
	</form>
</body>
</html>