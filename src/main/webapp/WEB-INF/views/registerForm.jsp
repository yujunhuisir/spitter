<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spittr</title>

</head>
<body>
	<h1>Register</h1>
	<form action="" method="post">
		First Name: <input type="text" name="firstName"/><br/>
		Last Name:  <input type="text" name="lastName"/><br/>
		Username:  <input type="text" name="username"/><br/>
		Password:  <input type="password" name="password"/><br/>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>