<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.apache.taglibs.standard.lang.jstl.test.PageContextImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


  <%-- <%!
 String conPath=this.getServletContext().getContextPath();
 %>
 
<c:set value="${conPath}" var="contextPath"/>  --%>
<html>
<head>
 <c:set value="${pageContext.request.contextPath}" var="conPath"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SKart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="SKart admin home page">
    <meta name="author" content="spinhighq">

    <!-- The styles -->
    <link href='${conPath}/resources/css/bootstrap-cerulean.min.css' rel="stylesheet">
    <link href='${conPath}/resources/css/charisma-app.css' rel="stylesheet">
    <link href='${conPath}/resources/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='${conPath}/resources/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='${conPath}/resources/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='${conPath}/resources/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='${conPath}/resources/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='${conPath}/resources/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='${conPath}/resources/css/jquery.noty.css' rel='stylesheet'>
    <link href='${conPath}/resources/css/noty_theme_default.css' rel='stylesheet'>
    <link href='${conPath}/resources/css/elfinder.min.css' rel='stylesheet'>
    <link href='${conPath}/resources/css/elfinder.theme.css' rel='stylesheet'>
    <link href='${conPath}/resources/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='${conPath}/resources/css/uploadify.css' rel='stylesheet'>
    <link href='${conPath}/resources/css/animate.min.css' rel='stylesheet'>

    <!-- jQuery -->
    <script src="${conPath}/resources/bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="${conPath}/resources/img/spinhighq-fav.jpg">
<style>
.LogoHead{
            	position: absolute;
            	top: 20px;
            	left:37%
				
            }
 </style>
</head>
<body>
<div class="ch-container">

<!-- Header -->

        <div>
        
        	<img class="LogoHead"
        	src="${conPath}/resources/img/Skart_logo3.png" height="100px;" width="320px;">
        </div>
		

    <div class="row">
        <div class="col-md-12 center login-header" style="position: relative; top: 50px;">
		    <br>
			<br>
            <h2>Welcome to SKart</h2>
				<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
					<font color="red"> 
					 <c:out value="${message}" />.
					</font>
				</c:if>
				<c:if test="${empty SPRING_SECURITY_LAST_EXCEPTION}">
					<font color="blue"> 
					 <c:out value="${message}" />.
					</font>
				</c:if>
			</div>
        <!--/span-->
    </div><!--/row-->
	 <br/><br/>
    <div class="row">
            <div class="well col-md-5 center login-box" style="position: relative; top: 70px;">
            <div class="alert alert-info">
                Please login with your Username and Password.
            </div>
             <form class="form-horizontal" action="<c:url value='/j_spring_security_check'/>" method="post">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" class="form-control" placeholder="Username" name="j_username">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" class="form-control" placeholder="Password" name="j_password">
                    </div>
                    

                    <p class="center col-md-5">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </p>
                </fieldset>
            </form>
        </div>
        <!--/span-->
    </div><!--/row-->
</div><!--/fluid-row-->

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="${conPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="${conPath}/resources/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='${conPath}/resources/bower_components/moment/min/moment.min.js'></script>
<script src='${conPath}/resources/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='${conPath}/resources/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="${conPath}/resources/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="${conPath}/resources/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="${conPath}/resources/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="${conPath}/resources/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="${conPath}/resources/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="${conPath}/resources/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="${conPath}/resources/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="${conPath}/resources/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="${conPath}/resources/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="${conPath}/resources/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="${conPath}/resources/js/charisma.js"></script>


</body>
</html>