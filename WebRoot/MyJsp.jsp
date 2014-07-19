<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--
　　　　Inventory.jsp -
　　　　显示商品目录并且获取用户购买的物品及其数量单价等信息 
-->

<html>
　　　　　<TITLE>购物车</TITLE>

<head>
	<!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://lib.sinaapp.com/js/jquery/1.8/jquery.min.js"></script>

</head>
　　		
<body bgcolor="#FFFFF">

　　　<form method="post" action="">
	　　　<table WIDTH=450 CELLSPACING="0" CELLPADDING="0" BORDER="1">
	　　　<%--
	　　　　创建表头
	　　　--%>
	　　　<tr>
	　　　　<td WIDTH=10% BGCOLOR="#ECA613"> <b>商品编号</b></td>
			<td WIDTH=25% BGCOLOR="#ECA613"> <b>商品名称</b> </td>　　　　
			<td BGCOLOR="#ECA613"> <b>商品描述</b></td>
			<td WIDTH=8% ALIGN=center BGCOLOR="#ECA613" > <b>单价</b></td>
			<td WIDTH=8% ALIGN=center BGCOLOR="#ECA613" > <b>购买数量</b></td>
	　　　</tr>
	　　　<tr>
	　　　　<td COLSPAN=5 align=right BGCOLOR="#ECA613">
			<b>总共人民币元 </b>
			</td>
	　　　</tr>
	　　</table>
	
　　</form>
　　</body>
　　</html> 


