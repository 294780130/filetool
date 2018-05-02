'use strict'

var userInfo = {
	"userName":"",
	"password":"",
	"type":"0"
};

new Vue({
  el: '#login',
  data: function(){
	  return userInfo;
  },
  methods: {
	 register: function(){
		 //console.log(userInfo);
		 $.ajax({
			  "url": "userInfo/save",
			  "type": "post",
			  "dataType": "json",
			  "data": userInfo,
			  "success": function(response){
				  //console.log(response);
				  if(response.msg == 'success'){
					  alert("注册成功")
				  }
			  },
			  "error": function(error){
				  
			  }
		 });
	 },
	 login: function(){
		 $.ajax({
			  "url": "userInfo/login",
			  "type": "post",
			  "dataType": "json",
			  "data": userInfo,
			  "success": function(response){
				  //console.log(response);
				  var msg = response.msg;
				  if(msg == '-1'){
					  alert("账号不存在");
				  }else if(msg == '0'){
					  alert("密码错误");
				  }else if(msg == '1'){
					  var userinfo = response.userinfo;
					  //console.log(userinfo);
					  if(userinfo.type ==  1){
						  location.href = "manager.jsp";
					  }else{
						  location.href = "index.jsp";
					  }
				  }
			  },
			  "error": function(error){
				  
			  }
		 });
	 },
	 change: function(value){
		 userInfo.type = value;
	 }
	 
  }
});