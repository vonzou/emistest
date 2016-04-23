<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加字典项</title>
<jsp:include page="${request.getContextPath}/includes/include.jsp"></jsp:include>
<script type="text/javascript">
	function addCont(){
		var dictId = "${param.dictId}";
		console.log("dictId : " + dictId);
		var url = "${pageContext.request.contextPath}/dictContent/addCont";	
		
		$.ajax({
			type:"get",
			url:url,
			async:false,
			data:$("#addCont").serialize(),
			success: function(data){
				if(data.addSucc){
					alert(data.errorInfo);
				} else {
					console.log(data.errorInfo);
					alert("系统繁忙，请稍后再试");	
				}
			}
		});
		window.opener.doAfterClose(dictId);
		window.close();
	}
</script>
</head>

<body>
	<form id="addCont">
    	<input type="hidden" name="dictionaryid" value="${param.dictId}">
    	<table>
    	<tr>
        	<td>名称</td>
            <td><input type="text" name="itemname"/></td>
        </tr>
        <tr>
        	<td>值</td>
            <td><input type="text" name="itemvalue"/></td>
        </tr>
        <tr>
        	<td>排序号</td>
            <td><input type="text" name="sortinfo"/></td>
        </tr>
        <tr>
        	<td>说明</td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
        	<td>状态</td>
            <td>
                生效<input type="radio" name="status" value="1" checked="checked" style="margin-right:10px"/>
            	失效<input type="radio" name="status" value="0"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
            	<input type="button" value="提交" onclick="addCont()"/>
                <input type="button" value="取消" onclick="window.close()" style="margin-left:10px"/>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>