<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>


<body>
<div class="topnav">
  <a href="ProductController">Home</a>
  <a href="#contact">Edit</a>
  <a href="insert.jsp">Add Test</a>
</div>
<form method="get" action="ProductController">
<input type="hidden" name="instruction" value="updateDDBB">
<input type="hidden" name="testKey" value="${bla.testKey}">

<div class="container">
<h2>Item Number:  ${bla.testKey}</h2>
	
<label>Course Name</label>		<input type="text" name="courseName" value="${bla.courseName}"/>
<label>Test Name</label>		<input type="text" name="testName" value="${bla.testName}"/>
<label>Date</label>				<input type="text" name="date" value="${bla.date}"/>
<label>Test Weight</label>		<input type="text" name="testWeight" value="${bla.testWeight}"/>
<label>Test Grade</label>		<input type="text" name="testGrade" value="${bla.testGrade}"/>


<input type="submit" value="Send" /> 

</div>
</form>



</body>
</html>