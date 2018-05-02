<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
	<title>工具上传</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css">  
	<link rel="stylesheet" href="./css/font-awesome.min.css">  
	<script src="./js/jquery.min.js"></script>  
	<script src="./js/bootstrap.min.js"></script> 
	<script src="js/vue.min.js"></script>  
	<link rel="icon" href="./img/logo.ico">
	<style type="text/css">
		.find{
			text-align: center;
			padding-top: 80px;
		}
		img{
			width: 100px;
			margin-bottom: 80px;
		}
		li:hover{
			background-color: #e7e7e7;
		}
		footer{
			position:absolute;
			bottom:0;
			width:100%;
			height:100px;
		}
    .container{
        width: 1000px;
        height: 620px;
        background-color: #eee;
    }
    .mid{
      text-align: center;
    }
    .form{
      margin: 40px;
      width: 880px;
      height: 400px;
    }
    .mar{
      margin-bottom: 30px;
    }
    .lh{
      line-height: 20px;
    }
    .lh26{
      line-height: 26px;
    }
    .lh46{
      line-height: 46px;
    }
    .lh60{
      line-height: 60px;
    }
    .red{
      color: red;
    }
    b{
      font-weight: normal;
      color: red;
    }
    .pad{
      margin-top: 27px;
    }
    .filename{
      display: block;
    }
    .sub{
      width: 1000px;
      text-align: center;
      float: left;
    }
	</style>
</head>
<body>
	<%@include file="head.jsp"%>

<div class="container">
  <h2 class="mid">工具上传 </h2>
  <p>请根据提示，按要求完成所有内容填写后开始上传工具！</p>
  <div class="form">
    <form class="form-horizontal" id= "uploadForm">
      <div class="form-group">
       <label for="inputEmail3" class="col-sm-3 control-label lh20" name="">工具版本<b>*</b></label>
        <div class="col-sm-7 mar">
          <input type="text" id="name" class="form-control" placeholder="工具版本·" name="version">
        </div> 
        <label for="inputEmail3" class="col-sm-3 control-label lh60">工具说明<b>*</b></label>
        <div class="col-sm-7 mar">
          <textarea class="form-control" id="explain" rows="3" placeholder="说明" name="fileDesc"></textarea>
        </div>
        <label for="inputEmail3" id="category" class="col-sm-3 control-label lh46">选择标签<b>*</b></label>
        <div class="col-sm-7 mar">
          <label class="radio-inline">
            <input type="radio" id="inlineRadio1" value="program" checked="checked" name="skill"> 程序类
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </label>
          <label class="radio-inline">
            <input type="radio" id="inlineRadio2" value="media" name="skill">媒体类&nbsp;&nbsp;&nbsp;
          </label>
          <label class="radio-inline">
            <input type="radio"  id="inlineRadio3" value="editor" name="skill"> 编辑类
          </label>
          <label class="radio-inline">
            <input type="radio" id="inlineRadio4" value="env" name="skill"> 环境类
          </label>
          <br>
          <label class="radio-inline">
            <input type="radio" id="inlineRadio5" value="office" name="skill"> 办公类
          </label>
          <label class="radio-inline">
            <input type="radio" id="inlineRadio6" value="image" name="skill"> 图像处理类
          </label>
          <label class="radio-inline">
            <input type="radio" id="inlineRadio7" value="other" name="skill"> 其他类
          </label>
        </div>
         <label for="jobData" class="col-sm-3 control-label" style="float:left;padding-left:15px;">工具上传 <b>*</b></label>
        <div class="col-sm-7 mar">
           <div class="col-xs-12 col-sm-4 col-md-4">
              <div class="file-container" style="display:inline-block;position:relative;overflow: hidden;vertical-align:middle">
                  <button class="btn btn-success fileinput-button" type="button">选择文件</button>
                  <input type="file" id="jobData" onchange="loadFile(this.files[0])" style="position:absolute;top:0;left:0;font-size:34px; opacity:0" name="file">
              </div>
              <span id="filename" style="vertical-align: middle" class="filename"> &nbsp;未上传文件</span>
          </div>
          <script>
          function loadFile(file){
              $("#filename").html(file.name);
          }
          </script>
        </div>  
        
        <label for="inputEmail3" class="col-sm-3 control-label lh60">上传进度<span>:</span></label>
        <div class="col-sm-7 mar">
          <div class="progress pad">
            <div class="progress">
			  <div class="progress-bar progress-bar-striped" v-bind:class="progress.status == '1' ? 'progress-bar-success' : 'progress-bar-danger'"  id="progress" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
			    <span class="sr-only"><!-- 40% Complete (success) --></span>
			  </div>
			</div>
          </div>
        </div>
        <div class="sub">
        <button type="button" class="btn btn-default" v-on:click="checkform()">提交</button>
        </div>
      </div>
      
    </form>
  </div>
</div>

<script type="text/javascript">  
var progress = {
	status : 1
}


new Vue({
	  el: '#uploadForm',
	  data: function(){
		  return progress;
	  },
	  methods: {
		 checkform: function(){ 
			 if(document.getElementById('name').value.length==0){    
			        alert("版本号不能为空");
			        document.getElementById('name').focus();
			        return false;
			    }
			    if(document.getElementById('explain').value.length==0){    
			        alert('工具说明不能为空');
			        document.getElementById('explain').focus();
			        return false;
			    }
			    
			    var i = 0;
			    var timer = setInterval(function(){
			    	i++;
			    	//console.log(i);
			    	$("#progress").css("width", (i*10) + "%");
			    	if(i == 10){
			    		 clearInterval(timer);
			    	}
			    }, 10);
			    
			    var formData = new FormData($("#uploadForm")[0]);  
			    //console.log(formData);
			    
			    setTimeout(function(){
			    	$.ajax({  
				         url: 'fileInfo/upload' ,  
				         type: 'post',  
				         data: formData,  
				         //async: false,  
				         cache: false,  
				         contentType: false,  
				         processData: false,  
				         success: function (response) { 
				        	 clearInterval(timer);
				        	 $("#progress").css("width", "100%");
				        	 i = 0;
				        	if(response.status == 1){
				        		alert("上传成功");
				        		progress.status = 1;
				        	}else{
				        		alert("上传失败");
				        		progress.status = 0;
				        	}
				         },  
				         error: function (response) {  
				        	 clearInterval(timer);
				        	 $("#progress").css("width", "100%");
				        	 i = 0;
			        	 	 alert("上传失败");
			        		 progress.status = 0;
				         }  
				    });  
			    }, 1000);
		 } 
	  }
});


</script>

</body>
</html>