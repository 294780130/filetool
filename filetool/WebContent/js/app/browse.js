'use strict'

var serviceData = {
	services : [],
	totalPage : "",
	skill : "program",
	goType : 0
};

var page = {
	skill: "program",
	pageNumber: "1",
	lineNumber: "3",
	keyword: "",
	orderWay: 0,
	status: 2
}

var getQueryString = function(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); 
    return null; 
}

var keyword = getQueryString("keyword")
//console.log(type);
if(keyword != null){
	page.skill = "";
	page.keyword = keyword;
	serviceData.skill = "";
}


var query = function(){
	$.ajax({
	  "url": "fileInfo/findPageList",
	  "type": "post",
	  "dataType": "json",
	  "data": page,
	  "success": function(response){
		  //console.log(response);
		  serviceData.services = response.result;
		  var totalCount = response.totalCount;
		  var lineNumber = response.lineNumber;
		  serviceData.totalPage = parseInt(totalCount/lineNumber) + (totalCount%lineNumber == 0 ? 0 : 1);
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
  el: '#browse',
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
	  go: function(value){
		  //console.log(value);
		  if(value == 0){
			  page.pageNumber = "1";
			  serviceData.goType = 0; 
		  }else if(value == -1){
			  var i = parseInt(page.pageNumber);
			  page.pageNumber = i > 1 ? i - 1 : serviceData.totalPage;
			  serviceData.goType = 1; 
		  }else if(value == 1){
			  var i = parseInt(page.pageNumber);
			  page.pageNumber = i < serviceData.totalPage ? i + 1 : "1";
			  serviceData.goType = 2; 
		  }else{
			  page.pageNumber = value;
			  serviceData.goType = 3; 
		  }
		  query();
		  //console.log(page.pageNumber);
	  },
	  order: function(value){
		  page.orderWay = value;
		  query();
	  }
  }
});