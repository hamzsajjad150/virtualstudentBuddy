<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>




<body>
<div class="topnav">
  <a href="/Product_Web/ProductController?instruction=listar">Book</a>
  <a href="" class="active">Grid</a>
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

<table>
<tr>
	<th>Date</th>
	<th>Java</th>
	<th>Database</th>
	<th>Computer Security</th>
	<th>Computer Architecture</th>
	<th>System Methodologies</th>
	<th>General Elective</th>
</tr>

<c:forEach var="temp" items ="${grid}">		
<tr>	


	<td>${temp.dueDate} </td>
	<td> ${temp.columnDate} </td>
	<td> ${temp.test1} </td>
	<td> ${temp.test2} </td>
	<td> ${temp.test3} </td>
	<td >${temp.test4} </td>

</tr>
 
</c:forEach>


</table>

</div>
</body>
</html>