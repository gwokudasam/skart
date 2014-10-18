<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252">
<title>SKart</title>


<%-- JQuery --%>
<script src="${baseURL}/resources/scripts/jquery-1.6.4.min.js"
	type="text/javascript"></script>
<script
	src="${baseURL}/resources/scripts/jquery-ui-1.8.16.custom.min.js"
	type="text/javascript"></script>

<%-- JTable --%>
<link
	href="${baseURL}/resources/scripts/jtable/themes/metro/blue/jtable.css"
	rel="stylesheet" type="text/css" />
<script src="${baseURL}/resources/scripts/jtable/jquery.jtable.js"
	type="text/javascript"></script>

<link href="${baseURL}/resources/css/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" type="text/css" />

<%-- customized javascript code to manage JTable --%>
<script src="${baseURL}/resources/scripts/studentJTable.js"
	type="text/javascript"></script>



<!-- Page CSS  -->
<style type="text/css">
.scroll-content {
	overflow-y: auto;
	width: 1100px;
}

select {
	color: black;
}

div.jtable-main-container {
	height: 100%;
}


 .jtable-column-header-sortable, table td, table th {
padding: 0px 0px; 
padding-top: 9px; 
padding-bottom: 21px; 
}  

/* .jtable-column-header-sortable{

    position:relative;
    right:20px;
} */

</style>


</head>
<body>
	<div>
		<ul class="breadcrumb">

			<li><a>Student Details</a></li>
		</ul>
	</div>

	<div class="filtering">
		<form>
			Name: <input type="text" name="" id="search" /> Class: <select
				id="className" name="">
				<option selected="selected" value="0">All class</option>
				<option value="1st class">1st class</option>
				<option value="2nd class">2nd class</option>
				<option value="3rd class">3rd class</option>
				<option value="4th class">4th class</option>
				<option value="5th class">5th class</option>
				<option value="6th class">6th class</option>
				<option value="7th class">7th class</option>
				<option value="8th class">8th class</option>
				<option value="9th class">9th class</option>
				<option value="10th class">10th class</option>
			</select>
			<button type="submit" id="LoadRecordsButton">Load records</button>
		</form>
	</div>


	<div>
		<div id="StudentTableContainer" style="width: 1100px;"></div>
	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
	<%-- adding horizontal scrollbar for jtable--%>
		$('.jtable')
									.wrap(
											'<div class="jtable-main-container scroll-content" />');

							$("#search").keyup(
									function() {
										var filter = $(this).val();
										$(".jtable tbody tr").each(
												function() {

													if ($(this).text().search(
															new RegExp(filter,
																	"i")) < 0) {
														$(this).fadeOut();

													} else {
														$(this).show();
													}

												});

									});
							$("#className").change(
									function() {
										alert($(this).val())
										$.get(
												"${baseURL}/student/getStudentByClassNmae/"
														+ $(this).val()).done(
												function(data) {
													alert(data);

												});
									});
						});
	</script>
</body>