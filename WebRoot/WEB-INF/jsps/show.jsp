<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>show</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/del.js"></script>
	-->
	<script type="text/javascript">
		function selectAll(){
			alert("select all");
		}
	</script>
  </head>
  
  <body>
	 
	  <form id="frm" method="post" action="${pageContext.request.contextPath}/DelUserServlet">
	  	
	  	<table border="1px">
	    	<tbody>
	    		<tr>
	    			<td>物品名称</td>
	    			<td>物品价格</td>
	    			<td>库存</td>
	    		</tr>
	    	</tbody>
	    	
	    	 <!-- 获取 作用域中的  属性名称为 findAllSer 的值 进行遍历
		         		遍历后的数据 为User对象  存放到了  userall 里面
		         		再通过 userall 获取到 User里面的各个属性值
		         		${pageContext.request.contextPath}/UpdateServlet?userId=${allSerUser.id}
		          -->
	    	<c:forEach items="${selectGoods}" var="goods" varStatus="temp">
	    		<tbody>
	    			<tr>
	    				<td>${goods.goodsName}</td>
	    				<td>${goods.goodsPrice}</td>
	    				<td>${goods.goodsNum}</td>
	    				<td><a href="${pageContext.request.contextPath}/checkGoodsCon?goodsCode=${goods.goodsCode}">查看</a></td>
	    				<td><a href="${pageContext.request.contextPath}/shoppingCartCon?goodsCode=${goods.goodsCode}">添加购物车</a></td>
	    			</tr>
	    		</tbody>
	    	</c:forEach>
	    </table>
	  </form>
   </body>
</html>
