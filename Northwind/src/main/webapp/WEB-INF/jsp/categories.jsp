<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>All Categories</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
	<body>
		<div id="header">All Categories</div>
		<c:forEach items="${categories}" var="category" >
			<div id="item">
				<span id="name"><c:out value="${category.categoryName}" /></span>
				<span id="description"><c:out value="${category.description}" /></span>
				<span id="image"><img alt="<c:out value="${category.categoryName}" />" src='categories/<c:out value="${category.categoryId}" />/image.gif'/></span>
			</div>
		</c:forEach>
	</body>
</html>
