<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.5
Version: 4.5.2
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
<meta charset="utf-8" />
<title>Metronic | Dashboard</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN LAYOUT FIRST STYLES -->
<link href="../css/googlecss.css" rel="stylesheet" type="text/css" />
<!-- END LAYOUT FIRST STYLES -->
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="../css/css.css" rel="stylesheet" type="text/css" />
<link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="../css/simple-line-icons.min.css" rel="stylesheet"
	type="text/css" />
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="../css/uniform.default.min.css" rel="stylesheet"
	type="text/css" />
<link href="../css/bootstrap-switch.min.css" rel="stylesheet"
	type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<link href="../css/daterangepicker.min.css" rel="stylesheet"
	type="text/css" />
<link href="../css/morris.css" rel="stylesheet" type="text/css" />
<link href="../css/fullcalendar.min.css" rel="stylesheet" type="text/css" />
<link href="../css/jqvmap.css" rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN THEME GLOBAL STYLES -->
<link href="../css/components.min.css" rel="stylesheet"
	id="style_components" type="text/css" />
<link href="../css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" />
<link href="../css/plugins.min.css" rel="stylesheet" type="text/css" />
<!-- END THEME GLOBAL STYLES -->
<!-- BEGIN THEME LAYOUT STYLES -->
<link href="../css/layout.min.css" rel="stylesheet" type="text/css" />
<link href="../js/myPagination/page.css" rel="stylesheet" type="text/css" />
<link href="../css/custom.min.css" rel="stylesheet" type="text/css" />
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
					<a id="index" class="navbar-brand" href="start.html"> <img
						src="../img/logo.png" alt="Logo">
					</a>
					<!-- END LOGO -->
					<!-- BEGIN TOPBAR ACTIONS -->
					<div class="topbar-actions">
						<!-- DOC: Apply "search-form-expanded" right after the "search-form" class to have half expanded search box -->
						<!-- END HEADER SEARCH BOX -->
						<!-- BEGIN GROUP NOTIFICATION -->
						<div class="btn-group-notification btn-group"
							id="header_notification_bar">
							<button type="button" class="btn dropdown-toggle"
								data-toggle="dropdown" data-hover="dropdown"
								data-close-others="true" onclick="javascript:window.location.href='../loginout';">
								<span class="badge">退出</span>
							</button>
						</div>
						<!-- END GROUP NOTIFICATION -->
					</div>
					<!-- END TOPBAR ACTIONS -->
				</div>
			</div>
			<!--/container-->
		</nav>
	</header>
	<!-- END HEADER -->
	<!-- BEGIN CONTAINER -->
	<div class="container-fluid">
		<div class="page-content page-content-popup">
			<div class="page-content-fixed-header">
				<!-- BEGIN BREADCRUMBS -->
				<ul class="page-breadcrumb">
					<li><a href="#">Dashboard</a></li>
					<li><%=request.getParameter("starttime") %>日 到 <%=request.getParameter("endtime") %>日 渠道:<%=request.getParameter("cid") %> 明细</li>
				</ul>
				<!-- END BREADCRUMBS -->
			</div>
			<div class="page-sidebar-wrapper">
				<!-- BEGIN SIDEBAR -->
				<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
				<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
				<div class="page-sidebar navbar-collapse collapse">
					<!-- BEGIN SIDEBAR MENU -->
					<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
					<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
					<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
					<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
					<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
					<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
					<ul class="page-sidebar-menu  page-header-fixed "
						data-keep-expanded="false" data-auto-scroll="true"
						data-slide-speed="200">
						<li class="nav-item start active open"><a href="javascript:;"
							class="nav-link nav-toggle"> <i class="icon-home"></i> <span
								class="title">主页</span> <span class="selected"></span> <span
								class="arrow open"></span>
						</a>
							<ul class="sub-menu">
								<li class="nav-item start active open"><a href="income_profile.jsp"
									class="nav-link "> <i class="icon-bar-chart"></i> <span
										class="title">收入概况</span> <span class="selected"></span>
								</a></li>
<!-- 								<li class="nav-item start "><a href="./table_channel_revenue.html" -->
<!-- 									class="nav-link "> <i class="icon-graph"></i> <span -->
<!-- 										class="title">渠道收入</span> -->
<!-- 								</a></li> -->
<!-- 								<li class="nav-item start "><a href="./table_channel_management.html" -->
<!-- 									class="nav-link "> <i class="icon-bulb"></i> <span -->
<!-- 										class="title">渠道管理</span> -->
<!-- 								</a></li> -->
							</ul></li>

					</ul>
					<!-- END SIDEBAR MENU -->
				</div>
				<!-- END SIDEBAR -->
			</div>
			<script src="../js/jquery.min.js" type="text/javascript"></script>
			<script type="text/javascript">
				$(function(){
					$("#starttimediv").attr('data-date',CurentTime());
					$("#endtimediv").attr('data-date',CurentTime());
				});
			</script>
			<div class="page-fixed-main-content">
				<!-- BEGIN PAGE BASE CONTENT -->
				<!-- BEGIN DASHBOARD STATS 1-->
				<div class="row">
					<div class="portlet-body">
						<table class="table table-striped table-bordered table-hover" id="sample_1">
							<thead>
								<tr>
									<th> 订单号1</th>
									<th> 订单号2 </th>
									<th> 价格</th>
									<th> 支付时间 </th>
									<th> 支付状态 </th>
								</tr>
							</thead>
							<tbody id="dataList">
							</tbody>
						</table>
						<div id="pageBar"></div>
					</div>
				<!-- END DASHBOARD STATS 1-->
				<!-- END PAGE BASE CONTENT -->
			</div>
			<!-- BEGIN FOOTER -->
			<p class="copyright-v2">
				2015 Â© Metronic by keenthemes. Purchase Metronic!
			</p>
			<!-- END FOOTER -->
		</div>
	</div>
	<!-- END CONTAINER -->
	<!--[if lt IE 9]>
<script src="../assets/global/plugins/respond.min.js"></script>
<script src="../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
	<!-- BEGIN CORE PLUGINS -->
	<script src="../js/bootstrap.min.js" type="text/javascript"></script>
	<script src="../js/js.cookie.min.js" type="text/javascript"></script>
	<script src="../js/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
	<script src="../js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="../js/moment.min.js" type="text/javascript"></script>
	 <script src="../js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN THEME GLOBAL SCRIPTS -->
	<script src="../js/app.min.js" type="text/javascript"></script>
	<!-- END THEME GLOBAL SCRIPTS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src="../js/components-date-time-pickers.min.js" type="text/javascript"></script>
        <script src="../js/myPagination/jquery.myPagination6.0.js" type="text/javascript"></script>
        <!-- END PAGE LEVEL SCRIPTS -->
	<script type="text/javascript">
	$(function(){
		var starttime = '<%=request.getParameter("starttime")%>';
		var endtime = '<%=request.getParameter("endtime")%>';
		dataList(starttime,endtime);
	});
	var pageBar;
	function dataList(starttime,endtime){
		var channelid='<%=request.getParameter("cid")%>';
		pageBar = $("#pageBar").myPagination({
			currPage : 1,
			pageSize : 10,
			ajax : {
				on : true,
// 				type: "POST",
				url: "../channel/orderlist",
				param: "pageSize=20&channelid="+channelid+"&starttime="+starttime+"&endtime="+endtime,
				dataType: "json",
				callback:appListAjaxCallBack
			},
			panel: {
				tipInfo_on: true,
				tipInfo: '&nbsp;&nbsp;跳{input}/{sumPage}页&nbsp;',
				tipInfo_css: {
				width: '23px',
				height: "16px",
				border: "2px solid #f0f0f0",
				padding: "0 0 0 5px",
				margin: "0 5px 0 5px",
				color: "#48b9ef"
				}
			}
		});
	}
	function appListAjaxCallBack(data){
		$('#dataList').empty();
		if (data && data.list) {
			// 重新构建table
			$.each(data.list, function(i, row) {
			var state = '支付失败';
			if(row.orderstate == 1){
				state = '支付成功';
			}
			$('#dataList').append(
					'<tr>' +
					'<td align="left">' + row.orderId + '</td>' +
					'<td align="left">' + row.orderChannel + '</td>' +
					'<td align="left">' + row.price + '</td>' +
					'<td align="left">' + row.createtime + '</td>' +
					'<td align="left">' + state + '</td>' +
					'</tr>');
			});
		}else{
			$('#dataList').append('<tr><td colspan="3">暂无数据</td></tr>');
		}
	}
	
	
	function queryData(){
		var starttime = <%=request.getParameter("starttime")%>;
		var endtime = <%=request.getParameter("endtime")%>;
		dataList(starttime,endtime)
		
	}
	function CurentTime()
    { 
        var now = new Date();
       
        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日
       
        var clock = year + "-";
       
        if(month < 10)
            clock += "0";
       
        clock += month + "-";
       
        if(day < 10)
            clock += "0";
           
        clock += day;
       
        return(clock); 
    } 
	</script>
</body>

</html>