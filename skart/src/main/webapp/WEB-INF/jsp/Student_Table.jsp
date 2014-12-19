<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<c:set var="classParam" value="1st Class" />
<c:set var="sectionParam" value="A" />

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
   margin-left: 340px;
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
<script src="${baseURL}/resources/scripts/student.jtable.js"
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

<!-- Modal Box -->
<script src="${baseURL}/resources/scripts/simple-modal.js"
    type="text/javascript"></script>
<!-- Modal Box ends here -->

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

			<li><a>Student Details</a></li>
		</ul>
	</div>

	<div >
		<form id="abc">
			Search: <input type="text" name="" id="search" /> 
			
			Class: <select  id="getSection" name="className" >
				<option value="1st class">1st class</option>
				<option value="2nd class">2nd class</option>
				<option value="3rd class">3rd class</option>
				<option value="4th class">4rd class</option>
				<option value="5th class">5th class</option>
				<option value="6th class">6th class</option>
				<option value="7th class">7th class</option>
				<option value="8th class">8th class</option>
				<option value="9th class">9th class</option>
				<option value="10th class">10th class</option>
				<option value="0">All Classes</option>
			</select> 
			section:<select id="recieveSection" name="section">
				<option value="">Selected</option>
			</select>
		</form>

		<script type="text/javascript">
			$(document).ready(function(){
				$("#getSection").change(function(){
					classParam=$("#getSection").val();
					if(classParam ==0)
						 $('#StudentTableContainer').jtable('load',{});
					else{
					$.get("${baseURL}/student/getStudentByClassName/"+ $(this).val()).done(function(data) {
						$("#recieveSection option").remove();
						$("#recieveSection").append("<option value=''>Selected</option>");
						$.each(data,function(index,val){
								$("#recieveSection").append("<option value="+val+">"+val+"</option>");
						});
				
					});
				}
				});
				
			});
			$(document).ready(function(){
				$("#recieveSection").change(function(){					
					 $('#StudentTableContainer').jtable('load',{class:$("#getSection").val(),section:$("#recieveSection").val()});
														
				});	 
				
			});
		
			</script>
		<form id="abc" action="${baseURL}/student/exportexcel" method="post">
			<button id="excel" class="abc" type="submit">
				<img src="resources/img/icon_excel.png"> Download Excel
			</button>
		</form>
		<form id="abc" action="${baseURL}/student/exportpdf" method="post">
			<button id="pdf" class="abc" type="submit">
				<img src="resources/img/icon_pdf.png"> Download PDF
			</button>
		</form>
	</div>
	<div>

		<!-- Dummy anchor link to simulate Download -->
		<a id="dlink" style="display: none;"></a>
		<!-- Dummy anchor Ends -->

		<div id="StudentTableContainer" style="width: 1100px;"></div>
		
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