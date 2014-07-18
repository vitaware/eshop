<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>left</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h3>商品类型</h3>
   <a href="${pageContext.request.contextPath}/ShowPageCon?type=1 " target="right"> 服装 </a> <br> 
   <a href="${pageContext.request.contextPath}/ShowPageCon?type=2 " target="right"> 图书 </a> <br> 
   <a href="${pageContext.request.contextPath}/ShowPageCon?type=3 " target="right"> 数码 </a> <br> 
   <a href="${pageContext.request.contextPath}/ShowPageCon?type=4 " target="right"> 家电 </a> <br>
   <a href="${pageContext.request.contextPath}/ShowPageCon?type=5 " target="right"> 化妆品 </a> <br>
   <hr>
   <a href="${pageContext.request.contextPath}/shoppingCartCon?goodsCode=0" target="right"> 购物车 </a> <br>  
   
  </body>
</html>
