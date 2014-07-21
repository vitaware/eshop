<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href= "${pageContext.request.contextPath }/css/calendar.css"  />
		<!-- Bootstrap -->
		<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
		<script src="http://lib.sinaapp.com/js/jquery/1.8/jquery.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/shop.css" rel="stylesheet">
    
	<script type="text/javascript" src="js/ajaxUtil.js"></script>
		<script type="text/javascript">
			function validateUname(){
				var uname = document.getElementById("uname").value;
				sendAjaxGet("UserController","operType=validateUname&uname="+uname+"&random="+Math.random(),function(request){
					if(request.responseText=="false"){
						alert(request.responseText);
					}
				});
			}
			function loadProvince(){
				loadAddress(0,"province");
			}
			function loadCity(){
				var parentid = document.getElementById("province").value;
				//清空掉数据
				document.getElementById("city").length=1;
				document.getElementById("town").length=1;
				if(parentid!="000"){
					loadAddress(parentid,"city");
				}
			}
			function loadTown(){
				var parentid = document.getElementById("city").value;
				document.getElementById("town").length=1;
				if(parentid!="000"){
					loadAddress(parentid,"town");
				}
			}
			function loadAddress(parentid,objId){
				sendAjaxPost("LoadAddressServlet","parentid="+parentid,function(request){
					var result = request.responseText;
					eval("var addresses = " + result);
					if(addresses.length>0){
						var obj = document.getElementById(objId);
						for(var i=0;i<addresses.length;i++){
							obj.add(new Option(addresses[i].name,addresses[i].id));
						}
					}
				});
			}
			
			function getAddress(){
				var obj1 = document.getElementById("province");
				var obj2 = document.getElementById("city");
				var obj3 = document.getElementById("town");
				var province = obj1.options[obj1.selectedIndex].text;
				var city = obj2.options[obj2.selectedIndex].text;
				var town = obj3.options[obj3.selectedIndex].text;
				document.getElementById("address").value=province+city+town;
			}
		</script>
  </head>
  
  <body style="text-align: center;" onload="loadProvince();">
		<div class="container">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							欢迎注册！
						</h3>
					</div>
					<div class="panel-body">
						<form accept-charset="UTF-8"action="${pageContext.request.contextPath}/UMRegServlet"  class="new_user"
							id="new_user" method="post">
							<div class="form-group">
								<label for="user_username">
									用户名
								</label>
								<input autofocus="autofocus" class="form-control"
									id="user_username" name="username" type="text" value="${formbean.name }">
								<span>${formerror.errorname} </span>
							</div>
							<div class="form-group">
								<label for="user_password">
									密码
								</label>
								<input class="form-control" id="user_password"
									name="pwd" type="password">
									<span>${formerror.errorpwd}</span>
							</div>
							<div class="form-group">
								<label for="user_password_confirmation">
									密码确认
								</label>
								<input class="form-control" id="user_password_confirmation"
									name="repwd" type="password">
								<span>${formerror.errorrepwd}</span>
							</div>
							<div class="form-group">
								<label for="user_email">
									收货地址
								</label>
								<select  id="province" onchange="loadCity();">
									<option value="000">--请选择--</option>
								</select>省
								<select id="city" onchange="loadTown();">
									<option value="000">--请选择--</option>
								</select>市
								<select id="town" onchange="getAddress();">
									<option value="000">--请选择--</option>
								</select>县/区
				
    						<input type="hidden" name="address" id="address" value="${formbean.address}" >
								
							</div>
							<div class="form-group">
								<label for="user_phone">
									性别
								</label>
								<input type="radio" checked="checked" name="gender"  id="sex" value = "男"/>男
           						<input type="radio" name="gender"  id="sex" value = "女"/>女
							</div>
							<div class="form-group">
								<label for="user_birthday">
									生日
								</label>
								<input class="Wdate form-control " id="user_birthday" name="birthday"
									type="text" onClick="WdatePicker()" style="height: 34px;" value="${formbean.birthday}">
								<span>${formerror.birthday}</span>
							</div>
							<div>
								<input class="btn btn-lg btn-block btn-success" name="commit"
									type="submit" value="提交">
							</div>
						</form>
					</div>
					<div class="panel-footer">
						已经阅读并同意
						<a href="./terms">我们的条款</a>.
					</div>
				</div>
			</div>

			<div class="col-md-6 col-md-offset-3 prose">
				<h4>
				</h4>
				<p>
					amazing happens
				</p>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
   	
  </body>
</html>
