<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav id ="navbar-red" class="navbar navbar-inverse navbar-static-top" role="navigation">
    <div class="container">
        <ul class="nav navbar-nav">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"/>
               
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
       </ul>
       </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                   
           <ul class="nav navbar-nav">
                <li><a href="index">Home</a></li>
        
                <li><a href="contactus"><i class="fa fa-address-book" aria-hidden="true"></i></a></li>
                <%-- <li><a href="${pageContext.request.contextPath}/goTologin">Login</a></li>
                <li><a href="${pageContext.request.contextPath}/register">Register</a></li>
                --%> <li><a href="${pageContext.request.contextPath}/admin/adding">Admin</a></li>
               <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin list<span class="caret"></span></a>
       <ul class="dropdown-menu">
     
     <li><a href="${pageContext.request.contextPath}/admin/suppList">Supplier</a> </li>         
     <li><a href="${pageContext.request.contextPath}/admin/productList">Product</a> </li>
     <li><a href="${pageContext.request.contextPath}/admin/catList">Category</a> </li>
          
           </ul><li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category<span class="caret"></span></a>
       <ul class="dropdown-menu">
     <c:forEach var="catVal" items="${catList }">
     <li><a href="${pageContext.request.contextPath}/productCustList?cid=${catVal.cid }">${catVal.name }</a> </li>         
           </c:forEach>
           </ul>
   
   <ul class="nav navbar-nav navbar right">
   <c:if test="${pageContext.request.userPrincipal.name==null}">
   <li><a href="${pageContext.request.contextPath}/register">Register</a></li>  
   <li><a href="${pageContext.request.contextPath}/goTologin">Login</a></li>
   </c:if>
    <c:if test="${pageContext.request.userPrincipal.name!=null}" >
    <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
    <li><a href="<c:url value="/logout"/>">Logout</a></li>
    <li><a href="${pageContext.request.contextPath}/goToCart">My Cart <i class="fa fa-cart-plus" aria-hidden="true"></i></a></li>
    
    </c:if>  
            </ul>
       </li>
             </div>
        </div>
    
</nav>


</body>
</html>





