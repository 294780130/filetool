'use strict'

var getQueryString = function(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); 
    return null; 
}

var serviceData = {
	fileinfo: {
		fileId: "",
		fileName: "",
		fileDesc: "",
		skill: "",
		version: "",
		agreeCount: "",
		userId: "",
		createTime: "",
		status: "",
		words:[]
	},
	word: {
		fileId: getQueryString("fileId"),
		content: ""
	}
};

var query = function(){
	$.ajax({
	  "url": "fileInfo/findEntity",
	  "type": "post",
	  "dataType": "json",
	  "data": {fileId:getQueryString("fileId")},
	  "success": function(response){
		 for(var key in serviceData.fileinfo){
			 serviceData.fileinfo[key] = response[key];
		 }
		 
		 console.log(serviceData);
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
  el: '#fileinfo',
  data: function(){
	  return serviceData;
  },
  methods: {
	  submit: function(){
		  $.ajax({
			  "url": "word/save",
			  "type": "post",
			  "dataType": "json",
			  "data": serviceData.word,
			  "success": function(response){
				 if(response.msg == "success"){
					 alert("评论成功!!!");
					 location.href = "file_information.jsp?fileId=" + serviceData.word.fileId;
				 }
			  },
			  "error": function(error){
				  
			  }
		   }); 
	  },
	  agree: function(count){
		  var agreeCount = parseInt(count) + 1;
		  $.ajax({
			  "url": "fileInfo/update",
			  "type": "post",
			  "dataType": "json",
			  "data": {fileId:getQueryString("fileId"), agreeCount: agreeCount},
			  "success": function(response){
				 if(response.msg == "success"){
					 alert("点赞成功!!!");
					 serviceData.fileinfo.agreeCount = agreeCount;
				 }
			  },
			  "error": function(error){
				  
			  }
		   }); 
	  }
  }
});