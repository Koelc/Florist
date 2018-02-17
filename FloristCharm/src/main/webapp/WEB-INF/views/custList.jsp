<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script src="jquery/jquery-3.2.1.js"></script> -->
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">

<h1><label>Product List for Customers</label></h1>

<table class="table table-hover" id="category" class="display" border="2" width="80" align="Center">
<tr>
<th>Sr No.</th>
<th>PID</th>
<th>Name</th>
<th>Supplier</th>
<th>Category</th>
<th>Price</th>
<th>Description</th>
<th>Image</th>
<th>Details</th>
</tr>

<c:if test="${empty userList}">
<tr><td colspan="9" align="center">No Record Exists!!</td> </tr>
</c:if>

<c:forEach  var="u" varStatus="st" items="${prodList }">
<tr>
<td><c:out value="${st.count}"></c:out></td>
<td><c:out value="${c.id}"></c:out></td>
<td><c:out value="${c.name}"></c:out></td>
<td><c:out value="${c.supplier.supplierName}"></c:out></td>
<td><c:out value="${c.category.name}"></c:out></td>
<td><c:out value="${c.price}"></c:out></td>
<td class="span2"><c:out value="${c.description}"></c:out></td>
<td><img src="${pageContext.request.contextPath}/resources/${c.imgname}" height="50px" width="50px"></td>
<td class="span4">
 <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
 <a class="btn btn-info" role="button" href="<c:url value="/prodDetails/${c.id}"/>">Details</a>
   </td>
</tr>
</c:forEach>
</table>

</div>



</body>
</html>


