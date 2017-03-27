/*******************************************************************************
 * 查询
 */

function initIncomeSummary(){
	var onWeekAgo = GetDateStr(-7);
	$('#begindate').val(onWeekAgo);
	var yesterday = GetDateStr(-1);
	$('#enddate').val(yesterday);
	doQueryHistoryDeveloperIncome();
	initTodaySummary();
}

function initTodaySummary(){
	var userid = window.currentUserId;
	$.reqPostData(SERVERURL + '710',{
		reqType : 'F9902009',
		userid : userid
	}, function(data) {
		if (data && data.rows) {
			// 重新构建table
			$.each(data.rows, function(i, row) {
				$('#income_number').html(row.userCount);
				$('#added_number').html(row.newUserCount);
				$('#month_added_number').html(row.downloadTimes);
				$('#month_income_number').html(row.anticipatedincome);
			});
		}
	});
	
}


var doQueryHistoryDeveloperIncome = function() {
	var userid = window.currentUserId;
	
	var begindate = $('#begindate').val();//获取当前id的值 类似于tostring
	var enddate = $('#enddate').val();
	if(begindate == ''){
		alert('请选择开始时间');
		return;
	}
	if(enddate == ''){
		alert('请选择结束时间');
		return;
	}
	
	$.reqPostData(SERVERURL + '706',{
		reqType : 'F9902009',
		begindate: begindate,
		enddate	: enddate,
		userid : userid
	}, function(data) {
//		 alert(JSON.stringify(data));
		$('#sample_editable_1').dataTable().fnClearTable(); // 将数据清除
		if (data && data.rows) {
			// 重新构建table
			$.each(data.rows, function(i, row) {
				$('#sample_editable_1').dataTable().fnAddData(
						packagingdatatabledata(row), true); // 数据必须是json对象或json对象数组
			});
		}
	});
};

function doQueryTodayDeveloperIncome() {
	var userid = window.currentUserId;
	$.reqPostData(SERVERURL + '710',{
		reqType : 'F9902009',
		userid : userid
	}, function(data) {
//		 alert(JSON.stringify(data));
		$('#sample_editable_1').dataTable().fnClearTable(); // 将数据清除
		if (data && data.rows) {
			// 重新构建table
			$.each(data.rows, function(i, row) {
				$('#sample_editable_1').dataTable().fnAddData(
						packagingdatatabledata(row), true); // 数据必须是json对象或json对象数组
			});
		}
	});
};

// 把服务器返回的数据转成datatable须要的格式
function packagingdatatabledata(row) {
	var a = [];
	a.push(row.createDay);
	a.push(row.newUserCount);
	a.push(row.userCount);
	a.push(row.showTimes);
	a.push(row.clickTimes);
	a.push(row.downloadTimes);
	a.push(row.installTimes);
	a.push(row.unInstallTimes);
	a.push((row.showTimes/row.userCount).toFixed(0));	//人均展示次数
	a.push(row.showTimes == 0?'0.00%':(row.clickTimes*100/row.showTimes).toFixed(2)+"%");	//点击转化：点击/展示
	a.push(row.clickTimes == 0?'0.00%':(row.downloadTimes*100/row.clickTimes).toFixed(2)+"%");	//下载转化：下载/点击
	a.push(row.downloadTimes == 0?'0.00%':(row.installTimes*100/row.downloadTimes).toFixed(2)+"%");	//安装转化：安装/下载
	a.push(row.anticipatedincome);
	a.push(row.realincome);
	return a;
}

function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth()+1;//获取当前月份的日期    date.month()返回的是上一月的值
    if(m < 10){
    	m = "0" + m;
    }
    var d = dd.getDate();
    if(d < 10){
    	d = "0" + d;
    }
    return y+""+m+""+d;
   
}
