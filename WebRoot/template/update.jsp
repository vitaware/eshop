<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href= "${pageContext.request.contextPath }/css/calendar.css"  />
	<script type="text/javascript"  src="${pageContext.request.contextPath}/js/calendar.js" > </script>
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
 		
 		<form action="${pageContext.request.contextPath}/UMUpdateConServlet"  method="post">
    	<!-- 将用户id设置在隐藏域中 当提交的时候  携带原来的id -->
    	<input type="hidden" name="id" value="${bynamepwd.id}" />
   		<table width="60%" border="1">
   		
   		
   				<tr>
    				<td>请输入您的昵称</td>
    				<td>
    					<input type="text" name="name" value="${ username}" />  
    				</td>
    				</tr>
    				<tr>
    				<td>请输入您的密码</td>
    				<td>
    					<input type="password" name="password" value="${ password}" />  
    				</td>
    				</tr>
    				<tr>
    				<th>修改区</th>
    				</tr>
    			
    			<tr>
    				<td>修改出生日期</td>
    				<td>
    					<input type="text" name="birthday"    id="birthday"   value="${bynamepwd.birthday}"
    				 
    					 onClick="return showCalendar('birthday', 'y-mm-dd');"/> 
    				 
    				</td>
    			</tr>
    			<tr>
    			<td>修改性别</td>
    				<td>
    				
    				<input type="radio" checked="checked" name="gender"  id="sex" value = "男">男
           			<input type="radio" name="gender"  id="sex" value = "女">女
                              
    				</td>
    			</tr>
    			<tr>
    				<td>修改地址</td>
    				<td>
    				<select id="province" onchange="loadCity();">
							<option value="000">--请选择--</option>
						</select>省
						<select id="city" onchange="loadTown();">
							<option value="000">--请选择--</option>
						</select>市
						<select id="town" onchange="getAddress();">
							<option value="000">--请选择--</option>
						</select>县/区
						
    				<input type="hidden" name="address" id="address" value="${bynamepwd.address}" />	
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="submit" value="保存"/>
    				</td>
     			</tr>
    		</table>
   	</form>

  </body>
</html>
