<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>Update Categories</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    Update Categories
    <form name="category" method="post" action="update" enctype="multipart/form-data">
    	<input id="categoryId" name="categoryId" type="hidden" value="<c:out value='${categories.categoryId}' />"/>
    	<div>File:&nbsp;<input type="file" name="picture" /></div> 
    	<input id="submit" type="submit" />
    </form>
  </body>
</html>
