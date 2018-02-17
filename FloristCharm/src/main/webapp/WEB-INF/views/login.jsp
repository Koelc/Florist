<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<h1>Welcome to Login page!!!</h1>
<form action="${pageContext.request.contextPath }/login" class="form-signin" method="post">
<h3>Email:</h3><input type="text" name="username" class="login-box" required>
<h3>password:</h3><input type="password" name="password" class="login-box" required>

<button class="btn btn-lg btn-primary" type="submit">Login</button>
<button class="btn btn-lg btn-primary" type="reset">Reset</button>
</form>
</div>
</body>
</html>