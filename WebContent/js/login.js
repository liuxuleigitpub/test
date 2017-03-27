function login(){
	var name=$('#username').val();
	var passwd=$('#passwd').val();
	var code=$('#code').val();
   if(!name||$.trim(name).length==0){
	   alert('请输入用户名');
	   return;
   }
   if(!passwd||$.trim(passwd).length==0){
	   alert('请输入密码');
	   return;
   }
   console.log(name+passwd);
   window.location.href="main.jsp";
	   
   
//   $.ajax({
//       type:"POST", 
//       url:'/damaopush/adminmanager/101', 
//       data:'{"reqType":"F9900001","username":"'+name+'","passwd":"'+passwd+'"}',
//       timeout: 10000,
//       success:function (json) {
//    	console.log(json);
//       if (json.result == '1') {
//			window.location.href="main.jsp?currentUserId="+json.uid+"&currentUserRole="+json.role_id;
//       }else if(json.result == '-1'){
//			alert('用户名密码错误');
//    	   //$('.logo_p').find('img').attr('src',"/smspay/imgcode?"+Math.random());
//      }
//},
//  error:function(json){
//	  alert('连接超时!');
//  },dataType:"json"});
}