<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Tesla网上商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<!-- Bootstrap -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/shop.css" rel="stylesheet">
	<script src="http://lib.sinaapp.com/js/jquery/1.8/jquery.min.js"></script>
	
  </head>
<body>
<div class="navbar navbar-default" style="height: 30px; background: #F7F7F7;">
	<div class="container" >
		<ul class="nav navbar-nav list-inline" style="margin: 7.5px -15px;">
			<li>
				<button type="button" class="btn btn-default btn-sm">
				  <span class="glyphicon glyphicon-star"></span>收藏本站
				</button>
			</li>
			<li>
				<span class="glyphicon glyphicon-map-marker"></span>
				<span>北京<a>[更换]</a></span>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
	     <c:if test="${empty loginuser}">
  		 	 <li><a href="${pageContext.request.contextPath }/UMLoginServlet" target="index.jsp">登录</a></li>
  			 <li><a href="${pageContext.request.contextPath }/UMRegiterServlet" target="index.jsp">注册</a></li>
  		 </c:if>
  		 
  		 <c:if test="${!empty loginuser}">
  		 	  <li>${loginuser.name }欢迎回来</li>
  		 	  <li><a href="${pageContext.request.contextPath}/UMUpdateConServlet01" target="bottom">修改信息</a></li>
  		 	  <li><a href="${pageContext.request.contextPath}/UMLoginOutConServlet">退出</a></li>
  		 </c:if>
	    </ul>
	</div>
</div>
<div class="container ">
	<div class="col-lg-3 ">
				<div id="logo-2013" class="ld">
					<a href="#" hidefocus="true"
						clstag="homepage|keycount|home2013|02a"><b></b> <img
							src="http://misc.360buyimg.com/lib/img/e/logo-201305.png"
							width="270" height="60" alt="京东"> </a>
				</div>
	</div>
	<div class="col-lg-6 navbar-text">
	<form id="form1"  action="${pageContext.request.contextPath}/HGSearchkw" name="f" target="bottom">
    	<div class="input-group">
      		<input type="text" id="kw1" name="wd" class="form-control" placeholder="" >
      		<span class="input-group-btn">
        	<button class="btn btn-default btn-lg" type="submit" style="padding: 7px 16px;">
				<span class="glyphicon glyphicon-search"></span>
			</button>
      		</span>
    	</div><!-- /input-group -->
    	</form>
  	</div><!-- /.col-lg-6 -->
	<div class="col-lg-2 navbar-text">
		<a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/WatchCartCon" target="bottom">
		  <span class="glyphicon glyphicon-shopping-cart"></span>去购物车
		</a>
	</div>
</div>
		<div class="container" style="margin-bottom: 10px;">
			<ul class="nav nav-justified">
				<li class="active">
					<a href="${pageContext.request.contextPath}/template/bottom.jsp" target="bottom">首页</a>
				</li>
				<li class=" ">
					<a href="${pageContext.request.contextPath}/ShowPageCon?type=1 " target="bottom"> 服装 </a> 
				</li>
				<li class=" ">
					<a href="${pageContext.request.contextPath}/ShowPageCon?type=2 " target="bottom"> 图书 </a>
				</li>
				<li class=" ">
					<a href="${pageContext.request.contextPath}/ShowPageCon?type=3 " target="bottom"> 数码 </a>
				</li>
				<li class=" ">
					<a href="${pageContext.request.contextPath}/ShowPageCon?type=4 " target="bottom"> 家电 </a>
				</li>
				<li class=" ">
					<a href="${pageContext.request.contextPath}/ShowPageCon?type=5 " target="bottom"> 化妆品 </a>
				</li>
			</ul>
		</div>

<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/shop.js"></script>
</body>
</html>