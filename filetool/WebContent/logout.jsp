<%@page import="com.wind.entity.UserInfo"%>
<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%
	session.invalidate();
	response.sendRedirect("login.jsp");
%>