<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/param/test10" method="post">
姓名：<input type="text" name="username" /><br>
电话：<input type="text" name="phone" /><br>
年龄：<input type="text" name="age" /><br>
邮件：<input type="text" name="email" /><br>
性别：<select>
<c:forEach items="${sex }" var="val">
<option>${val }</option>
</c:forEach>
</select><br>
<input type="submit" value="确定"/>
</form>
</body>
</html>