<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>工具浏览</title>
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
      .bot{
        position: absolute;
        top: 580px;
        left: 42.5%;
        text-align: center;
      }
      .left{
        width: 320px;
        height: 580px;
        float: left;
      }
      .right{
        width: 1100px;
        height: 580px;
        float: left;
      }
      .top{
        height: 80px;
      }
      .mid .left button{
        text-align: center;
      }
      .left .center{
        text-align: center;
      }
      .bgwhite{
        margin-left: 5px;
        margin-right: 5px;
        background-color: white;
      }
      .listArea{
        margin-top: -9px;
        margin-left: 5px;
        margin-right: 5px;
        padding-right: 15px;
        padding-left: 15px;
        height: 450px;
        border: 1px solid #ddd;
        border-radius: 5px;
      }
      .listArea .itemLine{
        display: flex;
        margin-left: 5px;
        margin-right: 5px;
        height: 90px;
        border-bottom: 1px dashed #ddd;
      }
      .listArea .itemLine .icon{
        margin-top: 10px;
        margin-bottom: 10px;
        height: 70px;
        width: 70px;
      }
      .listArea .itemLine .infBox{
        margin-left: 12px;
        margin-top: 10px;
        width: 93%;
        height: 70px;
      }
      .listArea .itemLine .infBox .name{
        font-size: 20px;
        color: #333;
        font-weight: 700;
        height: 50px;
      }
      .listArea .itemLine .infBox .FileinfBox{
        display: flex;
        font-family: 'Microsoft YaHei',Arial;
        font-size: 12px;
        color:#999999;
        height: 20px;
        line-height: 20px;
      }
      .listArea .itemLine .infBox .Fileinf{
        font-size:10px;
        height: 20px;
        line-height: 21px;
      }

    </style>
</head>
<body>
	<%@include file="head.jsp"%>

<div class="mid" id="browse">
  <div class="left">
    <div class="panel panel-default">
      <div class="panel-body center">
        分类查询
      </div>
    </div>
    <div class="list-group">
    	<a href="javascript:void(0)" v-on:click="select('program')">
      	<button type="button" class="list-group-item" v-bind:class="serviceData.skill == 'program' ? 'active' : ''">编程类</button>
      	</a>
      <a href="javascript:void(0)" v-on:click="select('media')">
   		<button type="button" class="list-group-item" v-bind:class="serviceData.skill == 'media' ? 'active' : ''">多媒体类</button>
   	</a>
     <a href="javascript:void(0)" v-on:click="select('editor')">
      	<button type="button" class="list-group-item" v-bind:class="serviceData.skill == 'editor' ? 'active' : ''">编辑类</button>
      </a>
      <a href="javascript:void(0)" v-on:click="select('env')">
      	<button type="button" class="list-group-item" v-bind:class="serviceData.skill == 'env' ? 'active' : ''">环境类</button>
      </a>
      <a href="javascript:void(0)" v-on:click="select('office')">
      	<button type="button" class="list-group-item" v-bind:class="serviceData.skill == 'office' ? 'active' : ''">工具类</button>
      </a>
      <a href="javascript:void(0)" v-on:click="select('image')">
      	<button type="button" class="list-group-item" v-bind:class="serviceData.skill == 'image' ? 'active' : ''">图像处理类</button>
      </a>
      <a href="javascript:void(0)" v-on:click="select('other')">
      	<button type="button" class="list-group-item" v-bind:class="serviceData.skill == 'other' ? 'active' : ''">其他</button>
      </a>
    </div>
  </div>
  <div class="right">
    <div class="top">
        <nav class="navbar navbar-default bgwhite">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">默认排序</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">按时间排序<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="javascript:void(0)" v-on:click="order(0)">时间降序</a></li>
                    <li><a href="javascript:void(0)" v-on:click="order(1)">时间升序</a></li>
                  </ul>
                </li>
              </ul>
              <ul class="nav navbar-nav">
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">按点赞数排序<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="javascript:void(0)" v-on:click="order(2)">点赞降序</a></li>
                    <li><a href="javascript:void(0)" v-on:click="order(3)">点赞升序</a></li>
                  </ul>
                </li>
              </ul>

            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
    </div>

    <div class="listArea">
      <div class="itemLine" v-for="service in serviceData.services">
      	<img src="./img/fileIcon.png" class="icon">
        <div class="infBox">
          <div class="name"><a :href="'file_information.jsp?fileId=' + service.fileId">{{service.fileName}} </a>  <a :href="'fileInfo/down?fileId=' + service.fileId"  target="_blank">下载</a></div>
          <div class="FileinfBox">
          	简介: <p class="Fileinf">{{service.fileDesc}}
          	
          	<span style="margin-left:30px;">点赞:{{service.agreeCount}}</span>
          		<span style="margin-left:30px;">{{service.createTime | time}}</span>
          	</p>
          
          </div>
        </div>
      </div>
    </div>

    <div class="bot">
      <nav aria-label="Page navigation">
        <ul class="pagination">
          <!-- <li>
            <a href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li> -->
             <li v-bind:class="goType == 0 ? 'active' : ''"><a href="javascript:void(0)"  v-on:click="go(0)">首页 </a></li>
          <li v-bind:class="goType == 1 ? 'active' : ''"><a href="javascript:void(0)"  v-on:click="go(-1)">上一页</a></li>
          <li v-bind:class="goType == 2 ? 'active' : ''"><a href="javascript:void(0)"  v-on:click="go(1)">下一页 </a></li>
          <li v-bind:class="goType == 3 ? 'active' : ''"><a href="javascript:void(0)"  v-on:click="go(serviceData.totalPage)">尾页 </a></li>
         <!--  <li>
            <a href="#" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li> -->
        </ul>
      </nav>
    </div>
  </div>
</div>

<footer class="container-fluid foot-wrap">
	<p align="center" style="margin-top: 20px;color:#878B91;">
	    Copyright &copy;2018
	</p>
</footer>
<script src="./js/app/browse.js"></script>  
</body>
</html>