<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set value="${pageContext.request.contextPath}" var="conPath"></c:set>
<meta charset="utf-8">
    <title>SKart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="SKart admin home page">
    <meta name="author" content="spinhighq">

    <!-- The styles -->
    <link id="bs-css" href="${conPath}/resources/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="${conPath}/resources/css/charisma-app.css" rel="stylesheet">
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

</head>
<body>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
 <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" >  <img class="hidden-xs"/>
                <span>SKart</span>
				</a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> admin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="${logoutUrl}">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> Change Theme / Skin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->
              
                    <form class="navbar-search pull-left">
                        <input placeholder="Search" class="search-query form-control col-md-10" name="query"
                               type="text">
                    </form>
             
            

        </div>
    </div>
    <!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li><a class="ajax-link" href="skart-index.html"><i class="glyphicon glyphicon-home"></i><span> Dashboard</span></a>
                        </li>
                        
                        <li><a class="ajax-link" href="student-table.html"><i
                                    class="glyphicon glyphicon-user"></i><span> Student Details </span></a></li>
						<li><a class="ajax-link" href="employee-table.html"><i
                                    class="glyphicon glyphicon-align-justify"></i><span> Employee Details </span></a></li>
						 <li><a class="ajax-link" href="parent-table.html"><i
                                    class="glyphicon glyphicon-th-large"></i><span> Parents Details </span></a></li>
						  <li><a class="ajax-link" href="#"><i
                                    class="glyphicon glyphicon-check"></i><span> Students Attendance </span></a></li>
						  <li><a class="ajax-link" href="#"><i
                                    class="glyphicon glyphicon-ok-sign"></i><span> Employee Attendance </span></a></li>
						   <li><a class="ajax-link" href="#"><i
                                    class="glyphicon glyphicon-time"></i><span> Class Timetable </span></a></li>
						    <li><a class="ajax-link" href="#"><i
                                    class="glyphicon glyphicon-list-alt"></i><span> Exam Schedule </span></a></li>
							 <li><a class="ajax-link" href="#"><i
                                    class="glyphicon glyphicon-bullhorn"></i><span> News </span></a></li>
							 <li><a class="ajax-link" href="#"><i
                                    class="glyphicon glyphicon-cog"></i><span> Settings </span></a></li>
							 <li><a class="ajax-link" href="calendar.html"><i class="glyphicon glyphicon-calendar"></i><span> Calendar</span></a>
                        </li>
							 <li><a class="ajax-link" href="login.html"><i
                                    class="glyphicon glyphicon-off"></i><span> Logout </span></a></li>
						 
                        
                        
                        
                    </ul>
                   
                </div>
            </div>
        </div>
     </div>
     </div>
     </body>
     </html>