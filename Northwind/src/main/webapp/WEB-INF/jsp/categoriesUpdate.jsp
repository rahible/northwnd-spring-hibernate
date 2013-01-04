<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>Update category</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
	<jsp:include page="layout/header.jsp">
		<jsp:param value="Category Update" name="pageTitle"/>
		</jsp:include>
    <form name="category" method="post" action="<c:out value='${category.id}' />" enctype="multipart/form-data">
		<div id="image">Current Image:<img alt="<c:out value="${category.name}" />" src='images/<c:out value="${category.id}" />/image.gif'/></div>
		<div id="name">Name:<input type="text" name="name" value="<c:out value='${category.name}' />" required="required" /></div>
		<div id="description">Description:<input type="text" name="description" value="<c:out value='${category.description}' />" required="required" /></div>
    	<div id="name">Browse to New Image File:&nbsp;<input type="file" name="picture" /></div> 
    	<input id="submit" type="submit" />
    </form>
    <jsp:include page="layout/footer.jsp" />
  </body>
</html>
