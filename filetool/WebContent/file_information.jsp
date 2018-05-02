<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <title>文件详情</title>
  <link rel="stylesheet" href="./css/bootstrap.min.css">  
  <link rel="stylesheet" href="./css/font-awesome.min.css">  
  <script src="./js/jquery.min.js"></script>  
  <script src="./js/bootstrap.min.js"></script>
  <script src="./js/moment.js"></script>    
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
      vertical-align:left;
    }
    li:hover{
      background-color: #f7f7f7;
    }
    footer{
      position:absolute;
      bottom:0;
      width:100%;
      height:100px;
    }
    .container{
      width: 1000px;
      height: 600px;
      margin: 0 auto;
      text-align: center;
    }
    .mainArea{
    }
    .mainArea .INFArea{
      width: 100%;
      height: 200px;
      border: 1px solid #ddd;
      border-radius: 3px;
      text-align: center;
    }
    .mainArea .INFArea .top{
      height: 100px;
      border-bottom: 1px dashed #ddd;
      padding-left: 20px;
      padding-right: 20px;
      display: flex;
    }
    .mainArea .INFArea .top .icon{
      margin-top: 10px;
      margin-bottom: 10px;
      height: 80px;
      width: 80px;
    }
    .mainArea .INFArea .top .topRight{
      margin-top: 10px;
      margin-bottom: 10px;
      height: 80px;
    }
    .mainArea .INFArea .top .topRight .name{
      height: 40px;
      line-height: 40px;
      font-size: 20px;
      color: #333;
      font-weight: 700;
    }
    .mainArea .INFArea .top .topRight .tagArea{
      height: 40px;
      line-height: 40px;
      display: flex;
      padding-top: 5px;
    }
    .mainArea .INFArea .top .topRight .tagArea .tag{
      height: 26px;
      line-height: 26px;
      border-radius: 15px;
      background-color: #e33f3f;
      margin-right: 10px;
      text-align: center;
      width: 100px;
      color: #ffffff;
      font-size: 14px
    }
    .mainArea .INFArea .mid{
      height: 50px;
      display: flex;
      align-items:center;
      border-bottom: 1px dashed #ddd;
      padding-left: 20px;
      padding-right: 20px;
    }
    .mainArea .INFArea .mid .summary{
      border-radius: 5px;
      background-color: #f5f5f5;
      padding-left: 15px;
      height: 36px;
      line-height: 36px;
      width: 100%;
      text-align: left;
      font-size: 12px;
    }
    .mainArea .INFArea .bottom{
      height: 50px;
      display: flex;
      justify-content:space-between;
      align-items:center;
      padding-left: 20px;
      padding-right: 20px;
    }
    .mainArea .INFArea .bottom .goodMark{
      display: flex;
      align-items:center;
      height: 36px;
      font-size: 13px;
    }
    .mainArea .INFArea .bottom .goodMark .goodMarkButton{
      display: inline-block;
      height: 26px;
      line-height: 26px;
      padding: 0 20px;
      border-radius: 8px;
      border: 1px solid #facc16;
      font-size: 12px;
      color: #facc16;
      cursor: pointer;
      margin-right: 10px;
    }
    .mainArea .INFArea .bottom .goodMark .goodMarkNum{
      font-size: 20px;
      color: #facc16;
      margin-top: 6px;
    }
    .mainArea .INFArea .bottom .downLoadButton{
      display: inline-block;
      height: 36px;
      line-height: 36px;
      padding: 0 30px;
      border-radius: 8px;
      border: 1px solid #3fa0e3;
      font-size: 14px;
      color: #3fa0e3;
      cursor: pointer;
    }
    .mainArea .commentArea{
      width: 100%;
      border: 1px solid #ddd;
      border-radius: 3px;
      margin-top: 10px;
      text-align: center;
      padding-left: 15px;
      padding-right: 15px;
    }
    .mainArea .commentArea .tip{
      font-weight: 400;
      font-size: 16px;
      width: 100%;
      height: 15px;
      line-height: 15px;
      text-align: left;
    }
    .mainArea .commentArea input{
      border-radius: 5px;
      background-color: #f5f5f5;
      padding-left: 15px;
      height: 36px;
      line-height: 36px;
      text-align: left;
      font-size: 12px;
      width: 100%;
      border: 0px;
      margin-bottom: 20px;
    }
    .mainArea .commentArea .commentline{
      border-top: 1px dashed #ddd;
      height: 50px;
      line-height: 50px;
      display: flex;
    }
    .mainArea .commentArea .commentline .commentName{
      height: 50px;
      line-height: 50px;
      font-size: 15px;
      font-weight: bold;
    }
    .mainArea .commentArea .commentline .commentINF{
      height: 50px;
      line-height: 50px;
      font-size: 12px;
      margin-left: 10px;
    }
	.comment{
		
	}
	.com_sub{
		
	}
  </style>
</head>
<body>
<%@include file="head.jsp"%>
<div class="container" id="fileinfo">
  <div class="mainArea">
    <div class="INFArea">
      <div class="top">
        <img class="icon" src="./img/fileIcon.png">
        <div class="topRight">
          <div class="name">{{fileinfo.fileName}}</div>
			<div class="tagArea"><div class="tag">{{fileinfo.skill}}</div> </div>
        </div>
      </div>
      <div class="mid">
       <div class="summary">{{fileinfo.fileDesc}}</div> 
      </div>
      <div class="bottom">
      <div class="goodMark"><div class="goodMarkButton" v-on:click="agree(fileinfo.agreeCount)">点赞</div> 点赞数： <p class="goodMarkNum" >{{fileinfo.agreeCount}}</p> </div>
        <div class="downLoadButton"><a :href="'fileInfo/down?fileId=' + fileinfo.fileId"  target="_blank">立刻下载</a></div> 
      </div>
    </div>
    <div class="commentArea">
      <h3 class="tip">评论</h3>
      <form>
      	<input type="text"  placeholder="请输入评论" style="width:800px;" v-model="word.content" class="">
      	<button style="width:75px;" v-on:click="submit" class="btn btn-info">点击提交</button>
      </form>
      <div class="commentline" v-for="word in fileinfo.words">
        <div class="commentName">{{word.userId}}:</div>
        <div class="commentINF">{{word.content}}</div>
      </div>
      <!-- <div class="commentline">
        <div class="commentName">用户2:</div>
        <div class="commentINF">内容内容内容内容内容内容</div>
      </div>
      <div class="commentline">
        <div class="commentName">用户3:</div>
        <div class="commentINF">内容内容内容内容内容内容</div>
      </div> -->

    </div>
  </div>
</div>
<script type="text/javascript" src="js/app/fileinfo.js"> </script>
</body>
</html>