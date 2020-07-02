<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">

<link rel="icon" href="./include/images/favicon.ico">
<link rel="shortcut icon" href="./include/images/favicon.ico" />


<c:forTokens items="${param.cssFiles}" delims="|" var="cssFile">
	<link rel="stylesheet"
		href="<c:url value="./include/css/${cssFile}.css" />" />
</c:forTokens>

<c:forTokens items="${param.jsFiles}" delims="|" var="cssFile">
	<link rel="stylesheet"
		href="<c:url value="./include/js/${jsFiles}.js" />" />
</c:forTokens>


<script>
	$(window).load(function() {
		$('.slider')._TMS({
			show : 0,
			pauseOnHover : false,
			prevBu : '.prev',
			nextBu : '.next',
			playBu : false,
			duration : 800,
			preset : 'fade',
			pagination : true,//'.pagination',true,'<ul></ul>'
			pagNums : false,
			slideshow : 8000,
			numStatus : false,
			banners : false,
			waitBannerAnimation : false,
			progressBar : false
		})
	});

	$(window).load(function() {
		$('.carousel1').carouFredSel({
			auto : false,
			prev : '.prev',
			next : '.next',
			width : 960,
			items : {
				visible : {
					min : 1,
					max : 4
				},
				height : 'auto',
				width : 240,

			},
			responsive : false,

			scroll : 1,

			mousewheel : false,

			swipe : {
				onMouse : false,
				onTouch : false
			}
		});

	});
</script>
<!--[if lt IE 8]>
       <div style=' clear: both; text-align:center; position: relative;'>
         <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
           <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
         </a>
      </div>
    <![endif]-->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <link rel="stylesheet" media="screen" href="css/ie.css">

    <![endif]-->
</head>

<body>
	<div class="main">
		<jsp:include page="/WEB-INF/template/header.jsp" />
		<jsp:include page="/WEB-INF/${param.content}.jsp" />
	</div>
	<jsp:include page="/WEB-INF/template/footer.jsp" />
</body>
</html>
