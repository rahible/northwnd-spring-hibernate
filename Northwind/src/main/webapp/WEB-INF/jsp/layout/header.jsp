<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="categories" value="/categories" />
<c:url var="home" value="/index.jsp" />
<header>
	<h1><c:out value='${param.pageTitle}' /></h1>
	<nav>
		<ul>
			<li><a href="<c:out value='${home}' />">Home</a>
			</li>
			<li><a href="<c:out value='${categories}' />">Categories</a>
			</li>
		</ul>
	</nav>
</header>
