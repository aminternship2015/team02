<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Welcome | Twitter</title>
  <link href="<c:url value="resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="resources/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="resources/css/animate.min.css" />" rel="stylesheet"> 
    <link href="<c:url value="resources/css/lightbox.css" />" rel="stylesheet"> 
	<link href="<c:url value="resources/css/main.css" />" rel="stylesheet">
	<link href="<c:url value="resources/css/responsive.css" />" rel="stylesheet">


  	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/lightbox.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/wow.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
  <!-- <script type="text/javascript" src="resources/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="resources/js/wow.min.js"></script>
    <script type="text/javascript" src="resources/js/main.js"></script>    -->
    
   

    <!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="resources/images/ico/favicon.ico">
    
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="resources/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->
<body bgcolor="">
	<header id="header">      
      
        <div class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                  

                    <a class="navbar-brand" href="index.html">
                    	<h1><a href="<c:url value='/welcome' />" ><img src="resources/images/logo.png" alt="logo"></a></h1>
                    </a>
                    
                </div>
               
               
            </div>
        </div>
    </header>
    <!--/#header-->

    <section id="home-slider">
        <div class="container">
            <div class="row">
                <div class="main-slider">
                    <div class="slide-text">
                        <h1>Share your thoughts</h1>
                        <p><h3>Writing means sharing. It's part of the human condition to want to share things - thoughts, ideas, opinions.</h3></p>
                        <a href="<c:url value='/new' />" class="btn btn-common">SIGN UP</a>
                       <a href="<c:url value='/login' />" class="btn btn-common">SIGN IN</a>
                      
            
                    </div>
                    <img src="resources/images/home/slider/hill.png" class="slider-hill" alt="slider image">
                     <img src="<c:url value='resources/images/home/slider/house.png'/>" class="slider-house" alt="slider image"/>
                   <!--  <img src="resources/images/home/slider/house.png" class="slider-house" alt="slider image"> -->
                    <img src="resources/images/home/slider/sun.png" class="slider-sun" alt="slider image">
                    <img src="resources/images/home/slider/birds1.png" class="slider-birds1" alt="slider image">
                    <img src="resources/images/home/slider/birds2.png" class="slider-birds2" alt="slider image">
                </div>
            </div>
        </div>
        <div class="preloader"><i class="fa fa-sun-o fa-spin"></i></div>
    </section>
    <!--/#home-slider-->

	
	 <div class="col-sm-12 text-center bottom-separator">
                    <img src="resources/images/home/under.png" class="img-responsive inline" alt="">
                </div>
   <!-- <img src="resources/images/404-bg.png" width="100%" height="40%"> -->

   
    <!--/#footer-->

 

<%-- <script src="<c:url value="resources/js/jquery.js" />"></script>

<script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="resources/js/lightbox.min.js" />"></script>
<script src="<c:url value="resources/js/wow.min.js" />"></script>
<script src="<c:url value="resources/js/main.js" />"></script>  --%>


    
</body>
</html>