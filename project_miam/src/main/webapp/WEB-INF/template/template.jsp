<%@ page language="java" contentType="text/html;   charset=utf-8"
	pageEncoding="utf-8"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<title>${param.title}</title>

<link rel="icon" href="./include/images/favicon.ico">
<link rel="shortcut icon" href="./include/images/favicon.ico" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<!-- web font -->
<link
	href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i"
	rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Marcellus+SC" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<!-- //web font -->

		
<c:forTokens items="${param.cssFiles}" delims="|" var="cssFile">
	<link rel="stylesheet"
		href='<c:url value="./include/css/${cssFile}.css" />' />
</c:forTokens>

<c:forTokens items="${param.jsFiles}" delims="|" var="jsFile">
	<script src='<c:url value="./include/js/${jsFile}.js" />' ></script>
</c:forTokens>

<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
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
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="keywords" content="Shopping Cart a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- //Meta-Tags -->
	<!-- Index-Page-CSS -->
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
	<!-- //Custom-Stylesheet-Links -->
	<!--fonts -->
	<link href="//fonts.googleapis.com/css?family=Marcellus+SC" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- //fonts -->

	<!-- Font-Awesome-File-Links -->
	<!-- CSS -->
	<link rel="stylesheet" href="css/font-awesome.css" type="text/css" media="all">
	<!-- //Font-Awesome-File-Links -->
    
</head>

<body>
	<div class="main">
		<jsp:include page="/WEB-INF/template/header.jsp" />
		<jsp:include page="/WEB-INF/${param.content}.jsp" />
	</div>
	<jsp:include page="/WEB-INF/template/footer.jsp" />
</body>
</html>
