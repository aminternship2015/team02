<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Posts | Twitter</title>
<style>
.error {
	color: #ff0000;
}
</style>
<link href="resources/css/table.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/lightbox.css" rel="stylesheet">
<link href="resources/css/animate.min.css" rel="stylesheet">
<link href="resources/css/main.css" rel="stylesheet">
<link href="resources/css/responsive.css" rel="stylesheet">


<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="resources/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="resources/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="resources/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="resources/images/ico/apple-touch-icon-57-precomposed.png">


<script>
	function limitText(limitField, limitNum) {
		if (limitField.value.length > limitNum) {
			limitField.value = limitField.value.substring(0, limitNum);
		}
	}
</script>
</head>
<!--/head-->

<body>
	<header id="header">

		<div class="navbar navbar-inverse" role="banner">
			<div class="container">
				<div class="navbar-header">


					<a class="navbar-brand" href="welcome.jsp">
						<h1>
							<a href="<c:url value='/welcome' />"><img
								src="resources/images/logo.png" alt="logo"></a>
						</h1>
					</a>

				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<form action="logout" method="post">
								<input type="submit" class="btn btn-default" value="Sign Out" />
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</li>

					</ul>
				</div>


			</div>
		</div>
	</header>
	<!--/#header-->

	<section id="action" class="responsive">
		<div class="vertical-center">
			<div class="container">
				<div class="row">
					<div class="action take-tour">
						<div class="col-sm-7 wow fadeInLeft" data-wow-duration="500ms"
							data-wow-delay="300ms">
							<h1 class="title">
								<b>${username}'s Page</b>
							</h1>
							<p>Share Your Thoughts</p>
						</div>
						<div class="col-sm-5 text-center wow fadeInRight"
							data-wow-duration="500ms" data-wow-delay="300ms">
							<div class="tour-button"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>






	<section id="blog" class="padding-top">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-5">
					<div class="sidebar blog-sidebar">
						<div class="sidebar-item  recent">
							
							<c:choose>
  <c:when test="${empty avatar}">
    <img width="262" height="287" src="resources/images/user.png"
								class="img-responsive"> 
  </c:when>
	<c:otherwise>						
							<img width="262" height="287" src="${avatar}"
								class="img-responsive"> 
						
    
  </c:otherwise>
</c:choose>

						</div>
						<div class="sidebar-item categories">

							<ul class="nav navbar-stacked">
								<li><a href="showMyPosts">Tweets<span
										class="pull-right">(1)</span></a></li>
								<li><a href="#">Following<span class="pull-right">(8)</span></a></li>
								<li><a href="#">Followers<span class="pull-right">(4)</span></a></li>

							</ul>
						</div>


					</div>
				</div>
				<div class="col-md-9 col-sm-7">
					<div class="row">
						<form:form action="savePost" method="post">
							<%-- <h3>
								<font color="red">${warning}</font>
							</h3> --%>
							<div class="form-group">
								<textarea path="postText" id="postText" width="100%"
									name="message" id="message" required="required"
									class="form-control" rows="2" placeholder="What's happening?"
									onKeyDown="limitText(this,140);" onKeyUp="limitText(this,140);"></textarea>
							</div>
							<%-- <form:errors path="warning" cssClass="error" element="div" /> --%>
							<div class="form-group">
								<input type="submit" name="submit" class="btn btn-submit"
									value="Tweet" id="submitButtonTweet">
							</div>
						</form:form>

						<div class="form-group"></div>
						<div class="row">
							<c:forEach items="${posts}" var="post" varStatus="status">
								<div class="col-md-12 col-sm-12">
									<div class="single-blog two-column">
										<div class="post-thumb">

											<div class="post-overlay">
												<span class="uppercase"><a href="#">14 <br>
														<small>Feb</small></a></span>
											</div>
										</div>
										<div class="post-content overflow">

											<h3 class="post-author">
												<a href="#">Posted by ${post.username}</a>
											</h3>
											<p>
												<c:out value="${post.postText}"></c:out>
											</p>
											<a href="#" class="read-more"><c:out
													value="${post.createdAt }"></c:out></a>
											<div class="post-bottom overflow">
												<ul class="nav navbar-nav post-nav">
													<li><a href="#"><i class="fa fa-tag"></i>Creative</a></li>
													<li><a href="#"><i class="fa fa-heart"></i>32 Love</a></li>
													<li><a href="#"><i class="fa fa-comments"></i>3
															Comments</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>

						<%-- <c:set var="count" value="${sizePages}"/> --%>

						<div class="blog-pagination">
							<ul class="pagination">
								<c:forEach var="i" begin="0" end="${ total }">
									<li><a href="?page=${i}"><c:out value="${i}" /></a></li>
									<%-- <li><a href="?page=${i+1}">${i}</a></li> --%>
								</c:forEach>
							</ul>
						</div>

					</div>
				</div>
			</div>
	</section>
	<!--/#blog-->
	<img src="resources/images/footer2.png" width="100%">


	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/lightbox.min.js"></script>
	<script type="text/javascript" src="resources/js/wow.min.js"></script>
	<script type="text/javascript" src="resources/js/main.js"></script>
</body>
</html>
