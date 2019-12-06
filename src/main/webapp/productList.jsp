<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>




<body>
<div class="topnav">
  <a href="" class="active">Book</a>
  <a href="/Product_Web/ProductController?instruction=grid">Grid</a>
  <a href="">Edit</a>
  <a href="insert.jsp">Add Test</a>
</div>


<!-- The sidebar -->
<div class="sidebar">
  <a class="active" href="#home">${course}</a>
  <a href="#news">News</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>



<div class="main" >

<c:forEach var="temp" items ="${pro}">		

<div class="container">

<c:url var="temp1" value="ProductController">
	
	<c:param name="instruction" value="edit"></c:param>
	<c:param name="testKey" value="${temp.testKey}"></c:param>

</c:url>	

<c:url var="temp2" value="ProductController">
	
	<c:param name="instruction" value="delete"></c:param>
	<c:param name="testKey" value="${temp.testKey}"></c:param>

</c:url>	


<div ><img src="icon.jpg" alt=""> <div class="title">${temp.courseName}<br>
${temp.testName} </div></div>
<div class="testKey">${temp.testKey}</div>
<div>${temp.date} </div>
<div>Weight:${temp.testWeight} </div>
<div>Grade :${temp.testGrade} </div>
${temp.testKey}

<div class="actions">
<a href="${temp1}">Edit</a>
<a href="${temp2}">Delete</a>

</div>
</div>	


</c:forEach>


</div>
</body>
</html>