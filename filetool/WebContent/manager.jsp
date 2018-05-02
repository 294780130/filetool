<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
	<title>管理员管理</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css">  
	<link rel="stylesheet" href="./css/font-awesome.min.css">  
	<script src="./js/jquery.min.js"></script>  
	<script src="./js/bootstrap.min.js"></script>  
	<script src="./js/moment.js"></script>  
	<script src="./js/vue.min.js"></script>  
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
    .btn{
      height: 24px;
      font-size: 16px;
      padding-top: 0px;
    }
	</style>
</head>
<body>
<%@include file="head.jsp"%>
<div class="container" id="manage">
  <ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="manager.jsp">工具管理</a></li>
    <li role="presentation"><a href="manager_user.jsp">用户管理</a></li>
    <li role="presentation"><a href="manager_findback.jsp">误删找回</a></li>
  </ul> 


  <div class="bs-example" data-example-id="hoverable-table">
    <table class="table table-hover">
      <thead>
        <tr class="tc">
          <th>&nbsp;#</th>
          <th>&nbsp;文件名</th>
          <th>上传用户id</th>
          <th>上传时间</th>
          <th>&nbsp;&nbsp;&nbsp;&nbsp;操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="service in serviceData.services">
          <th scope="row">1</th>
          <td>{{service.fileName}}</td>
          <td>{{service.userId}}</td>
          <td>{{service.createTime | time}}</td>
          <td><button type="button" class="btn btn-warning btn" v-on:click="del(service.fileId)" onclick="javascript:alert('确认删除,该删除文件可以找回!!!')">删除</button></td>
        </tr>
      </tbody>
    </table>
  </div><!-- /example -->
</div>

<!--  <footer class="container-fluid foot-wrap">
	<p align="center" style="margin-top: 20px;color:#878B91;">
	    Copyright &copy;2018
	</p>
</footer>-->
<script src="./js/app/manage.js"></script> 
</body>
</html>