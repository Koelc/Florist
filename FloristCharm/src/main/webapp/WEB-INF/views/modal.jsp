<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix ="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<br>

<div class="container">
<hr>
<div class="modal fade bs-example-modal-sm" tabindex="1" role="dialog" 
aria-labelledby="myModal" aria-hidden="true" id="onload">

<div class="modal-dialog modal-lg">
	<div class="modal-content">
	   <div class="modal-header">
	   <button type="button" class="close" data-dismiss="modal"> Close</button>
	   </div>
	
		<div class="modal-body">
		<span>Added Successfully!!!</span>
		
		<div class="modal-footer">
		
		<a href="${pageContext.request.contextPath }/admin/adding" 
		class="btn btn-warning" role="button">Back</a>
		</div>
			
		</div>
	</div>
</div>
</div>
</div>
<script type="text/javascript">
$(document).ready(function()
		{$('#onload').modal('show');});
</script>





</body>
</html>















