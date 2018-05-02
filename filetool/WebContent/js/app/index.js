'use strict'

var serviceData = {
	"keyword":""
};

new Vue({
  el: '#search',
  data: function(){
	  return serviceData;
  },
  methods: {
	 search: function(){
		 //alert("hello");
		 location.href = "search_result.jsp?keyword=" + serviceData.keyword;
	 }
  }
});