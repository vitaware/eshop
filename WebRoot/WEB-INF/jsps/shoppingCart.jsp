<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <br/>
　　　<center>
　　　　　<TITLE>购物车</TITLE>
　　　<font SIZE="+1">
　　　<b>购物车</b>
　　　</font>
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
<body bgcolor="#FFFFF">
　　　<br /><br />
　　　<form id="frm" method="post" action="${pageContext.request.contextPath}/DelGoodsCon">
	　　　<table WIDTH=800 CELLSPACING="0" CELLPADDING="0" BORDER="1">
		
		　　　<tr>
				<td WIDTH=3% BGCOLOR="#ECA613"> 
					<b>全选</b>
					<b><input type="checkbox" ></b>
				</td>
		　　　　<td WIDTH=10% BGCOLOR="#ECA613"> <b>商品编号</b></td>
				<td WIDTH=25% BGCOLOR="#ECA613"> <b>商品名称</b> </td>
				<td BGCOLOR="#ECA613"> <b>商品描述</b></td>
				<td WIDTH=8% ALIGN=center BGCOLOR="#ECA613" > <b>单价</b></td>
				<td WIDTH=8% ALIGN=center BGCOLOR="#ECA613" > <b>购买数量</b></td>
				<td WIDTH=8% ALIGN=center BGCOLOR="#ECA613" > <b>操作</b></td>
		　　　</tr>
			
				
			<c:forEach items="${shoppingCart.map}" var="map" varStatus="temp">
					<tr>
						<td WIDTH=5% BGCOLOR="#ECA613">
							<b><input type="checkbox" id="del" name="del" value="${map.key }"></b>
						</td>
						<td WIDTH=10% BGCOLOR="#ECA613"> <b>${map.key }</b></td>
						<td WIDTH=25% BGCOLOR="#ECA613"> <b>${map.value.goodsName}</b> </td>　　　　
						<td BGCOLOR="#ECA613"> <b>${map.value.goodsDescription}</b></td>
						<td WIDTH=8% ALIGN=center BGCOLOR="#ECA613" > <b>${map.value.goodsPrice}</b></td>
						<td WIDTH=8% ALIGN=center BGCOLOR="#ECA613" > 
							<a class="" href="">-</a>  
			        		<input type="text" name="" id="" class="" maxlength="2" value="${map.value.goodsNum}" onkeyup="" style="width: 30px"/>  
			        		<a class="" href="">+</a> 
						</td>
						<td WIDTH=8% ALIGN=center BGCOLOR="#ECA613" >
							<a href="${pageContext.request.contextPath}/DelOneGoodsCon?goodsCode=${map.key}">删除</a>
						</td>
					</tr>
			</c:forEach>
				
					<tr>
						<td  colspan="1" align=right BGCOLOR="#ECA613">
							<b><input type="button" value="删除选中" onclick="chdel();"/></b>
						</td>
					　　<td  colspan="2" align=right BGCOLOR="#ECA613">
								<b>共 </b>
								<b>${shoppingCart.cartSize}</b>
								<b>件商品 </b>
						</td>
							<td COLSPAN="4" align=right BGCOLOR="#ECA613" >
								<b>金额总计： </b>
								<b>${shoppingCart.totalPrice}</b>
						</td>
					　</tr>
				
				
	　　</table>
　　</form>

　　</center>
　　</body>
</html>
