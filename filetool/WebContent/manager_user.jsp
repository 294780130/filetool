<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <title>用户管理</title>
  <link rel="stylesheet" href="./css/bootstrap.min.css">  
  <link rel="stylesheet" href="./css/font-awesome.min.css">  
  <script src="./js/jquery.min.js"></script>  
  <script src="./js/bootstrap.min.js"></script>  
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
<!-- navç»æ -->
<div class="container" id="userinfo">
  <ul class="nav nav-tabs">
    <li role="presentation"><a href="manager.jsp">工具管理</a></li>
    <li role="presentation" class="active"><a href="manager_user.jsp">用户管理</a></li>
    <li role="presentation"><a href="manager_findback.jsp">误删找回</a></li>
  </ul> 


  <div class="bs-example" data-example-id="hoverable-table">
    <table class="table table-hover">
      <thead>
        <tr class="tc">
          <th>&nbsp;#</th>
          <th>&nbsp;用户ID</th>
          <th>&nbsp;&nbsp;用户名</th>
          <th>&nbsp;&nbsp;用户类型</th>
          <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;权限操作</th>
          <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="service in serviceData.services">
          <th scope="row">1</th>
          <td>{{service.userId}}</td>
          <td>{{service.userName}}</td>
          <td>{{service.type == 1 ? "管理员" : "普通用户"}}</td>
          <td><button type="button" class="btn btn-primary btn" v-on:click="update(service.userId, (service.type == 1 ? 0 : 1))">{{service.type == 1 ? "降级成用户":"升级管理员"}}</button></td>
          <td><button type="button" class="btn btn-danger" v-on:click="del(service.userId)" onclick="javascript:alert('确认删除该用户!!!')">删除用户</button></td>
        </tr>
      </tbody>
    </table>
  </div><!-- /example -->
</div>

<footer class="container-fluid foot-wrap">
  <p align="center" style="margin-top: 20px;color:#878B91;">
      Copyright &copy;2018
  </p>
</footer>
<script src="./js/app/userinfo.js"></script> 
</body>
</html>