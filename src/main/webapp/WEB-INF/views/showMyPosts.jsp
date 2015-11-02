<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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

						<%-- <li class="dropdown"><a href="#"><h3>HI, ${username}</h3>
						</a>
							<ul role="menu" class="sub-menu">
								<li><a href="aboutus.html">My Tweets</a></li>
								<li><a href="aboutus2.html">Followed persons</a></li>


							</ul></li>
 --%>

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
								<b>${username}'s Posts</b>
							</h1>
							<p>Edit Your Thoughts</p>
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





 <section id="blog" class="padding-bottom">
        <div class="container">
            <div class="row">
                <div class="timeline-blog overflow padding-top">
                    <div class="timeline-date text-center">
                        <a href="#" class="btn btn-common uppercase">Timeline</a>
                    </div>
                    
                    <div class="timeline-divider overflow padding-bottom">
                  <%--   <c:forEach items="${posts}" var="post" varStatus="status" step> --%>
                    <c:forEach var="i" begin="0" end="${ postLen-1 }" step="2">
                        
                        <c:if test="${i < postLen }">
                        <div class="col-sm-6 padding-right arrow-right wow fadeInLeft" data-wow-duration="1000ms" data-wow-delay="300ms">
                            <div class="single-blog timeline">
                              
                                <div class="post-content overflow">
                                    <h2 class="post-title bold">${posts[i].postText} </h2>
                                    
                                    
                                    <div class="post-bottom overflow">
                                        <span class="post-date pull-left">${posts[i+1].createdAt}</span>
                                        <span class="comments-number pull-right"><a href="editPost?idPost=${posts[i].postId}&username=${username}">Edit &nbsp; </a></span>
                                        <span class="comments-number pull-right"><a href="deletePost?idPost=${posts[i].postId}">Delete &nbsp; </a></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        
                       
                        
                        <div class="col-sm-6 padding-left padding-top arrow-left wow fadeInRight" data-wow-duration="1000ms" data-wow-delay="300ms">
                            <div class="single-blog timeline">
                            
                                <div class="post-content overflow">
										
											<h2 class="post-title bold">${posts[i+1].postText}</h2>
											 
                                    
                                    <div class="post-bottom overflow">
                                        <span class="post-date pull-left">${posts[i+1].createdAt}</span>
                                        <span class="comments-number pull-right"><a href="editPost?idPost=${posts[i+1].postId}&username=${username}">Edit &nbsp;</a></span>
                                        <span class="comments-number pull-right"><a href="deletePost?idPost=${posts[i+1].postId}">Delete &nbsp;</a></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:if>
                        
                        
                        </c:forEach>
                       
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
