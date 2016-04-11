<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>addUser</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	function pushData(){
		var url = "${pageContext.request.contextPath}/userController/addUser";
		$.ajax({
			type:"get",
			url:url,
			data:$("#frmMain").serialize(),
			success: function(data){
				
			}	
		});	
	}
</script>
</head>

<body>
	<form method="post" id="frmMain">
		<table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="password"/></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age"/></td>
            </tr>
            <tr>
                <td></td>
                <td><button onclick="pushData()">添加用户</button></td>
            </tr>
        </table>
    </form>
    <p>${addResult}</p>
</body>
</html>