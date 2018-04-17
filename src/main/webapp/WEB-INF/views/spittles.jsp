<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>spittles</title>
<link rel="stylesheet"
		type="text/css"
		href="<c:out value="/resources/style.css"/>">
</head>
<body>
	<div class="spittleForm">
	<h1>Spittle it out...</h1>
	<form method="POST"  name="spittleForm" >
		<input type="hidden" name="latitude">
		<input type="hidden" name="longitude">
		<textarea name="message" rows="5" cols="80"></textarea><br/>
		<input type="submit" value="Add1">
	</form>
	</div>
	<div>
	<h1>Recent Spittles</h1>
	<ul class="spittleList">
	<c:forEach items="${spittleList}" var="spittle" >
		<li id="spittle_<c:out value="spittle.id"/>">
			<div class="spittleMessage">
				<c:out value="${spittle.message }"/>
			</div>
			<div>
				<span class="spittleTime"><c:out value="${spittle.time }"/></span>
				<span class="spittleLocation">
				(<c:out value="${spittle.latitude }"/>,
				<c:out value="${spittle.longitude }"/>)
				</span>
			</div>
		</li>
	</c:forEach>
	</ul>
	<c:if test="${fn:length(spittleList) gt 20}"><hr />
        <s:url value="/spittles?count=${nextCount}" var="more_url" />
        <a href="${more_url}">Show more</a>
      </c:if>
      </div>
</body>
</html>