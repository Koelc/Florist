<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav id="navbar-red" class = "navbar navbar-inverse navbar-static-top" role="navigation">

<div class="container">
	<ul class="nav navbar-nav">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
	data-target="#bs-example-navbar-1">
	
	<span class = "icon-bar"></span>
	<span class = "icon-bar"></span>
	<span class = "icon-bar"></span>
		</button>
</ul>
</div>
 <div class="collapse navbar-collapse" id="bs-example-navabr-1">
 <ul class="nav navbar-nav">
 <li><a href="<c:url value="/register"/>">Register</a></li>
 <li><a href="#"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
 <li><a href="#">Product Category</a></li>
 <li><a href="<c:url value="/"/>">Home</a></li>
 </ul>
 
 </div>


</nav>


</body>
</html>





