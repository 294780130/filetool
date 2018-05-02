<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
	<title>主页</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css">  
	<link rel="stylesheet" href="./css/font-awesome.min.css">  
	<script src="./js/jquery.min.js"></script>  
	<!-- <script src="./js/bootstrap.min.js"></script>   -->
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
	</style>
</head>
<body>
<%@include file="head.jsp"%>
<div class="find">
	<img src="./img/search.png">
	<div class="row">
	  <div class="col-lg-3">
	  </div>
	  <div class="col-lg-6">
	    <div class="input-group input-new" id="search">
	    	<input type="text" class="form-control" aria-label="..." v-model="serviceData.keyword">
	   		<div class="input-group-btn">
	   		<button type="button" class="btn btn-default" v-on:click="search()">搜索</button>
	      </div><!-- /btn-group -->
	    </div><!-- /input-group -->
	  </div><!-- /.col-lg-6 -->
	</div><!-- /.row -->

</div>

<footer class="container-fluid foot-wrap">
	<p align="center" style="margin-top: 20px;color:#878B91;">
	    Copyright &copy;2018
	</p>
</footer>
<script type="text/javascript" src="js/app/index.js"> </script>
</body>
</html>