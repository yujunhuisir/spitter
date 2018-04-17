<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spittle</title>
<link rel="stylesheet"
		type="text/css"
		href="<c:out value="/resources/style.css"/>">
</head>
<body>
	<div class="spittleView">
		<div class="spittleMessage">
			<c:out value="${spittle.message }" />
		</div>
		<div>
			<span class="spittleTime"><c:out value="${spittle.time }"/></span>
		</div>
	</div>
</body>
</html>