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
	  "url": "fileInfo/findList",
	  "type": "post",
	  "dataType": "json",
	  "data": {status:"2"},
	  "success": function(response){
		  //console.log(response);
		  serviceData.services = response;
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
  el: '#manage',
  data: function(){
	  return serviceData;
  },
  methods: {
	  select: function(value){
		  serviceData.skill = value;
		  page.skill = value;
		  page.keyword = "";
		  query();
	  },
	  del: function(id){
		  $.ajax({
			  "url": "fileInfo/update",
			  "type": "post",
			  "dataType": "json",
			  "data": {fileId:id, status:"0"},
			  "success": function(response){
				  if(response.msg == "success"){
					  alert("删除成功")
				  }
				  location.href = "manager.jsp";
			  },
			  "error": function(error){
				  
			  }
		   });
	  }
  }
});