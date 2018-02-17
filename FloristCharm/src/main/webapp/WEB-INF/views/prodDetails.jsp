<%@ taglib prefix="j" uri="http://java.sun.com/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Detail</title>

</head>
<body>
            <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>



<script>$(document).ready(function(){
    //-- Click on detail
    $("ul.menu-items > li").on("click",function(){
        $("ul.menu-items > li").removeClass("active");
        $(this).addClass("active");
    })

    $(".attr,.attr2").on("click",function(){
        var clase = $(this).attr("class");

        $("." + clase).removeClass("active");
        $(this).addClass("active");
    })

    //-- Click on QUANTITY
    $(".btn-minus").on("click",function(){
        var now = $(".section > div > input").val();
        if ($.isNumeric(now)){
            if (parseInt(now) -1 > 0){ now--;}
            $(".section > div > input").val(now);
        }else{
            $(".section > div > input").val("1");
        }
    })            
    $(".btn-plus").on("click",function(){
        var now = $(".section > div > input").val();
        if ($.isNumeric(now)){
            $(".section > div > input").val(parseInt(now)+1);
        }else{
            $(".section > div > input").val("1");
        }
    })                        
}) </script>
<div class="container">
	<div class="row">
   <div class="col-xs-4 item-photo">
                    <img style="max-width:100%; margin-top: 30px;" src="${pageContext.request.contextPath}/resources/${product.imgname}" />
                </div>
                <div class="col-xs-5" style="border:0px solid gray">
                    <!-- Datos del vendedor y titulo del producto -->
                    <h3>${product.name}</h3>
                    <h4> ${product.description}</h4>    

             <h4>Price - ${product.price} Rs.</h4>
             <h5>Supplier - ${product.supplier.supplierName}</h5>
                   
    

                    <div class="section" style="padding-bottom:20px;">
                    
                     <form action="${pageContext.request.contextPath}/addToCart" method="post">
                                <input type="hidden" value="${product.id}" name="pId"/>
                                <input type="hidden" value="${product.price}" name="pPrice"/>
                                 <input type="hidden" value="${product.name}" name="name"/>
                                <input type="hidden" value="${product.imgname}" name="imgname"/>
                                
                                   <input type="number" class="form-control" name="quant"  required/><br>
                                <input class="btn btn-primary btn-lg" type="submit" value="Add to cart">
                            </form>
                      <h6><span class="glyphicon glyphicon-heart-empty" style="cursor:pointer;"></span> Wish List</h6>
                    </div>
             </div>                              

                <div class="col-xs-9">
                    <ul class="menu-items">
                        <li class="active">Details of product</li>
                        
                    </ul>
                    <hr><hr>
                    <p>All products are home made</p>
                </div>		
	</div>
</div>
<br>

            

</body>
</html>