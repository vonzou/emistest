<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script type = "text/javascript" src = "${pageContext.request.contextPath}/includes/jquery-1.11.2.min.js"></script>
  <script type = "text/javascript">
  	function showUserInfo(){
  		//alert("触发 showUserInfo 按钮");
  		var id = "054c2ad3-896b-402f-860e-5572e57c99f9";
  		$.ajax({
  			type:"get",
  			url:"${pageContext.request.contextPath}/userController/showUser/" + id,
  			success:function(data){
  				console.log("success!");
  				$("#results").append("username : " + data.username + " password : " + data.password);
				console.log("username : " + data.username);
  			}
  		});
  	}
	
	function showAllUserInfo(){
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/userController/listAllUsers",
			success: function(data){
				console.log("所有用户信息："+data);
				$.each(data, function(i,n){
					var url = "${pageContext.request.contextPath}/userController/deleteUserById/"+ n.uuid;
					var tr = "<tr><td>" + n.username + "</td><td>" + n.password + "</td><td>" + n.realname + "</td><td><a href = \"" + url + "\">删除用户</a></td></tr>";
					$("#allUserInfo").append(tr);	
				});	
			}	
		});	
	}
  </script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <button onClick = "showUserInfo()">获取用户信息</button>
    <button onClick="showAllUserInfo()">查看所有用户信息</button>
    <div id = "results"></div>
    <div>
    	<table id="allUserInfo"></table>
    </div>
  </body>
</html>
