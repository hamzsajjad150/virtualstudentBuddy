<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>




<body>
<div class="topnav">
  <a href="#home" class="active">Home</a>
  <a href="">Edit</a>
  <a href="insert.jsp">Add Test</a>
</div>


<div class="main" >
<table>
<tr>
	<th>Key</th>
	<th>Course Name</th>
	<th>Test Name</th>
	<th>Date</th>
	<th>Weight</th>
	<th>Grade</th>
	<th colspan="2">Action</th>
</tr>

<c:forEach var="temp" items ="${pro}">		

<c:url var="temp1" value="ProductController">
	
	<c:param name="instruction" value="edit"></c:param>
	<c:param name="testKey" value="${temp.testKey}"></c:param>

</c:url>	

<c:url var="temp2" value="ProductController">
	
	<c:param name="instruction" value="delete"></c:param>
	<c:param name="testKey" value="${temp.testKey}"></c:param>

</c:url>	
	

<tr>
	<td> ${temp.testKey} </td>
	<td> ${temp.courseName} </td>
	<td> ${temp.testName} </td>
	<td> ${temp.date} </td>
	<td> ${temp.testWeight} </td>
	<td >${temp.testGrade} </td>
	<td > <a href="${temp1}">EDIT</a></td>
	<td > <a href="${temp2}">DELETE</a></td>
	
</tr>

</c:forEach>
</table>

</div>
</body>
</html>