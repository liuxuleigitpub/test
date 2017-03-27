<%@ page language="java" pageEncoding="utf-8"%>
<link href="css/addMaterial.css" rel="stylesheet" type="text/css"/>
<link href="css/style-metro.css" rel="stylesheet" type="text/css"/>
<div class="row-fluid">
	<div class="span12">
		<div class="portlet box tabbable">
			<div class="portlet-body form">
				<div class="tabbable portlet-tabs">
					<ul class="nav nav-tabs"></ul>
					<div class="tab-content">
						<div id="dashboard">
							<!-- BEGIN DASHBOARD STATS -->
							<!-- <div class="row-fluid" id="todayDataSummary">
							</div> -->
							<!-- END DASHBOARD STATS -->
							<div class="clearfix"></div>
							<div class="row-fluid">
								<div class="form-horizontal">
									<table style="margin:20px 10px 20px 0px;">
										<tr>
											<td><div style=""><label class="">开始时间：</label></div></td>
											<td><input class="m-wrap m-ctrl-medium date-picker" id="begindate" readonly size="16" type="text" value="" /></td>
											<td><div style="margin-left:10px;"><label class="">结束时间：</label></div></td>
											<td><input class="m-wrap m-ctrl-medium date-picker" id="enddate" readonly size="16" type="text" value="" /></td>
											<td><div style="margin-left:10px;"><button  class="btn blue" type="button" onclick="doQueryHistoryDeveloperIncome()">点击查询</button></div></td>
											<td id="todayDataQuery"> <div style="margin-left:10px;"><button  class="btn blue" type="button" onclick="doQueryTodayDeveloperIncome()">实时数据</button></div></td>
										</tr>
									</table>									
									<table class="table table-striped table-hover table-bordered" id="sample_editable_1">
										<thead>
											<tr>											
												<th> 渠道概况 </th>												
												<th> 渠道 </th>												
                                                <th> DAU </th>
                                                <th> 订购次数 </th>
                                                <th> 收益 </th>
                                                <th> UP值 </th>
                                                <th> 详情 </th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="js/select2.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/DT_bootstrap.js"></script>
<script type="text/javascript" src="js/table-editable.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript" src="js/developerIncomeSummary.js"></script>
<script>
	jQuery(document).ready(function() {   
	   //TableEditable.init(); 
			//$("#todayDataQuery").replaceWith("<div style=\"margin-left:10px;\"><button  class=\"btn blue\" type=\"button\" onclick=\"doQueryTodayDeveloperIncome()\">实时数据</button></div>");
			//$("#todayDataSummary").replaceWith("<div class=\"row-fluid\"><div class=\"span3 responsive\ data-tablet=\"span6\" data-desktop=\"span3\"><div class=\"dashboard-stat blue\"><div class=\"visual\"><i class=\"icon-male\"></i></div><div class=\"details\"><div class=\"number\" id=\"added_number\">loading ...</div><div class=\"desc\">新增用户（今日）</div></div></div></div><div class=\"span3 responsive\" data-tablet=\"span6\" data-desktop=\"span3\"><div class=\"dashboard-stat green\"><div class=\"visual\"><i class=\"icon-male\"></i></div><div class=\"details\"><div class=\"number\" id=\"income_number\">loading ...</div><div class=\"desc\">活跃用户（今日）</div></div></div></div><div class=\"span3 responsive\" data-tablet=\"span6  fix-offset\" data-desktop=\"span3\"><div class=\"dashboard-stat purple\"><div class=\"visual\"><i class=\"icon-money\"></i></div><div class=\"details\"><div class=\"number\" id=\"month_added_number\">loading ...</div><div class=\"desc\">下载次数（今日）</div></div></div></div><div class=\"span3 responsive\" data-tablet=\"span6\" data-desktop=\"span3\"><div class=\"dashboard-stat yellow\"><div class=\"visual\"><i class=\"icon-money\"></i></div><div class=\"details\"><div class=\"number\" id=\"month_income_number\">loading ...</div><div class=\"desc\">预计收益（元）</div></div></div></div></div>");
			
			$("#begindate").click(function(){
				WdatePicker({startDate:'%y-%M-01',dateFmt:'yyyyMMdd',alwaysUseStartDate:true});
			});
			$("#enddate").click(function(){
				WdatePicker({startDate:'%y-%M-01',dateFmt:'yyyyMMdd',alwaysUseStartDate:true});
			});
		
	    initIncomeSummary();
	});
</script>
<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script>
