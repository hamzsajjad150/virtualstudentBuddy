<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>



<body>
<div class="topnav">
  <a href="ProductController">Home</a>
  <a href="">Edit</a>
  <a href="insert.jsp" class="active">Add Test</a>
</div>

<div class="container">
<form method="get" action="ProductController">
<input type="hidden" name="instruction" value="insertDDBB">


<label>Course Name</label>
<select name="courseName" >
<option>Enterprise Java Dev</option>
<option>Database Design</option>
<option>Computer Security</option>
<option>Computer Architecture</option>
<option>Systems Methodologies</option>
<option>General Elective</option>
<option>Coop</option>
</select>
<label>Test Name	</label><input type="text" name="testName"/>

<label>Due date	</label><input type="date" name="dueDate"/>
<label>Hour	</label>
<select name="hour">
<option>00</option>
<option>01</option>
<option>02</option>
<option>03</option>
<option>04</option>
<option>05</option>
<option>06</option>
<option>07</option>
<option>08</option>
<option>09</option>
<option>10</option>
<option>11</option>
<option>12</option>
</select>


<label>Minutes	</label>
<select name="minutes">
<option>00</option>
<option>30</option>
</select>


<label>Weight		</label><input type="text" name="testWeight"/>
<label>Grade		</label><input type="text" name="testGrade"/>

<input type="submit" value="Add" /> 

</form>
</div>


</body>
</html>