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
<style type="text/css">
#abc{
display:inline;
 margin-left:0px;
}
#excel{
position: absolute;
    right: 10px;
}
#pdf{
/*position: absolute;*/
   margin-left: 620px;
}

</style>

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

<%-- customized javaScript code to manage JTable --%>
<script src="${baseURL}/resources/scripts/employee.jtable.js"
	type="text/javascript"></script>

<!--Start Excel & PDF scripts  -->

<script src="${baseURL}/resources/js/tableExport.js"
	type="text/javascript"></script>

<script src="${baseURL}/resources/js/jquery.base64.js"
	type="text/javascript"></script>

<script src="${baseURL}/resources/js/jspdf/jspdf.js"
	type="text/javascript"></script>

<script src="${baseURL}/resources/js/jspdf/libs/sprintf.js"
	type="text/javascript"></script>

<script src="${baseURL}/resources/js/jspdf/libs/base64.js"
	type="text/javascript"></script>

<!--End Excel & Pdf scripts  -->

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

.jtable-column-header-sortable,table td,table th {
	padding: 0px 0px;
	padding-top: 9px;
	padding-bottom: 21px;
}

 .jtable-column-header-sortable{

    position:relative;
    right:20px;
} 
</style>


</head>
<body>
	<div>
		<ul class="breadcrumb">

			<li><a>Employee Details</a></li>
		</ul>
	</div>

	<div >
		<form id="abc">
			Search: <input type="text" name="" id="search" />
		</form>

		
		<form id="abc" action="${baseURL}/employee/exportexcel" method="post">
			<button id="excel" class="abc" type="submit">
				<img src="resources/img/icon_excel.png"> Download Excel
			</button>
		</form>
		<form id="abc" action="${baseURL}/employee/exportpdf" method="post">
			<button id="pdf" class="abc" type="submit">
				<img src="resources/img/icon_pdf.png"> Download PDF
			</button>
		</form>
	</div>
	<div>

		<!-- Dummy anchor link to simulate Download -->
		<a id="dlink" style="display: none;"></a>
		<!-- Dummy anchor Ends -->

		<div id="EmployeeTableContainer" style="width: 1100px;"></div>
		
	</div>
	<div id="SelectedRowList"></div>
	<script type="text/javascript">
		$(document).ready(function() {
	<%-- Starting  horizontal scrollbar for jtable--%>
		$('.jtable').wrap('<div class="jtable-main-container scroll-content" />');
		<%-- ending  horizontal scrollbar for jtable--%>
							$("#search").keyup(
									function() {
										var filter = $(this).val();
										$(".jtable tbody tr").each(
												function() {
													if ($(this).text().search(new RegExp(filter,"i")) < 0) {
														$(this).fadeOut();

													} else {
														$(this).show();
													}

												});

									});

							

						});
	</script>

</body>