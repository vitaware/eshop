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
	
	<!-- Bootstrap -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/shop.css" rel="stylesheet">
	<script src="http://lib.sinaapp.com/js/jquery/1.8/jquery.min.js"></script>
  </head>
  <body>

<div class="container" >
	<div class="">
		<div class="span12">
			<div class="carousel slide" id="carousel-660455">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-660455">
					</li>
					<li data-slide-to="1" data-target="#carousel-660455">
					</li>
					<li data-slide-to="2" data-target="#carousel-660455">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="img/1.jpg" />
					</div>
					<div class="item">
						<img alt="" src="img/2.jpg" />
					</div>
					<div class="item">
						<img alt="" src="img/3.jpg" />
					</div>
				</div> <a data-slide="prev" href="#carousel-660455" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-660455" class="right carousel-control">›</a>
			</div>
		</div>
	</div>
</div>
<script src="./bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
