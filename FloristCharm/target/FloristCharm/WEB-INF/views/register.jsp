<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form:form modelAttribute="user" action="/saveuser" method="post" >
<label>Email:</label>
<form:input path="email" /> <br>

<label>Name:</label>
<form:input path="name" /> <br>
<label>Address:</label>
<form:input path="address" /> <br>
<label>Phone:</label>
<form:input path="phone" /> <br>
<label>Password:</label>
<form:input path="password" /> <br>

<button type="submit" class="btn btn -lg btn-info">Submit</button>
<button type="reset" class="btn btn -lg btn-info">Cancel</button>
</form:form>
</body>
</html>







