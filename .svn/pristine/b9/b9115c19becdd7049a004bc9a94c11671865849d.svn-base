var currentelement;

//库函数定义
//http post请求函数
jQuery.reqPostData = function (httpUrl, rdata,sfunction) {
	try{
      $.ajax({
           type:"POST", 
           url:httpUrl, 
           data:encodeURI(stringify(rdata)),
           timeout: 50000,
           success:function (json) {
           if (json.result == REQUEST_SUCESS) {
        	   if(sfunction){
                 sfunction(json);
               }
              } else {
                  $.each(REQUEST_RESULT, function (i) {
                        if (i == json.result) {
                           if(i=='-4'){
                             window.location.href='/damaopush/admin/login.jsp';
                           }else{
                        	   alert(REQUEST_RESULT[i]);
                           }
                        }
                  });
        }
      },
      error:function(json){
    	  alert('连接超时!');
      },dataType:"json"});
    }catch(e){
    	alert(e);
    }
};
jQuery.reqPostDataExtra = function (httpUrl, rdata,sfunction) {
	try{
      $.ajax({
           type:"POST", 
           url:httpUrl, 
           data:rdata,
           timeout: 50000,
           success:function (json) {
           if (json.result == REQUEST_SUCESS) {
        	   if(sfunction){
                 sfunction(json);
               }
              } else {
                  $.each(REQUEST_RESULT, function (i) {
                        if (i == json.result) {
                           if(i=='-4'){
                             window.location.href='/damaopush/admin/login.jsp';
                           }else{
                        	   alert(REQUEST_RESULT[i]);
                           }
                        }
                  });
        }
      },
      error:function(json){
    	  alert('连接超时!');
      },dataType:"json"});
    }catch(e){
    	alert(e);
    }
};
jQuery.expPostData = function (rdata) {
	var param='t='+new Date().getTime();
	$.each(rdata,function(key,value){
		if(value&&$.trim(value).length>0){
		 param+='&'+key+'='+value;
		}
	});
	window.open(SERVERURL+'?'+param)
};

jQuery.pager = function (pager,sfunction) {
	$('.classify').remove();
	if(!pager||!pager.totalrows){
		return;
	}
	if(!pager.pagesize){
		pager.pagesize=PAGESIZE;
	}
	if(!pager.currentpage){
		pager.currentpage=1;
	}
	if(!pager.id){
		pager.id='goods';
	}
	var pageno=Math.ceil(pager.totalrows/pager.pagesize);
	var html='<div class="classify"><div class="page_left sec_modify_label"><label>每页显示：</label><select id="pagesize" class="select select62"><option value="10" '+(pager.pagesize==10?"selected":"")+'>10</option><option value="20" '+(pager.pagesize==20?"selected":"")+'>20</option><option value="30" '+(pager.pagesize==30?"selected":"")+'>30</option></select><label>条</label></div><div class="page_right sec_modify_label02"><label>共'+pager.totalrows+'条</label> '+(pager.currentpage>1?'<a href="####" id="pager_up">上一页</a> ':'')+'<label>第'+pager.currentpage+'/'+pageno+'页</label> '+(pager.currentpage<pageno?'<a href="####" id="pager_down">下一页</a>':'')+' <label>跳转到第</label> <span class="sec_input_width"><input type="text" id="pageno" class="sec_modify_int" /></span> <label>页</label> <a href="####" class=" text confirm sec_confirm" id="pager_select">确定</a></div><div class="clear"></div></div>';
	$('.'+pager.id).append(html);
	$('#pagesize').change(function(){
		    sfunction({currentpage:1,pagesize:$('#pagesize').val(),totalrows:pager.totalrows});
	});
	$('#pager_up').click(function(){
		if(pager.currentpage==1){
		    alert('现在已是首页');return;
	    }else{
			//pager.currentpage = pager.currentpage-1;
		    sfunction({currentpage:pager.currentpage - 1,pagesize:$('#pagesize').val(),totalrows:pager.totalrows});
		}
	});
	$('#pager_down').click(function(){
		if(pager.currentpage==pageno){
		    alert('现在已是尾页');return;
	    }else{
			//pager.currentpage = pager.currentpage+1;
		    sfunction({currentpage:pager.currentpage + 1,pagesize:$('#pagesize').val(),totalrows:pager.totalrows});
		}
	});
	$('#pager_select').click(function(){
		if(!isInt($('#pageno').val())){
			alert('请输入你要跳转到的页码');return;
		}else if($('#pageno').val()>pageno){
			alert('输入的页码不能大于'+pageno);return;
		}else if($('#pageno').val()<1){
			alert('输入的页码不能小于1');return;
		}else{
			//pager.currentpage = $('#pageno').val();
			sfunction({currentpage:$('#pageno').val(),pagesize:$('#pagesize').val(),totalrows:pager.totalrows});
		}
	});
};

function stringify(obj) {
    var t = typeof (obj); 
    if (t != "object" || obj == null) { 
        if (t == "string") obj = '"'+obj+'"'; 
        obj = obj.replace(/[\n\r]/gi,"");
        return String(obj); 
    }else { 
        var n, v, json = [], arr = (obj && obj.constructor == Array);
        if(!arr){
           for (n in obj) { 
              v = obj[n]; 
              t = typeof(v); 
              if (t == "string") {
            	   if(v.match(/[\"\'\<\>]/gi)){throw('输入的内容不能包含\" \'<>字符');}
            	   v = '"'+v+'"';
            	   //v = v.replace(/[\n\r]/gi,"");
              }else if (t == "object" && v !== null) {
            	  v = stringify(v);
              } 
              json.push( '"' + n + '":' + String(v)); 
        }
        }else{
        	for(var i=0;i<obj.length;i++)
        	{
        		json.push(stringify(obj[i])); 
        	}
        }
        return (arr ? "[" : "{") + String(json) + (arr ? "]" : "}"); 
    } 
};

jQuery.fn.extend({
   getForm:function(options){  
        var settings = jQuery.extend({  
            key:'',
            data:{},
            functionid:'',
            src:REQUEST_SRC
        },options);  
        var ret =settings.data;
        var args=[];
        if(this.get(0).tagName.toLowerCase()=='form'){  
            var that =jQuery(this);
            if(settings.data){
            $.each(settings.data, function(key, val) {
             ret[key] = val;
            });
            }
            that.find('input,select,radio,textarea').each(function(){  
                var el = jQuery(this);
                var fieldName = el.attr('name');
                if(fieldName){
                  if(settings.key&&settings.key==el.val()){
                     var temp ={};
                     temp[fieldName] = el.val();  
                     args.push(temp);
                  }else{
                     ret[fieldName] = el.val();
                  }
                }
            });
        if(settings.key&&args.length>0)
          ret[settings.key] = args;
        }
        return ret;  
    }  
});

//退出登录
function logout(){
       $.reqPostData(
	   SERVERURL + '200',
	   {reqType:'F9900004'},
	   function(data){
	      if(data&&data.result==REQUEST_SUCESS){
			  window.location.href='/damaopush/admin/login.jsp';
		  }else{
		   	  alert('操作失败');
	      }
       });	
}

function debuger(data)
{
	var info = data;
	//alert(info);
}

function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth()+1;//获取当前月份的日期
    if(m < 10){
    	m = "0" + m;
    }
    var d = dd.getDate();
    if(d < 10){
    	d = "0" + d;
    }
    return y+""+m+""+d;
}

function GetYesterday() {
    var dd = new Date();
    dd.setDate(dd.getDate()-1);
    var y = dd.getFullYear();
    var m = dd.getMonth()+1;
    var d = dd.getDate();
    return y+"年"+m+"月"+d+"日";
}

function initUserMenu(){
	$.reqPostData(SERVERURL+'102', {reqType:'F9900005'},function(data){
		if(data){
			if(data.username){
				$('.username').html(data.username);
			}
		}
		$.reqPostData(SERVERURL+'103',{reqType:'F9900002'},loadUserMenu);
	});	
}

//动态生成大猫广告平台一级和二级菜单
function loadUserMenu(data){
	var menuString = "";
   $.each(data.menus, function(i, menus) {
	   	
	   	var parentMenuName = menus.name;
	   	var letterSpace = (100 - (parentMenuName.length * 14))/(parentMenuName.length - 1) ;
	   	var parentMenuNameA = parentMenuName.substring(0,parentMenuName.length - 1);
	   	var parentMenuNameB = parentMenuName.substring(parentMenuName.length - 1, parentMenuName.length);
	   	var image = menus.image;
	   	if(image == null || image == 'null' || image == undefined || image == 'undefined'){
	   		image = '';
	   	}
        var menustr = '<li class=""><a href="javascript:;" style="text-align: -moz-center !important;text-align:center;">'+
        	'<img alt="" src="'+image+'" style="float:left"/>'+
        '<span class="title" style="letter-spacing:' + letterSpace + 'px;">';
        menustr+=parentMenuNameA;
        menustr+='</span><span>' + parentMenuNameB + '</span><span class="arrow "></span></a><ul class="sub-menu">';
        if(menus.children){
        var children=eval(menus.children);
        
        $.each(children, function(j, ssm) {
        if(ssm&&ssm.pid==menus.id){
        	if(ssm.url){
               if(ssm.url.indexOf("?")<=0){
        	    	ssm.url=ssm.url+'?t='+new Date().getTime();
               }else{
        	        ssm.url=ssm.url+"&t="+new Date().getTime();
               }
            }
//           menustr += '<li ><a href="javascript:alert(\'haha\');">' + ssm.name + '</a></li>';
           menustr += '<li ><a href="javascript:mainPageTo(\'' + ssm.url + '\',\'\')\">' + ssm.name + '</a></li>';
         }
        });        
        menustr += '</ul></li>';
        }
        menuString += menustr;
    });
   $("#left").append(menuString);
}

//2015.9.6 赵经纬添加用于页面跳转用			
function mainPageTo(pageURL, detailJson){
	if(detailJson!=null){
		$("#mainbody").load('html/' + pageURL, detailJson);
	}else{
		$("#mainbody").load('html/' + pageURL);
	}
}

function randomString(len) {
	len = len || 32;
	var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';    /****默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1****/
	var maxPos = $chars.length;
	var pwd = '';
	for (i = 0; i < len; i++) {
		pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
	}
	return pwd;
}