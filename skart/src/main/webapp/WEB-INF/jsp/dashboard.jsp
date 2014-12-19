<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="conPath"></c:set>

<div>
	<ul class="breadcrumb">

		<li><a>Dashboard</a></li>
	</ul>
</div>

<div class=" row">
	<div class="col-md-2 col-sm-3 col-xs-6"
		style="position: relative; left: 100px;">
		<a href="#" data-toggle="tooltip" title="Student Details"
			id="Student_Table1" name="Student_Table"
			onClick="ajaxCallback(this);"> <img
			src="${conPath}/resources/img/student-details.jpg"/> 
			
				<strong>Student Details</strong>
			
		</a>
	</div>

	<div class="col-md-2 col-sm-3 col-xs-6"
		style="position: relative; left: 100px;">
		<a data-toggle="tooltip" title="Employee Details" href="#"
		id="Employee_Table1" name="Employee_Table" onClick="ajaxCallback(this);"> <img
			src="${conPath}/resources/img/employee.png"/> 
			
				<strong>Employee Details</strong>
			

		</a>
	</div>

	<div class="col-md-2 col-sm-3 col-xs-6"
		style="position: relative; left: 100px;">
		<a data-toggle="tooltip" title="Parent Details" href="#" 
		id="Parent_Table1" name="Parent_Table" onClick="ajaxCallback(this);"> 
		<img src="${conPath}/resources/img/parents.png"/> 
				<strong> Parent Details</strong>
			

		</a>
	</div>
</div>
<br>
<br>
<div class=" row">
	<div class="col-md-2 col-sm-3 col-xs-6"
		style="position: relative; left: 100px;">
		<a data-toggle="tooltip" title="Students Attendance" href="#"> <img
			src="${conPath}/resources/img/attendance.jpg"/> 
				<strong>Students Attendance</strong>
		

		</a>
	</div>

	<div class="col-md-2 col-sm-3 col-xs-6"
		style="position: relative; left: 100px;">
		<a data-toggle="tooltip" title="Employee Attendance" href="#"> <img
			src="${conPath}/resources/img/teacher_attendance.png"/> 
			
				<strong>Employee Attendance</strong>
			
		</a>
	</div>

	<div class="col-md-2 col-sm-3 col-xs-6"
		style="position: relative; left: 100px;">
		<a data-toggle="tooltip" title="Class Timetable" href="#"> <img
			src="${conPath}/resources/img/timetable.png"/> 
			<div>
				<strong>Class Timetable</strong>
			</div>

		</a>
	</div>

</div>
<br>
<br>
<div class=" row">
	<div class="col-md-2 col-sm-3 col-xs-6"
		style="position: relative; left: 100px;">
		<a data-toggle="tooltip" title="Exams Schedule" href="#"> <img
			src="${conPath}/resources/img/examshedule.png"/> 
			<div>
				<strong>Exams Schedule</strong>
			</div>

		</a>
	</div>

	<div class="col-md-2 col-sm-3 col-xs-6"
		style="position: relative; left: 100px;">
		<a data-toggle="tooltip" title="News" href="#"> <img
			src="${conPath}/resources/img/news.jpg"/>
			<div>
				<strong>News</strong>
			</div>
		</a>
	</div>

	<div class="col-md-2 col-sm-3 col-xs-6"
		style="position: relative; left: 100px;">
		<a data-toggle="tooltip" title="Settings" href="#"> <img
			src="${conPath}/resources/img/setting.jpg"/> 
			
				<strong>Settings</strong>
			

		</a>
		
	</div>

</div>
