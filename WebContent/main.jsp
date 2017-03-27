<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>渠道概况</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN LAYOUT FIRST STYLES -->
<link href="//fonts.googleapis.com/css?family=Oswald:400,300,700"
	rel="stylesheet" type="text/css" />
<!-- END LAYOUT FIRST STYLES -->
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="css/simple-line-icons.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/uniform.default.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/bootstrap-switch.min.css" rel="stylesheet"
	type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<link href="css/daterangepicker.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/morris.css" rel="stylesheet" type="text/css" />
<link href="css/fullcalendar.min.css" rel="stylesheet" type="text/css" />
<link href="css/jqvmap.css" rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="css/components.min.css" rel="stylesheet"
	id="style_components" type="text/css" />
<link href="css/plugins.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<link href="css/layout.min.css" rel="stylesheet" type="text/css" />
<link href="css/custom.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME LAYOUT STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->

<body class="">
	<!-- BEGIN HEADER -->
	<header class="page-header">
		<nav class="navbar" role="navigation">
			<div class="container-fluid">
				<div class="havbar-header">
					<!-- BEGIN LOGO -->
					<a id="index" class="navbar-brand" href="index.jsp"> <img
						src="img/logo.png" alt="Logo">
					</a>
				</div>
			</div>
		</nav>
	</header>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="container-fluid">
		<div class="page-content page-content-popup">
			<div class="page-content-fixed-header">
				<!-- BEGIN BREADCRUMBS -->
				<!-- END BREADCRUMBS -->
				<div class="content-header-menu"></div>
			</div>
			<div class="page-sidebar-wrapper">
				<!-- BEGIN SIDEBAR -->
				<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
				<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
				<div class="page-sidebar navbar-collapse collapse">
					<ul class="page-sidebar-menu  page-header-fixed "
						data-keep-expanded="false" data-auto-scroll="true"
						data-slide-speed="200">
						<li class="nav-item start active open"><a href="javascript:;"
							class="nav-link nav-toggle"> <i class="icon-home"></i> <span
								class="title">主页</span> <span class="selected"></span> <span
								class="arrow open"></span>
						</a>
							<ul class="sub-menu">
								<li class="nav-item start "><a
									href="./table_income_profile.html" class="nav-link "> <i
										class="icon-bar-chart"></i> <span class="title">收入概况</span>
								</a></li>
								<li class="nav-item start active open"><a
									href="./table_channel_revenue.html" class="nav-link "> <i
										class="icon-graph"></i> <span class="title">渠道收入</span><span
										class="selected"></span>
								</a></li>
								<li class="nav-item start "><a
									href="./table_channel_management.html" class="nav-link "> <i
										class="icon-bulb"></i> <span class="title">渠道管理</span>
								</a></li>
							</ul></li>

					</ul>
					<!-- END SIDEBAR MENU -->
				</div>
				<!-- END SIDEBAR -->
			</div>
			<div class="page-fixed-main-content">
				<!-- BEGIN PAGE BASE CONTENT -->
				<!-- BEGIN DASHBOARD STATS 1-->
				<div class="page-content" style="border-left: 1px solid #ccc;">
				
<!-- 				<div style="padding: 20px 20px 20px 20px; background-color: #F2F2F2; border:1px solid #C6C6C6; width:1100px;"> -->
				<div style="background-color: #F6F7FB; width:100%;">
					<!-- 主页面内容	BEGIN MAIN BODY -->
				 	<div id="mainbody" style="width:100%;">
						<jsp:include page="developerChannel.jsp" flush="true" />
					</div> 
					<!-- END MAIN BODY -->
				</div>
				
				<!-- END PAGE CONTAINER-->
			</div>
				<!-- BEGIN FOOTER -->

				<!-- BEGIN QUICK SIDEBAR TOGGLER -->
				<!-- END QUICK SIDEBAR TOGGLER -->
				<a href="#index" class="go2top"> <i class="icon-arrow-up"></i>
				</a>
				<!-- END FOOTER -->
			</div>
		</div>
		<!-- END CONTAINER -->

		<!--[if lt IE 9]>
<script src="../assets/global/plugins/respond.min.js"></script>
<script src="../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
		<!-- BEGIN CORE PLUGINS -->
		<script src="js/jquery.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/js.cookie.min.js" type="text/javascript"></script>
		<script src="js/bootstrap-hover-dropdown.min.js"
			type="text/javascript"></script>
		<script src="js/jquery.slimscroll.min.js" type="text/javascript"></script>
		<script src="js/jquery.blockui.min.js" type="text/javascript"></script>
		<script src="js/jquery.uniform.min.js" type="text/javascript"></script>
		<script src="js/bootstrap-switch.min.js" type="text/javascript"></script>
		<!-- END CORE PLUGINS -->
		<!-- BEGIN PAGE LEVEL PLUGINS -->
		<script src="js/moment.min.js" type="text/javascript"></script>
		<script src="js/daterangepicker.min.js" type="text/javascript"></script>
		<script src="js/morris.min.js" type="text/javascript"></script>
		<script src="js/raphael-min.js" type="text/javascript"></script>
		<script src="js/jquery.waypoints.min.js" type="text/javascript"></script>
		<script src="js/jquery.counterup.min.js" type="text/javascript"></script>
		<script src="js/amcharts.js" type="text/javascript"></script>
		<script src="js/serial.js" type="text/javascript"></script>
		<script src="js/pie.js" type="text/javascript"></script>
		<script src="js/radar.js" type="text/javascript"></script>
		<script src="js/light.js" type="text/javascript"></script>
		<script src="js/patterns.js" type="text/javascript"></script>
		<script src="js/chalk.js" type="text/javascript"></script>
		<script src="js/ammap.js" type="text/javascript"></script>
		<script src="js/worldLow.js" type="text/javascript"></script>
		<script src="js/amstock.js" type="text/javascript"></script>
		<script src="js/fullcalendar.min.js" type="text/javascript"></script>
		<script src="js/jquery.flot.min.js" type="text/javascript"></script>
		<script src="js/jquery.flot.resize.min.js" type="text/javascript"></script>
		<script src="js/jquery.flot.categories.min.js" type="text/javascript"></script>
		<script src="js/jquery.easypiechart.min.js" type="text/javascript"></script>
		<script src="js/jquery.sparkline.min.js" type="text/javascript"></script>
		<script src="js/jquery.vmap.js" type="text/javascript"></script>
		<script src="js/jquery.vmap.russia.js" type="text/javascript"></script>
		<script src="js/jquery.vmap.world.js" type="text/javascript"></script>
		<script src="js/jquery.vmap.europe.js" type="text/javascript"></script>
		<script src="js/jquery.vmap.germany.js" type="text/javascript"></script>
		<script src="js/jquery.vmap.usa.js" type="text/javascript"></script>
		<script src="js/jquery.vmap.sampledata.js" type="text/javascript"></script>
		<!-- END PAGE LEVEL PLUGINS -->
		<!-- BEGIN THEME GLOBAL SCRIPTS -->
		<script src="js/app.min.js" type="text/javascript"></script>
		<!-- END THEME GLOBAL SCRIPTS -->
		<!-- BEGIN PAGE LEVEL SCRIPTS -->
		<script src="js/dashboard.min.js" type="text/javascript"></script>
		<!-- END PAGE LEVEL SCRIPTS -->
		<!-- BEGIN THEME LAYOUT SCRIPTS -->
		<script src="js/layout.min.js" type="text/javascript"></script>
		<script src="js/quick-sidebar.min.js" type="text/javascript"></script>
		<!-- END THEME LAYOUT SCRIPTS -->
</body>
</html>