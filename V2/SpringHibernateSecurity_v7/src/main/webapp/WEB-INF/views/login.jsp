<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Sign In | Twitter</title>
<style>
.error {
	color: #ff0000;
}
</style>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/lightbox.css" rel="stylesheet">
<link href="resources/css/animate.min.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">

<!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="resources/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="resources/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="resources/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="resources/images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->

<body>
	<header id="header">

		<div class="navbar navbar-inverse" role="banner">
			<div class="container">
				<div class="navbar-header">


					<a class="navbar-brand" href="index.html">
						<h1>
							<a href="<c:url value='/welcome' />" ><img src="resources/images/logo.png" alt="logo"></a>
						</h1>
					</a>

				</div>


			</div>
		</div>
	</header>
	<!--/#header-->

	<section id="page-breadcrumb">
		<div class="vertical-center sun">
			<div class="container">
				<div class="row">
					<div class="action">
						<div class="col-sm-12">
							<h1 class="title">Welcome Back</h1>
							<p>Share Your Mind</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/#page-breadcrumb-->

	<section id="company-information" class="padding wow fadeIn"
		data-wow-duration="1000ms" data-wow-delay="300ms">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-12">
					<div class="contact-form bottom">


						 <form:form action="userCheck" method="post">
						 <h3><font color="red">${message}</font></h3>
							<div class="form-group">
							<input type="text" name="username" class="form-control"
									placeholder="Username">
							</div>
							<br />
							<div class="form-group">
							<input type="password" name="pwd" class="form-control"
									placeholder="Password"/>
							</div>
							<br />
							<div class="form-group">
                                <input type="submit" name="submit" class="btn btn-submit" value="Sign In">
                            </div>
						</form:form> 
						
						<%-- <form action="myPosts" method="post">

		<div class="lc-block">
			<div>
				<input type="text" class="style-4" name="username"
					placeholder="User Name" />
			</div>
			<div>
				<input type="password" class="style-4" name="password"
					placeholder="Password" />
			</div>
			<div>
				<input type="submit" value="Sign In" class="button red small" />
			</div>
			<c:if test="${param.error ne null}">
				<div class="alert-danger">Invalid username and password.</div>
			</c:if>
			<c:if test="${param.logout ne null}">
				<div class="alert-normal">You have been logged out.</div>
			</c:if>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form> --%>


					
					</div>
				</div>

			</div>
		</div>
	</section>




	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/lightbox.min.js"></script>
	<script type="text/javascript" src="resources/js/wow.min.js"></script>
	<script type="text/javascript" src="resources/js/main.js"></script>
</body>
</html>
