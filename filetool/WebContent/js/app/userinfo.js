'use strict'

var serviceData = {
	services : [],
	totalPage : "",
	goType : 0
};

var page = {
	pageNumber: "1",
	lineNumber: "10",
}


var query = function(){
	$.ajax({
	  "url": "userInfo/findList",
	  "type": "post",
	  "dataType": "json",
	  "data": {},
	  "success": function(response){
		  //console.log(response);
		  serviceData.services = response;
		  /*serviceData.services = response.result;
		  var totalCount = response.totalCount;
		  var lineNumber = response.lineNumber;
		  serviceData.totalPage = parseInt(totalCount/lineNumber) + (totalCount%lineNumber == 0 ? 0 : 1);*/
		  //console.log(serviceData);
	  },
	  "error": function(error){
		  
	  }
   });
};

query();

Vue.filter('time', function(value){
	var date = new Date(value);
	return moment(date).format("YYYY-MM-DD hh:mm:ss");
});

new Vue({
  el: '#userinfo',
  data: function(){
	  return serviceData;
  },
  methods: {
	  del: function(id){
		  $.ajax({
			  "url": "userInfo/delete",
			  "type": "post",
			  "dataType": "json",
			  "data": {userId:id},
			  "success": function(response){
				  if(response.msg == "success"){
					  alert("删除用户成功")
				  }
				  location.href = "manager_user.jsp";
			  },
			  "error": function(error){
				  
			  }
		   });
	  },
	  update: function(id, type){
		  $.ajax({
			  "url": "userInfo/update",
			  "type": "post",
			  "dataType": "json",
			  "data": {userId:id, type:type},
			  "success": function(response){
				  if(response.msg == "success"){
					  alert("更新用户权限成功")
				  }
				  location.href = "manager_user.jsp";
			  },
			  "error": function(error){
				  
			  }
		   });
	  }
  }
});