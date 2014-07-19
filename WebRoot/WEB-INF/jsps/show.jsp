<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	
		<!-- Bootstrap -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/shop.css" rel="stylesheet">
  </head>
  
  <body>
  	<div class="container">
	  <div class="row">

				<div class="col-xs-12 col-sm-8">

					<!-- START CONTENT ITEM -->
					<div class="row">
						<div class="col-xs-9">
							<h2>商品列表</h2>
						</div>
						<div class="col-xs-3">
							<div class=" social-icons pull-right bdsharebuttonbox">
								<a href="#" class="bds_more" data-cmd="more"></a><a href="#"
									class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
									<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
									<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
									<a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
							</div>
							<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"24"},"share":{},"image":{"viewList":["weixin","qzone","tsina","tqq","renren"],"viewText":"分享到：","viewSize":"24"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["weixin","qzone","tsina","tqq","renren"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
						</div>
					</div>
					<!-- END CONTENT ITEM -->

					<!-- START CONTENT ITEM -->
					<div class="row product-list-inline-small">
						<c:forEach items="${selectGoods}" var="goods" varStatus="temp">
						<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
							<div class="thumbnail">
								<a href="detail.html"><img src="http://img12.360buyimg.com/n2/jfs/t163/189/107021753/140718/266a7b21/53802224N24b92674.jpg" alt=""></a>
								<div class="caption">
								<a href="${pageContext.request.contextPath}/checkGoodsCon?goodsCode=${goods.goodsCode}">${goods.goodsName}</a>
									<p>库存：${goods.goodsNum} <span class="label label-info price pull-right">￥ ${goods.goodsPrice}</span></p>
									<a class="btn btn-success" href="${pageContext.request.contextPath}/shoppingCartCon?goodsCode=${goods.goodsCode}" >
								加入购物车
								<span class="icon-white glyphicon glyphicon-shopping-cart"></span>
								</a>
								</div>
							</div>
						</div>
						</c:forEach>

					</div>
					<!-- END CONTENT ITEM -->

					<!-- START CONTENT ITEM -->
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-6 col-md-6">
							<div class="article">
								<article>
									<img src="img/nominate.png" align="right">
									<h4>购物小助手</h4>
									<h5>Vote for us now!</h5>
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat. <a href="column3.html">More <span class="glyphicon glyphicon-chevron-right"></span></a></p>
								</article>
							</div>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-6 col-md-6">
							<div class="article">
								<article>
									<img src="img/starway.png" align="right">
									<h4>Use the star way!</h4>
									<h5>Order now!</h5>
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. <a href="column3.html">More <span class="glyphicon glyphicon-chevron-right"></span></a></p>
								</article>
							</div>
						</div>
					</div>
					<!-- END CONTENT ITEM -->

				</div>

				<div class="hidden-xs col-sm-4 col-md-4 col-lg-4">

					<!-- START CONTENT ITEM -->
					<br>
					<div class="row">
						<div class="col-xs-12">
							<div class="well well-small">
								<ul class="nav nav-list">
									<li class="nav-header">为您推荐</li>
									<li><a href="detail.html">产品  A</a></li>
									<li><a href="detail.html">产品  B</a></li>
									<li><a href="detail.html">产品  C</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- END CONTENT ITEM -->

					<!-- START CONTENT ITEM -->
					<div class="row">
						<div class="col-xs-12">
							<div class="well well-small">
								<ul class="nav nav-list">
									<li class="nav-header">热销排行</li>
									<li><a href="detail.html">Product D</a></li>
									<li><a href="detail.html">Product E</a></li>
									<li><a href="detail.html">Product F</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- END CONTENT ITEM -->

				</div>
			</div>
	  
	  </div>
	<script src="http://lib.sinaapp.com/js/jquery/1.8/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
   </body>
</html>
