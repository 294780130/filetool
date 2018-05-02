<%@page import="com.wind.entity.UserInfo"%>
<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%
	UserInfo userInfo = (UserInfo)session.getAttribute("currentUser");
	int type = 0;
	if(userInfo == null){
		response.sendRedirect("login.jsp");
	}else{
		type = userInfo.getType();
	}
%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">My Tool</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="index.jsp">工具查询 </a></li>
        <li><a href="tool_browse.jsp">工具浏览</a></li>
        <li><a href="upload.jsp">工具上传 </a></li>
        <%=type == 1 ? "<li><a href='manager.jsp'>系统管理</a></li>":"" %>
      </ul>
     <!--  <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form> -->
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><%=userInfo != null ? userInfo.getUserName() : "" %></a></li>
        <li><a href="logout.jsp">退出</a></li>
        <!-- <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ç¶æ <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">éåº</a></li>
            <li><a href="#">ç»åº</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li> -->
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>