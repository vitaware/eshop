<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>物品详细信息</title>
    
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
   <!--  ${sgd} -->
   <form id="frm" method="post" action="${pageContext.request.contextPath}/DelUserServlet">
	  	
	  	<table border="1px">
	    	<tbody>
	    		<tr>
	    			<td>物品编号:</td>
	    			<td>${sgd.goodsCode}</td>
	    		</tr>
	    		<tr>
	    			<td>物品类别:</td>
	    			<td>${sgd.goodsType}</td>
	    		</tr>
	    		<tr>
	    			<td>物品名称:</td>
	    			<td>${sgd.goodsName}</td>
	    		</tr>
	    		
	    		<tr>
	    			<td>物品价格:</td>
	    			<td>${sgd.goodsPrice}</td>
	    		</tr>
	    		<tr>
	    			<td>物品库存:</td>
	    			<td>${sgd.goodsNum}</td>
	    		</tr>
	    		<tr>
	    			<td>物品状态:</td>
	    			<td>${sgd.goodsStatus}</td>
	    		</tr>
	    		<tr>
	    			<td>物品描述:</td>
	    			<td>${sgd.goodsDescription}</td>
	    		</tr>
    			<tr>
	    			<td>
	    			<span class="li_hd">购买数量：</span>
			        </td>
    				<td>
    				<a class="" href="">-</a>  
			        <input type="text" name="" id="" class="" maxlength="2" value="1" onkeyup="" style="width: 30px"/>  
			        <a class="" href="">+</a> 
    				</td>
    			</tr>
    			<tr>
	    			<th colspan="2">
	    			<a href="${pageContext.request.contextPath}/shoppingCartCon?goodsCode=${sgd.goodsCode}">添加购物车</a>
	    			</th>
    			</tr>
	    	</tbody>
	    </table>
	  </form>
    
  </body>
</html>
