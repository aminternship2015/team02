<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Sign Up | Twitter</title>
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


					<a class="navbar-brand" href="index.html"> <a
						href="<c:url value='/welcome' />"> <img
							src="resources/images/logo.png" alt="logo"></a>
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
							<h1 class="title">Join Twitter Today</h1>
							<p>Create an account</p>
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
						<form:form method="POST" modelAttribute="user" id="formUser">
							<form:input type="hidden" path="userId" id="userId" />
							<form:input type="hidden" path="createdAt" id="createdAt" />


							<div class="form-group">


								<form:input path="name" id="name" class="form-control"
									placeholder="Name" />
								<p>
									<form:errors path="name" cssClass="error" />
								</p>

							</div>




							<div class="form-group">

								<form:input path="username" id="username" class="form-control"
									placeholder="Username" />
								<p>
									<form:errors path="username" cssClass="error" />
								</p>

							</div>

							<div class="form-group">
								<form:input type="password" path="password" id="password"
									class="form-control" placeholder="Password" />
								<form:errors path="password" cssClass="error" />
							</div>

							<div class="form-group">

								<form:input path="email" id="email" class="form-control"
									placeholder="Email" />
								<form:errors path="email" cssClass="error" />
							</div>


							<div class="form-group">


								<form:input path="avatar" id="avatar" type="file" class="form-control"
									placeholder="Avatar" />
								<p>
									<form:errors path="avatar" cssClass="error" />
								</p>

							</div>

							<div class="form-group">


								<form:input path="admin" id="admin" class="form-control"
									placeholder="Admin" type="hidden" />
								<%--  <p>
									<form:errors path="admin" cssClass="error" />
								</p>  --%>

							</div>




							<c:choose>
								<c:when test="${edit}">
									<div class="form-group">
										<input type="submit" name="submit" id ="submit" class="btn btn-submit"
											value="Update">
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group">
										<input type="submit" name="submit"  id ="register" class="btn btn-submit"
											value="Register">
									</div>
								</c:otherwise>
							</c:choose>

						</form:form>
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
