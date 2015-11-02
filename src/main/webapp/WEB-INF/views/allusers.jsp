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
    <title>List Users | Twitter</title>
    <style>
.error {
	color: #ff0000;
}
</style>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/table.css" rel="stylesheet">
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/lightbox.css" rel="stylesheet"> 
    <link href="resources/css/animate.min.css" rel="stylesheet"> 
	<link href="resources/css/main.css" rel="stylesheet">
	<link href="resources/css/responsive.css" rel="stylesheet">

       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="resources/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header">      
      
        <div class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                  

                    <a class="navbar-brand" >
                       <h1>
                           <a href="<c:url value='/welcome' />" ><img src="resources/images/logo.png" alt="logo"></a></h1>
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
                            <h1 class="title">List of all users</h1>
                           
                        </div>
                     </div>
                </div>
            </div>
        </div>
   </section>
    <!--/#page-breadcrumb-->

    <section id="company-information" class="padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="300ms">
        <div class="container">
            <div class="row">
                  <div class="col-md-4 col-sm-12">
                    <div class="contact-form bottom">
  
  <table cellspacing='0'>
        <tr>
            <td>NAME</td><td>Username</td><td>Password</td><td>Created At</td><td>email</td><td>Admin</td><td>Avatar</td><td></td><td></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
            <td>${user.name}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.createdAt}</td>
            <td>${user.email}</td>
            <td>${user.admin}</td>
            <td>${user.avatar}</td>
            <td><a href="<c:url value='/edit-${user.username}-user' />"><button type="button" class="btn btn-success" >Edit</button></a></td>
            <td><a href="<c:url value='/delete-${user.username}-user' />"><button type="button" class="btn btn-danger">Delete</button></a></td>
          
            </tr>
        </c:forEach>
    </table>
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
