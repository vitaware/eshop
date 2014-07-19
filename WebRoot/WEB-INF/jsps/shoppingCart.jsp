<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
　　　　 <TITLE>购物车</TITLE>
	<!-- Bootstrap -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/shop.css" rel="stylesheet">
		<script type="text/javascript">
			function chdel(){
				//获取要删除的checkbox --得到是数组
				var chAll=document.getElementsByName("del");
				//alert(chAll.length);
				//设置临时变量来记录checkbox是否被选中
				var temp = false;
				
				//判断是否被选中
				for(var x=0; chAll!= null&&x<chAll.length; x++){
					if(chAll[x].checked){
						temp = true;
						//alert(chAll[x].value);
					}
				}
				
				//如果被选中，则执行删除操作
				if(temp){
					var resl = window.confirm("你确定要删除？")
					if(resl){
						//alert("提交到servlet中删除");
						//获取表单信息
						var frm=document.getElementById("frm");
						frm.submit();
					}
				}
				
				//没有选中，进行提示
				if(!temp){
					alert("您还没有选中要删除的选项");
				}
			}
		</script>
	</head>
<body>
<div>
<div class="container ">
　　　<form id="frm" method="post" action="${pageContext.request.contextPath}/DelGoodsCon">
	　　　<table WIDTH=800 CELLSPACING="0" CELLPADDING="0" BORDER="1">
		
		　　　<tr>
				<td WIDTH=3%  > 
					<b>全选</b>
					<b><input type="checkbox" ></b>
				</td>
		　　　　<td WIDTH=10%  > <b>商品编号</b></td>
				<td WIDTH=25%  > <b>商品名称</b> </td>
				<td  > <b>商品描述</b></td>
				<td WIDTH=8% ALIGN=center   > <b>单价</b></td>
				<td WIDTH=8% ALIGN=center   > <b>购买数量</b></td>
				<td WIDTH=8% ALIGN=center   > <b>操作</b></td>
		　　　</tr>
			
				

			<c:forEach items="${shoppingCart.map}" var="map" varStatus="temp">
					<tr>
						<td WIDTH=5%  >
							<b><input type="checkbox" id="del" name="del" value="${map.key }"></b>
						</td>
						<td WIDTH=10%  > <b>${map.key }</b></td>
						<td WIDTH=25%  > <b>${map.value.goodsName}</b> </td>　　　　
						<td  > <b>${map.value.goodsDescription}</b></td>
						<td WIDTH=8% ALIGN=center   > <b>${map.value.goodsPrice}</b></td>
						<td WIDTH=8% ALIGN=center   > 
							<a class="" href="">-</a>  
			        		<input type="text" name="" id="" class="" maxlength="2" value="${map.value.goodsNum}" onkeyup="" style="width: 30px"/>  
			        		<a class="" href="">+</a> 
						</td>
						<td WIDTH=8% ALIGN=center   >
							<a href="${pageContext.request.contextPath}/DelOneGoodsCon?goodsCode=${map.key}">删除</a>
						</td>
					</tr>
			</c:forEach>
				
					<tr>
						<td  colspan="1" align=right  >
							<b><input type="button" value="删除选中" onclick="chdel();"/></b>
						</td>
					　　<td  colspan="2" align=right  >
								<b>共 </b>
								<b>${shoppingCart.cartSize}</b>
								<b>件商品 </b>
						</td>
							<td COLSPAN="4" align=right   >
								<b>金额总计： </b>
								<b>${shoppingCart.totalPrice}</b>
						</td>
					　</tr>
				
	　　</table>
　　</form>
</div>
</div>
	<script src="http://lib.sinaapp.com/js/jquery/1.8/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
　　</body>
</html>
