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
	  "data": {"status":0},
	  "success": function(response){
		  console.log(response);
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
  el: '#manageback',
  data: function(){
	  return serviceData;
  },
  methods: {
	  del: function(id){
		  $.ajax({
			  "url": "fileInfo/delete",
			  "type": "post",
			  "dataType": "json",
			  "data": {fileId:id},
			  "success": function(response){
				  if(response.msg == "success"){
					  alert("删除成功")
				  }
				  location.href = "manager_findback.jsp";
			  },
			  "error": function(error){
				  
			  }
		   });
	  },
	  back: function(id){
		  $.ajax({
			  "url": "fileInfo/update",
			  "type": "post",
			  "dataType": "json",
			  "data": {fileId:id, status:"2"},
			  "success": function(response){
				  if(response.msg == "success"){
					  alert("恢复成功")
				  }
				  location.href = "manager_findback.jsp";
			  },
			  "error": function(error){
				  
			  }
		   });
	  }
  }
});