<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>All Categories</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="css/starting.css">
</head>
	<body>
		<jsp:include page="layout/header.jsp">
			<jsp:param value="All Categories" name="pageTitle"/>
		</jsp:include>
		<c:forEach items="${categories}" var="category" >
			<div id="item">
				<a href='categories/<c:out value="${category.id}" />' rel="next">
					<span id="image"><img alt="<c:out value="${category.name}" />" src='categories/images/<c:out value="${category.id}" />/image.gif'/></span>
					<span id="name"><c:out value="${category.name}" /></span>
					<span id="description"><c:out value="${category.description}" /></span>
				</a>
			</div>
		</c:forEach>
    	<jsp:include page="layout/footer.jsp" />
	</body>
</html>
